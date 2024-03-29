package AVL_Tree;

import Abstractions.Super_Tree;
import Services.Concrete_FS;
import Services.File_Scanner_IF;
import java.util.ArrayList;
import java.util.List;

public class AVL_Tree<T extends Comparable<T>>  implements Super_Tree<T> {
    private AVL_Node<T> root;
    private long size;

    public AVL_Tree() {
        root = null;
        size = 0;
    }
    @Override
    public boolean insert (T data) {
        long lastSize = size;
        root = insert(data , root);
        return lastSize != size;
    }

    @Override
    public boolean delete(T data) {
        long lastSize = size;
        root = delete(data , root);
        return lastSize != size;
    }

    @Override
    public boolean search(T data) {
        return search(data, root);
    }

    @Override
    public long getSize() { return size; }
    @Override
    public long getHeight() {
        if(root == null) return -1;
        return root.height;
    }

    @Override
    public long batchInsert(String fileName) {
        int counter = 0;
        //fileName += ".txt";
        Concrete_FS<T> concrete = new Concrete_FS<>();
        List<T> data = concrete.importData(fileName);
        for(T item : data)
            if(insert(item))
                counter++;
        System.out.println("inserted elements count is "+ counter);
        System.out.println("Already existing elements are "+(data.size() - counter));
        return counter;
    }

    @Override
    public long batchDelete(String fileName) {
        int counter = 0;
        //fileName += ".txt";
        Concrete_FS<T> concrete = new Concrete_FS<>();
        List<T> data = concrete.importData(fileName);
        //System.out.println(delete(data.size()));
        for(T item : data) {
            if(delete(item))
                counter++;
        }
        System.out.println("deleted elements count is " + counter);
        System.out.println("non existing elements are " + (data.size() - counter));
        return counter;
    }

    @Override
    public void export(String filePath) {
        List<T> myList = new ArrayList<>();
        traverseInOrder(root, myList);
        System.out.println(myList.size());
        File_Scanner_IF<T> dataScanner = new Concrete_FS<>();
        dataScanner.exportData(filePath, myList);
    }

    private void traverseInOrder(AVL_Node<T> node, List<T> myList) {
        if(node != null) {
            traverseInOrder(node.left, myList);
            myList.add(node.data);
            traverseInOrder(node.right, myList);
        }
    }

    public AVL_Node<T> getRootNode() { return root; }
    public void traverse() {
        traverseInOrder(root);
        System.out.println();
    }

    public boolean isEmpty() { return root == null; }


    private void traverseInOrder(AVL_Node<T> node) {
        if(node != null) {
            traverseInOrder(node.left);
            System.out.print(node.data+" ");
            traverseInOrder(node.right);
        }
    }
    private AVL_Node<T> insert(T data, AVL_Node<T> root) {
        if(root == null) {
            size++;
            return new AVL_Node<T>(data);
        }
        if(data.compareTo(root.data) > 0) {
            if(root.right != null)
                root.right = insert(data, root.right);
            else {
                AVL_Node<T> newNode= new AVL_Node<>(data);
                newNode.parent = root;
                root.right = newNode;
                size++;
            }
        }
        else if(data.compareTo(root.data) < 0) {
            if(root.left != null)
                root.left = insert(data, root.left);
            else {
                AVL_Node<T> newNode= new AVL_Node<>(data);
                newNode.parent = root;
                root.left = newNode;
                size++;
            }
        }
        else {
            System.out.println("Node " + data + " already exists");
            return root;
        }
        updateHeight(root);
        return doSuitableRotation(root);
    }
    private AVL_Node<T> delete(T data , AVL_Node<T> root) {
        if(root == null) {
            System.out.println(data + " does not exist in the tree");
            return null;
        }
        if(data.compareTo(root.data) < 0)        // go left
            root.left = delete(data, root.left);
        else if (data.compareTo(root.data) > 0)     // go right
            root.right = delete(data, root.right);
        else {                                          // it's the exact node
            if (root.left == null) {              // Non or Single child
                size--;
                return root.right;
            }
            else if(root.right == null ) {
                size--;
                return root.left;
            }
            root.data = getMax(root.left);      // two children
            root.left = delete(root.data , root.left);
        }
        updateHeight(root);
        return doSuitableRotation(root);
    }


    private boolean search(T data, AVL_Node<T> root) {
        if(root == null) {
            //System.out.println(data + " does not exist in the tree");
            return false;
        }
        if(data.compareTo(root.data) < 0) return search(data, root.left);
        else if(data.compareTo(root.data) > 0) return search(data, root.right);
        else return true;
    }

    private T getMax(AVL_Node<T> predecessor_Node) {
        if (predecessor_Node.right != null)
            return getMax(predecessor_Node.right);
        return predecessor_Node.data;
    }

    private T getMin(AVL_Node<T> successor_Node) {
        if (successor_Node.left != null)
            return getMin(successor_Node.left);
        return successor_Node.data;
    }
    public T getMax() {
        return getMax(root);
    }

    public T getMin() {
        return getMin(root);
    }

    private AVL_Node<T> doSuitableRotation(AVL_Node<T> node) {
        updateBalanceFactor(node);
        if(node.balanceFactor < -1) {
            updateBalanceFactor(node.right);
            if(node.right.balanceFactor > 0)
                node.right = rightRotation(node.right);
            return leftRotation(node);
        }
        else if(node.balanceFactor > 1) {
            updateBalanceFactor(node.left);
            if(node.left.balanceFactor < 0)
                node.left = leftRotation(node.left);
            return rightRotation(node);
        }
        return node;
    }
    private AVL_Node<T> rightRotation(AVL_Node<T> node) {
        AVL_Node<T> middleNode = node.left;
        AVL_Node<T> CenterNode = middleNode.right;
        middleNode.right = node;
        node.left = CenterNode;
        if(CenterNode != null) CenterNode.parent = node;
        middleNode.parent = node.parent;
        node.parent = middleNode;
        updateHeight(node);
        updateHeight(middleNode);
        return middleNode;
    }

    private AVL_Node<T> leftRotation(AVL_Node<T> node) {
        AVL_Node<T> middleNode = node.right;
        AVL_Node<T> CenterNode = middleNode.left;
        middleNode.left = node;
        node.right = CenterNode;
        if(CenterNode != null) CenterNode.parent = node;
        middleNode.parent = node.parent;
        node.parent = middleNode;
        updateHeight(node);
        updateHeight(middleNode);
        return middleNode;
    }

    private void updateHeight(AVL_Node<T> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(AVL_Node<T> node) {
        return node == null ? -1 : node.height;
    }

    private void updateBalanceFactor(AVL_Node<T> node) {
        node.balanceFactor = height(node.left) - height(node.right);
    }

}
