package RB_Tree;

import java.util.*;

public interface Tree<T extends Comparable<T>> {
    Tree<T> insert(T data);
    void delete(T data);
    ArrayList<RB_Node<T>> traverse();
    boolean search(T data);
    T getMax(RB_Node<T> node);
    T getMin();
    boolean isEmpty();
    long getSize();
    long getHeight();
}
