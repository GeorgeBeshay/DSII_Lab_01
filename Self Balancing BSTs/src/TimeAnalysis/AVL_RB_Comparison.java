package TimeAnalysis;

import AVL_Tree.AVL_Tree;
import RB_Tree.RB_Tree;
import java.util.ArrayList;
import java.util.Random;

public class AVL_RB_Comparison {

    AVL_Tree<Integer> avl;
    RB_Tree<Integer> rb;
    ArrayList<Integer> data;

    public AVL_RB_Comparison() {
        avl = new AVL_Tree<Integer>();
        rb = new RB_Tree<Integer>();
    }

    public ArrayList<Integer> RandomGenerator(int numberOfElements, int limit) {
        ArrayList<Integer> data = new ArrayList<Integer>();
        Random random = new Random();
        while(numberOfElements-- > 0)
            data.add(random.nextInt(limit));
        return data;
    }

    public void AVL_RB_Insertion_Comparison(int numberOfElements, int limit) {
        data = RandomGenerator(numberOfElements, limit);
        long start = System.nanoTime();
        for(Integer element: data)
            avl.insert(element);
        long end = System.nanoTime();
        long time = (end - start)/1000;
        System.out.println("AVL time " + time);
        start = System.nanoTime();
        for(Integer element: data)
            rb.insert(element);
        end = System.nanoTime();
        time = (end - start)/1000;
        System.out.println("RB time " + time);
    }

    public void AVL_RB_Deletion_Comparison() {
        long start = System.nanoTime();
        for(Integer element: data)
            avl.delete(element);
        long end = System.nanoTime();
        long time = (end - start) / 1000;
        System.out.println("AVL time " + time);
        start = System.nanoTime();
        for(Integer element: data)
            rb.delete(element);
        end = System.nanoTime();
        time = (end - start) / 1000;
        System.out.println("RB time " + time);
    }


    /////////////////////   does not work correct yet   //////////////
    public void AVL_RB_Search_Comparison() {
        long start = System.nanoTime();
        for(Integer element: data)
            avl.search(element);
        long end = System.nanoTime();
        long time = (end - start)/1000;
        System.out.println("AVL time " + time);
        start = System.nanoTime();
        for(Integer element: data)
            rb.search(element);
        end = System.nanoTime();
        time = (end - start)/1000;
        System.out.println("RB time " + time);
    }


}
