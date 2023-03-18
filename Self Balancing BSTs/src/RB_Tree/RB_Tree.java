package RB_Tree;

import java.util.ArrayList;
import java.util.List;

public class RB_Tree<T extends Comparable<T>> implements Tree<T> {
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
    public RB_Tree<T> insert(T data) {
        RB_Node<T> nodeToBeInserted = new RB_Node<>(data);
        root = insert(root, nodeToBeInserted);
        recolorAndRotate(nodeToBeInserted);
        return this;
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
    public void rightRotate(RB_Node<T> node){
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
    public void delete(T data) {
        delete(data, root);
    }

    public RB_Node<T> delete(T data, RB_Node<T> node){
        if(node == null) {
            return null;
        }
        if(data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(data, node.getLeftChild()));
        }
        else if(data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(data, node.getRightChild()));
        }
        else {

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

            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
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
            handleDoubleBlack(child, sibling);
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

            }
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
    public ArrayList<RB_Node<T>> traverse() {
        ArrayList<RB_Node<T>> nodes = new ArrayList<>();
        traverseInOrder(root, nodes);
        return nodes;
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
        return false;
    }

    @Override
    public T getMax(RB_Node<T> node) {
        if(node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();

    }

    @Override
    public T getMin() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public long getHeight() {
        return 0;
    }
}
