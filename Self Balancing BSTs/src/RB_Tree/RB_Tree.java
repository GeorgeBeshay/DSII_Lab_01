package RB_Tree;

import java.util.List;

public class RB_Tree<T extends Comparable<T>> implements Tree<T> {
    private RB_Node<T> root;
    private long size;
    public RB_Tree(){
        this.root = null;
        this.size = 0;
    }

    @Override
    public RB_Tree<T> insert(T data) {
        RB_Node<T> nodeToBeInserted = new RB_Node<>(data);
        root = insert(root, nodeToBeInserted);

        return this;
    }
    public void recolorAndRotate(RB_Node<T> node){
        RB_Node<T> parent = node.getParent();
        if(parent.isRed() && parent != root){
            RB_Node<T> grandParent = parent.getParent();
            RB_Node<T> uncle = (node.isLeftChild() ? grandParent.getRightChild() : grandParent.getLeftChild());
            if(uncle != null && uncle.isRed()){
                // Change colors of the parent, grandparent, uncle, recursion @grandparent
            } else if(parent.isLeftChild()){
                // either left left case or left right case in addition to recoloring.
            } else {
                // either right right case or right left case in addition to recoloring.
            }
        }
        root.setRed(false);
    }
    public RB_Node<T> insert(RB_Node<T> node, RB_Node<T> nodeToBeInserted){
        if(node == null)
            return nodeToBeInserted;
        if(node.getData().compareTo(nodeToBeInserted.getData()) < 0){
            node.setLeftChild(insert(node.getLeftChild(), nodeToBeInserted));
            node.getLeftChild().setParent(node);
        } else if(node.getData().compareTo(nodeToBeInserted.getData()) > 0){
            node.setRightChild(insert(node.getRightChild(), nodeToBeInserted));
            node.getRightChild().setParent(node);
        }
        return node;
    }

    @Override
    public void delete(T data) {

    }

    @Override
    public void traverse() {

    }

    @Override
    public boolean search(T data) {
        return false;
    }

    @Override
    public List<T> toList() {
        return null;
    }

    @Override
    public T getMax() {
        return null;
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
        return 0;
    }

    @Override
    public long getHeight() {
        return 0;
    }
}
