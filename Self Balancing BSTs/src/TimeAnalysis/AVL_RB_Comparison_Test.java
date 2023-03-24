package TimeAnalysis;

import AVL_Tree.AVL_Tree;
import RB_Tree.RB_Tree;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AVL_RB_Comparison_Test {

    @Test
    void Insertion_Time_for_500000_elements_IN_AVl_And_RB() {
        AVL_Tree<Long> avl = new AVL_Tree<Long>();
        RB_Tree<Long> rb = new RB_Tree<Long>();
        ArrayList<Long> data = new AVL_RB_Comparison().RandomGenerator(500000, 10000000);
        long start = System.nanoTime();
        for (Long element : data) avl.insert(element);
        long end = System.nanoTime();
        long avlTime = end - start;
        start = System.nanoTime();
        for (Long element : data) rb.insert(element);
        end = System.nanoTime();
        long rbTime = end - start;
        assertTrue(rbTime < avlTime);
    }

    @Test
    void Insertion_Time_for_1000000_elements_IN_AVl_And_RB() {
        AVL_Tree<Long> avl = new AVL_Tree<Long>();
        RB_Tree<Long> rb = new RB_Tree<Long>();
        ArrayList<Long> data = new AVL_RB_Comparison().RandomGenerator(1000000, 1000000000);
        long start = System.nanoTime();
        for (Long element : data) avl.insert(element);
        long end = System.nanoTime();
        long avlTime = end - start;
        start = System.nanoTime();
        for (Long element : data) rb.insert(element);
        end = System.nanoTime();
        long rbTime = end - start;
        assertTrue(rbTime < avlTime);
    }

    @Test
    void Insertion_Time_for_5000000_elements_IN_AVl_And_RB() {
        AVL_Tree<Long> avl = new AVL_Tree<Long>();
        RB_Tree<Long> rb = new RB_Tree<Long>();
        ArrayList<Long> data = new AVL_RB_Comparison().RandomGenerator(5000000, 1000000000);
        long start = System.nanoTime();
        for (Long element : data) avl.insert(element);
        long end = System.nanoTime();
        long avlTime = end - start;
        start = System.nanoTime();
        for (Long element : data) rb.insert(element);
        end = System.nanoTime();
        long rbTime = end - start;
        assertTrue(rbTime < avlTime);
    }

    @Test
    void Height_In_AVL_And_RB_With_100_Insertion() {
        AVL_Tree<Long> avl = new AVL_Tree<Long>();
        RB_Tree<Long> rb = new RB_Tree<Long>();
        ArrayList<Long> data = new AVL_RB_Comparison().RandomGenerator(100, 1000000000);
        for (Long element : data) {
            avl.insert(element);
            rb.insert(element);
        }
        assertTrue(avl.getHeight() <= rb.getHeight());
    }

    @Test
    void Height_In_AVL_And_RB_With_1000_Insertion() {
        AVL_Tree<Long> avl = new AVL_Tree<Long>();
        RB_Tree<Long> rb = new RB_Tree<Long>();
        ArrayList<Long> data = new AVL_RB_Comparison().RandomGenerator(1000, 1000000000);
        for (Long element : data) {
            avl.insert(element);
            rb.insert(element);
        }
        assertTrue(avl.getHeight() <= rb.getHeight());
    }

    @Test
    void Height_In_AVL_And_RB_With_10000_Insertion() {
        AVL_Tree<Long> avl = new AVL_Tree<Long>();
        RB_Tree<Long> rb = new RB_Tree<Long>();
        ArrayList<Long> data = new AVL_RB_Comparison().RandomGenerator(10000, 1000000000);
        for (Long element : data) {
            avl.insert(element);
            rb.insert(element);
        }
        assertTrue(avl.getHeight() <= rb.getHeight());
    }

    @Test
    void Height_In_AVL_And_RB_With_100000_Insertion() {
        AVL_Tree<Long> avl = new AVL_Tree<Long>();
        RB_Tree<Long> rb = new RB_Tree<Long>();
        ArrayList<Long> data = new AVL_RB_Comparison().RandomGenerator(100000, 1000000000);
        for (Long element : data) {
            avl.insert(element);
            rb.insert(element);
        }
        assertTrue(avl.getHeight() <= rb.getHeight());
    }

}