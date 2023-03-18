package RB_Tree;

import java.util.*;

public class RB_Demo {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 3};
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        for(int i = 0 ; i < 4 ; i++)
            tree.insert(arr[i]);
        tree.delete(3);
        tree.insert(20);
        tree.delete(5);
        List<RB_Node<Integer>> nodes = tree.traverse();

        System.out.println("Root is :" + tree.getRoot().getData());
        for(RB_Node<Integer> node : nodes)
            System.out.println(node.getData() + " isRed: " + node.isRed());
        System.out.println("--------------------------------------------");

//        tree.insert(20);
//        List<RB_Node<Integer>> nodes2 = tree.traverse();
//        System.out.println("Rott is :" + tree.getRoot().getData());
//        for(RB_Node<Integer> node : nodes2)
//            System.out.println(node.getData() + " isRed: " + node.isRed());
//        tree.delete(8);
//        tree.delete(12);
//        tree.delete(19);
//        tree.delete(31);
//        tree.delete(41);
//        System.out.println("--------------------------------------------");
//        List<RB_Node<Integer>> nodes_2 = tree.traverse();
//        for(RB_Node<Integer> node : nodes_2)
//            System.out.println(node.getData() + " isRed: " + node.isRed());
    }
}
