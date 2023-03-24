package Abstractions;
import java.util.*;

public interface Super_Tree <T extends Comparable<T>> {
    boolean insert(T data);
    boolean delete(T data);
    boolean search(T data);
    boolean isEmpty();
    void traverse();
    long getSize();
    T getMax();
    T getMin();
    long batchInsert(String filePath); // return number of successfully inserted data
    long batchDelete(String filePath);
    void export(String filePath);
    long getHeight();
}
