package RB_Tree;

public class RB_Node<T extends Comparable<T>> {
    private T data;
    private RB_Node<T> parent;
    private RB_Node<T> rightChild;
    private RB_Node<T> leftChild;
    private boolean isRed;

    public RB_Node(T data){
        this.data = data;
        this.parent = null;
        this.rightChild = null;
        this.leftChild = null;
        this.isRed = true;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public RB_Node<T> getRightChild() {
        return rightChild;
    }
    public void setRightChild(RB_Node<T> rightChild) {
        this.rightChild = rightChild;
    }
    public RB_Node<T> getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(RB_Node<T> leftChild) {
        this.leftChild = leftChild;
    }
    public boolean isRed() {
        return isRed;
    }
    public void setRed(boolean red) {
        isRed = red;
    }
    public void flipColor(){
        this.isRed = !this.isRed;
    }
    public boolean isLeftChild(){
        return (this.parent.getLeftChild() == this);
    }
    public RB_Node<T> getParent() {
        return parent;
    }
    public void setParent(RB_Node<T> parent) {
        this.parent = parent;
    }
}
