package RB_Tree;

import Abstractions.Super_Tree;
import Services.Concrete_FS;
import Services.File_Scanner_IF;

import java.util.*;

public class RB_Tree<T extends Comparable<T>> implements Super_Tree<T> {

    private RB_Node<T> root;
    private long size;

    public RB_Tree(){
        this.root = null;
        this.size = 0;
    }

    public RB_Node<T> getRoot() {
        return root;
    }

    @Override
    public boolean insert(T data) {
        RB_Node<T> nodeToBeInserted = new RB_Node<>(data);
        long tempSize = this.size;
        root = insert(root, nodeToBeInserted);
        recolorAndRotate(nodeToBeInserted);
        return (tempSize != this.size);
    }

    public void recolorAndRotate(RB_Node<T> node){
        RB_Node<T> parent = node.getParent();
        if(parent != null && parent != root && parent.isRed()){
            RB_Node<T> grandParent = parent.getParent();
            RB_Node<T> uncle = (parent.isLeftChild() ? grandParent.getRightChild() : grandParent.getLeftChild());
            if(uncle != null && uncle.isRed()){
                // Change colors of the parent, grandparent, uncle, recursion @grandparent
                handleRecoloring(parent, uncle, grandParent);
            } else if(parent.isLeftChild()){
                // either left left case or left right case in addition to recoloring.
                handleLeftSituation(node, parent, grandParent);
            } else {
                // either right right case or right left case in addition to recoloring.
                handleRightSituation(node, parent, grandParent);
            }
        }
        root.setRed(false);
    }

    public void handleLeftSituation(RB_Node<T> node, RB_Node<T> parent, RB_Node<T> grandParent){
        if(!node.isLeftChild()){
            leftRotate(parent);
            node.flipColor();
        } else
            parent.flipColor();
        grandParent.flipColor();
        rightRotate(grandParent);
//        recolorAndRotate(!node.isLeftChild() ? node : parent);
    }

    public void handleRightSituation(RB_Node<T> node, RB_Node<T> parent, RB_Node<T> grandParent){
        if(node.isLeftChild()){
            rightRotate(parent);
            node.flipColor();
        } else
            parent.flipColor();
        grandParent.flipColor();
        leftRotate(grandParent);
//        recolorAndRotate();
    }

    public void rightRotate(RB_Node<T> node) {
        RB_Node<T> leftChild = node.getLeftChild();
        node.setLeftChild(leftChild.getRightChild());
        if(leftChild.getRightChild() != null)
            leftChild.getRightChild().setParent(node);
        leftChild.setRightChild(node);
        leftChild.setParent(node.getParent());
        changeParent(leftChild, node);
        node.setParent(leftChild);
    }

    public void leftRotate(RB_Node<T> node){
        RB_Node<T> rightChild = node.getRightChild();
        node.setRightChild(rightChild.getLeftChild());
        if(node.getRightChild() != null)
            node.getRightChild().setParent(node);
        rightChild.setLeftChild(node);
        rightChild.setParent(node.getParent());
        changeParent(rightChild, node);
        node.setParent(rightChild);
    }

    public void changeParent(RB_Node<T> node, RB_Node<T> old){
        if(old.getParent() != null) {
            if (old.isLeftChild())
                node.getParent().setLeftChild(node);
            else
                node.getParent().setRightChild(node);
        } else {
            root = node;
        }
    }

    public void handleRecoloring(RB_Node<T> parent, RB_Node<T> uncle, RB_Node<T> grandParent){
        uncle.flipColor();
        parent.flipColor();
        grandParent.flipColor();
        recolorAndRotate(grandParent);
    }

    public RB_Node<T> insert(RB_Node<T> node, RB_Node<T> nodeToBeInserted){
        if(node == null) {
            size++;
            return nodeToBeInserted;
        }
        if(node.getData().compareTo(nodeToBeInserted.getData()) > 0){
            node.setLeftChild(insert(node.getLeftChild(), nodeToBeInserted));
            node.getLeftChild().setParent(node);
        } else if(node.getData().compareTo(nodeToBeInserted.getData()) < 0){
            node.setRightChild(insert(node.getRightChild(), nodeToBeInserted));
            node.getRightChild().setParent(node);
        }
        return node;
    }


