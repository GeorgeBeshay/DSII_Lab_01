package Abstractions;

public interface Super_Tree <T extends Comparable<T>> {
    boolean insert(T data);
    boolean delete(T data);
    boolean search(T data);
    long getSize();
    long getHeight();
    long batchInsert(String filePath); // return number of successfully inserted data
    long batchDelete(String filePath);
}
