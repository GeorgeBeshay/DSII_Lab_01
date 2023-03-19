package AVL_Tree;

public class AVL_Node<T extends Comparable<T>> {
    public T data;
    public AVL_Node<T> parent;
    public AVL_Node<T> left;
    public AVL_Node<T> right;
    public int balanceFactor;
    public int height;

    public AVL_Node(T data) {
        this.data = data;
        this.height = 0;
    }
}
