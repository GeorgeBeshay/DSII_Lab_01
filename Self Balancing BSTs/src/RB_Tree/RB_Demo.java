package RB_Tree;

import Abstractions.Super_Tree;

import java.util.*;

public class RB_Demo {
    public static void main(String[] args) {
        int[] arr = {150, 100, 200, 50, 120, 130, 110};
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        for (int j : arr) tree.insert(j);
        tree.delete(50);
        List<RB_Node<Integer>> nodes = tree.convert_to_list();
        System.out.println("Root is :" + tree.getRoot().getData());
        for(RB_Node<Integer> node : nodes)
            System.out.println(node.getData() + " isRed: " + node.isRed());
//        RB_Demo myDemo = new RB_Demo();
//        myDemo.testing();
//        int[] arr = {5, 10, 15, 3};
//        RB_Tree<Integer> tree = new RB_Tree<Integer>();
//        for(int i = 0 ; i < 4 ; i++)
//            tree.insert(arr[i]);
//        tree.delete(3);
//        tree.insert(20);
//        tree.insert(20);
//        tree.delete(5);
//        tree.insert(18);
//        tree.delete(10);
//        tree.insert(10);
//        tree.delete(20);
//        tree.delete(20);
//        tree.insert(13);
//        tree.delete(18);
//        tree.insert(14);
//        tree.insert(16);
//        tree.insert(17);
//        tree.delete(17);
//        tree.delete(10);
//
//        List<RB_Node<Integer>> nodes = tree.convert_to_list();
//        System.out.println("Root is :" + tree.getRoot().getData());
//        for(RB_Node<Integer> node : nodes)
//            System.out.println(node.getData() + " isRed: " + node.isRed());
    }

    public void testing(){
        Super_Tree<String> myTree = new RB_Tree<String>();
        myTree.batchInsert("generated_words");
        myTree.export("output");
    }
}
