package RB_Tree;

import java.util.*;

public class RB_Demo {
    public static void main(String[] args) {
        int[] arr = {41, 38, 31, 12, 19, 8, 9, 10, 50, 48, 55};
        Tree<Integer> tree = new RB_Tree<Integer>();
        for(int i = 0 ; i < 11 ; i++)
            tree.insert(arr[i]);
        List<RB_Node<Integer>> nodes = tree.traverse();
        for(RB_Node<Integer> node : nodes)
            System.out.println(node.getData() + " isRed: " + node.isRed());

    }
}
