package RB_Tree;

import java.util.*;

public interface Tree<T extends Comparable<T>> {
    Tree<T> insert(T data);
    void delete(T data);
    void traverse();
    boolean search(T data);
    List<T> toList();
    T getMax();
    T getMin();
    boolean isEmpty();
    long getSize();
    long getHeight();
}
