package TimeAnalysis;

import AVL_Tree.AVL_Tree;
import Abstractions.Super_Tree;
import RB_Tree.RB_Tree;

import java.lang.reflect.Array;
import java.util.*;

public class AVL_RB_Comparison {

    ArrayList<Integer> sizesToObserve;
    ArrayList<ArrayList<Integer>> data;
    ArrayList<List<Super_Tree<Integer>>> trees;   // avl, rb
    Integer limit;

    public AVL_RB_Comparison(ArrayList<Integer> sizesToObserve, Integer limit) {
        this.sizesToObserve = sizesToObserve;
        this.data = new ArrayList<>();
        this.trees = new ArrayList<>();
        if(limit != null)
            this.limit = limit;
        else
            this.limit = (int)Math.pow(10, 7);
        for (Integer integer : sizesToObserve) {
            data.add(randomGenerator(integer, this.limit));
        }
    }

    public ArrayList<Integer> randomGenerator(int numberOfElements, int tempLimit) {
        ArrayList<Integer> data = new ArrayList<>();
        Random random = new Random();
        Hashtable<Integer, Boolean> table = new Hashtable<>();
        int tempNumber = 0, tempSize;
        while(numberOfElements-- > 0) {
            tempNumber = random.nextInt(tempLimit);
            while(table.get(tempNumber) != null && table.get(tempNumber))
                tempNumber = random.nextInt(tempLimit);
            table.put(tempNumber, true);
            data.add(tempNumber);
            }
        return data;
    }

    public ArrayList<String> AVL_RB_Insertion_Comparison(ArrayList<String> results) {
        long avlStart, rbStart, avlEnd, rbEnd;
        // ----------------- Separator -----------------
        for(int i = 0 ; i < sizesToObserve.size() ; i++){
            // ----------------- Separator -----------------
            ArrayList<Integer> tempData = this.data.get(i);
            Super_Tree<Integer> avl = new AVL_Tree<Integer>();
            Super_Tree<Integer> rb = new RB_Tree<Integer>();
            // ----------------- Separator -----------------
            avlStart = System.nanoTime();
            for(Integer element : tempData)
                avl.insert(element);
            avlEnd = System.nanoTime();
            // ----------------- Separator -----------------
            rbStart = System.nanoTime();
            for(Integer element : tempData)
                rb.insert(element);
            rbEnd = System.nanoTime();
            // ----------------- Separator -----------------
            this.trees.add(Arrays.asList(avl, rb));
            results.set(i, results.get(i).concat((avlEnd - avlStart)/1000 + "\t" + (rbEnd - rbStart)/1000) + "\t");
            // ----------------- Separator -----------------
        }
        return results;
    }

    public void AVL_RB_Deletion_Comparison(ArrayList<String> results) {
        long avlStart, rbStart, avlEnd, rbEnd;
        // ----------------- Separator -----------------
        for(int i = 0 ; i < sizesToObserve.size() ; i++) {
            // ----------------- Separator -----------------
            ArrayList<Integer> tempData = this.data.get(i);
            Super_Tree<Integer> avl = this.trees.get(i).get(0);
            Super_Tree<Integer> rb = this.trees.get(i).get(1);
            // ----------------- Separator -----------------
            avlStart = System.nanoTime();
            for (Integer element : tempData)
                if (!avl.delete(element)) {
                    System.out.println("NOT FOUND - DELETION");
                    System.exit(1);
                }
            avlEnd = System.nanoTime();
            // ----------------- Separator -----------------
            rbStart = System.nanoTime();
            for (Integer element : tempData)
                if (!rb.delete(element)) {
                    System.out.println("NOT FOUND - DELETION");
                    System.exit(1);
                }
            rbEnd = System.nanoTime();
            // ----------------- Separator -----------------
            results.set(i, results.get(i).concat((avlEnd - avlStart) / 1000 + "\t" + (rbEnd - rbStart) / 1000) + "\t");
            // ----------------- Separator -----------------
        }
    }

    public ArrayList<String> AVL_RB_Search_Comparison(ArrayList<String> results) {
        long avlStart, rbStart, avlEnd, rbEnd;
        // ----------------- Separator -----------------
        for(int i = 0 ; i < sizesToObserve.size() ; i++) {
            // ----------------- Separator -----------------
            ArrayList<Integer> tempData = this.data.get(i);
            Super_Tree<Integer> avl = this.trees.get(i).get(0);
            Super_Tree<Integer> rb = this.trees.get(i).get(1);
            // ----------------- Separator -----------------
            avlStart = System.nanoTime();
            for (Integer element : tempData)
                if (!avl.search(element)) {
                    System.out.println("NOT FOUND - Searching");
                    System.exit(1);
                }
            avlEnd = System.nanoTime();
            // ----------------- Separator -----------------
            rbStart = System.nanoTime();
            for (Integer element : tempData)
                if (!rb.search(element)) {
                    System.out.println("NOT FOUND - Searching");
                    System.exit(1);
                }
            rbEnd = System.nanoTime();
            // ----------------- Separator -----------------
            results.set(i, results.get(i).concat((avlEnd - avlStart) / 1000 + "\t" + (rbEnd - rbStart) / 1000) + "\t");
        }
        return results;
    }

    public ArrayList<String> AVL_RB_Height_Comparison(ArrayList<String> results) {       // time to getHeight & the height itself
        long avlStart, rbStart, avlEnd, rbEnd;
        // ----------------- Separator -----------------
        for(int i = 0 ; i < sizesToObserve.size() ; i++) {
            // ----------------- Separator -----------------
            Super_Tree<Integer> avl = this.trees.get(i).get(0);
            Super_Tree<Integer> rb = this.trees.get(i).get(1);
            long avlH, rbH;
            // ----------------- Separator -----------------
            avlStart = System.nanoTime();
            avlH = avl.getHeight();
            avlEnd = System.nanoTime();
            // ----------------- Separator -----------------
            rbStart = System.nanoTime();
            rbH = rb.getHeight();
            rbEnd = System.nanoTime();
            // ----------------- Separator -----------------
            results.set(i, results.get(i).concat((avlEnd - avlStart) / 1000 + "\t" + (rbEnd - rbStart) / 1000) + "\t" + avlH + "\t" + rbH + "\t");
        }
        return results;
    }


}
