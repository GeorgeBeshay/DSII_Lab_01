package AVL_Tree;

import RB_Tree.RB_Node;
import RB_Tree.Tree;

import java.util.ArrayList;

public class AVL_Tree<T extends Comparable<T>>  {
    private AVL_Node<T> root;
    private int size;

    public AVL_Tree() {
        root = null;
        size = 0;
    }


    public AVL_Tree<T> insert (T data) {
        root = insert(data , root);
        return this;
    }
    public void delete(T data) {
        root = delete(data , root);
    }
    public boolean search(T data) {
        if(search(data, root) != null)
            return true;
        return false;
    }


    public long getSize() { return size; }
    public long getHeight() {return root.height; }
    public AVL_Node getRootNode() { return root; }
    //public void traverse() { traverseInOrder(root); }

    public boolean isEmpty() { return root == null; }

    public ArrayList<RB_Node<T>> traverse(){
        return null;
    }

//    private void traverseInOrder(AVL_Node<T> node) {
//        if(node != null) {
//            traverseInOrder(node.left);
//            System.out.print(node.data+" ");
//            traverseInOrder(node.right);
//        }
//    }


    private AVL_Node<T> insert(T data, AVL_Node<T> root) {
        if(root == null) {
            size++;
            return new AVL_Node<T>(data);
        }
        if(data.compareTo(root.data) > 0) {
            if(root.right != null)
                root.right = insert(data, root.right);
            else {
                AVL_Node<T> newNode= new AVL_Node(data);
                newNode.parent = root;
                root.right = newNode;
                size++;
            }
        }
        else if(data.compareTo(root.data) < 0) {
            if(root.left != null)
                root.left = insert(data, root.left);
            else {
                AVL_Node<T> newNode= new AVL_Node(data);
                newNode.parent = root;
                root.left = newNode;
                size++;
            }
        }
        else {
            System.out.println("Node already exists");
            return root;
        }
        updateHeight(root);
        updateBalanceFactor(root);
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
            if (root.left == null)              // Non or Single child
                return root.right;
            else if(root.right == null )
                return root.left;
            root.data = getMax(root.left);      // two children
            root.left = delete(root.data , root.left);
            size--;
        }
        updateHeight(root);
        updateBalanceFactor(root);
        return doSuitableRotation(root);
    }


    private AVL_Node<T> search(T data, AVL_Node<T> root) {
        if(root == null) {
            System.out.println(data + " does not exist in the tree");
            return null;
        }
        if(data.compareTo(root.data) < 0) return search(data, root.left);
        else if(data.compareTo(root.data) > 0) return search(data, root.right);
        else return root;
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

    private AVL_Node<T> doSuitableRotation(AVL_Node node) {
        if(node.balanceFactor < -1) {
            if(node.right.balanceFactor > 0)
                node.right = rightRotation(node.right);
            return leftRotation(node);
        }
        else if(node.balanceFactor > 1) {
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