    @Override
    public boolean delete(T data) {
        long tempSize = this.size;
        delete(data, root);
        return tempSize != this.size;
    }

    public RB_Node<T> delete(T data, RB_Node<T> node){
        if(node == null) {
            return null;
        }
        RB_Node<T> parent = node.getParent();
        if(data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(data, node.getLeftChild()));
        }
        else if(data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(data, node.getRightChild()));
        }
        else {
            this.size--;
            if(node.getLeftChild() == null && node.getRightChild() == null){
                handleDelete(node, node.getRightChild());
                return node.getRightChild();
            }
            if(node.getLeftChild() == null) {
                node.getRightChild().setParent(node.getParent());
                handleDelete(node, node.getRightChild());
                return node.getRightChild();
            }
            else if(node.getRightChild() == null) {
                node.getLeftChild().setParent(node.getParent());
                handleDelete(node, node.getLeftChild());
                return node.getLeftChild();
            }

            node.setData(getMax_recursion(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
        }
        if(parent == null){
            return root;
        }
        else {
            if(node.isLeftChild()){
                node = parent.getLeftChild();
            }
            else {
                node = parent.getRightChild();
            }
        }
        return node;
    }


    public void handleDelete(RB_Node<T> toBeDeleted, RB_Node<T> child){
        if(toBeDeleted.isRed() || (child != null && child.isRed())){
            if(child != null){
                child.setRed(false);
            }
        }
        else {
            RB_Node<T> sibling = (toBeDeleted.isLeftChild()? toBeDeleted.getParent().getRightChild(): toBeDeleted.getParent().getLeftChild());
            handleDoubleBlack(toBeDeleted, sibling);
        }
        root.setRed(false);
    }

    public void handleDoubleBlack(RB_Node<T> node, RB_Node<T> sibling){
        if(!sibling.isRed() && ((sibling.getLeftChild() == null && sibling.getRightChild() == null) ||
                (sibling.getLeftChild() != null && !sibling.getLeftChild().isRed() && sibling.getRightChild() != null && !sibling.getRightChild().isRed()) )){
            sibling.setRed(true);
            if(sibling.getParent().isRed()){
                sibling.getParent().setRed(false);
            }
            else {
                RB_Node<T> parent = sibling.getParent();
                if(parent != root){
                    RB_Node<T> siblingOfParent = (parent.isLeftChild()? parent.getParent().getRightChild(): parent.getParent().getLeftChild());
                    handleDoubleBlack(parent, siblingOfParent);
                }
            }
        }
        else if(!sibling.isRed()){
            if(!sibling.isLeftChild()){
               // RR  or RL
                if(sibling.getRightChild() != null && sibling.getRightChild().isRed()){
                    // RR
                    handleRotationDeleteRecoloring(sibling.getParent(), sibling, sibling.getRightChild(), sibling.getLeftChild());
                    leftRotate(sibling.getParent());
                }
                else {
                    // RL
                   rightRotate(sibling);
                   sibling.flipColor();
                   if(sibling.getRightChild() != null){
                       sibling.getRightChild().flipColor();
                   }
                   sibling = sibling.getParent();
                   handleRotationDeleteRecoloring(sibling.getParent(), sibling, sibling.getRightChild(), sibling.getLeftChild());
                   leftRotate(sibling.getParent());
                }
            }
            else {
                // LL or LR
                if(sibling.getLeftChild() != null && sibling.getLeftChild().isRed()){
                    // LL
                    handleRotationDeleteRecoloring(sibling.getParent(), sibling, sibling.getLeftChild(), sibling.getRightChild());
                    rightRotate(sibling.getParent());
                } else {
                    // LR
                    leftRotate(sibling);
                    sibling.flipColor();
                    if(sibling.getLeftChild() != null){
                        sibling.getLeftChild().flipColor();
                    }
                    sibling = sibling.getParent();
                    handleRotationDeleteRecoloring(sibling.getParent(), sibling, sibling.getLeftChild(), sibling.getRightChild());
                    rightRotate(sibling.getParent());
                }
            }
        } else {
            // sibling is red
            sibling.flipColor();
            sibling.getParent().flipColor();
            if(sibling.isLeftChild())
                rightRotate(sibling.getParent());
            else
                leftRotate(sibling.getParent());
            handleDoubleBlack(node, (node.isLeftChild() ? node.getParent().getRightChild() : node.getParent().getLeftChild()));
        }
    }

    public void handleRotationDeleteRecoloring(RB_Node<T> parent, RB_Node<T> sibling, RB_Node<T> redChild, RB_Node<T> alpha){
        if(!parent.isRed()){
            redChild.setRed(false);
        }
        else if(alpha != null){
            if(alpha.isRed()){
                sibling.setRed(true);
                parent.setRed(false);
                redChild.setRed(false);
            }
        }
    }

    @Override
    public void traverse(){
        ArrayList<RB_Node<T>> sortedNodes = this.convert_to_list();
        for(RB_Node<T> node : sortedNodes)
            System.out.print(node.getData() + ", ");
        System.out.println();
    }

    public ArrayList<RB_Node<T>> convert_to_list() {
        ArrayList<RB_Node<T>> sortedNodes = new ArrayList<>();
        traverseInOrder(root, sortedNodes);
        return sortedNodes;
    }

    public void traverseInOrder(RB_Node<T> node, ArrayList<RB_Node<T>> nodes){
        if(node == null)
            return;
        traverseInOrder(node.getLeftChild(), nodes);
        nodes.add(node);
        traverseInOrder(node.getRightChild(), nodes);
    }

    @Override
    public boolean search(T data) {
        return search_recursion(root, data);
    }

    private boolean search_recursion(RB_Node<T> node, T data){
        if(node == null)
            return false;
        if(node.getData().compareTo(data) < 0)
            search_recursion(node.getLeftChild(), data);
        else if(node.getData().compareTo(data) > 0)
            search_recursion(node.getRightChild(), data);
        else
            return true;
        return false;
    }

    @Override
    public T getMax(){
        return getMax_recursion(this.root);
    }

    @Override
    public T getMin() {
        return getMin_recursion(this.root);
    }

    public T getMax_recursion(RB_Node<T> node) {
        if(node == null)
            return null;
        if(node.getRightChild() != null)
            return getMax_recursion(node.getRightChild());
        return node.getData();
    }

    public T getMin_recursion(RB_Node<T> node){
        if(node == null)
            return null;
        if(node.getLeftChild() != null)
            return getMin_recursion(node.getLeftChild());
        return node.getData();
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public long getHeight() {
        return 0;
    }

    @Override
    public long batchInsert(String filePath) {
        File_Scanner_IF<T> dataScanner = new Concrete_FS<>();
        List<T> dataToInsert = dataScanner.importData(filePath);
        long tempSize = this.size;
        for(T data : dataToInsert)
            this.insert(data);
        return this.size - tempSize;
    }

    @Override
    public long batchDelete(String filePath) {
        File_Scanner_IF<T> dataScanner = new Concrete_FS<>();
        List<T> dataToDelete = dataScanner.importData(filePath);
        long tempSize = this.size;
        for(T data : dataToDelete)
            this.delete(data);
        return this.size - tempSize;
    }

    @Override
    public void export(String path){
        File_Scanner_IF<T> dataScanner = new Concrete_FS<>();
        dataScanner.exportData(path, this.filter(this.convert_to_list()));
    }

    private List<T> filter(ArrayList<RB_Node<T>> nonFilteredData){
        ArrayList<T> filteredData = new ArrayList<>(0);
        for(RB_Node<T> node : nonFilteredData)
            filteredData.add(node.getData());
        return filteredData;
    }
}
