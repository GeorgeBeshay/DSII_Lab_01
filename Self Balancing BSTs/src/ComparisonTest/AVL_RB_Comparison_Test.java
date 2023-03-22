package ComparisonTest;

import AVL_Tree.AVL_Tree;
import RB_Tree.RB_Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AVL_RB_Comparison_Test {

    /////////////////////   does not work correct yet   //////////////
    @Test
    void Insertion_Time_for_10000_elements_IN_AVl_And_RB() {
        AVL_Tree<Integer> avl = new AVL_Tree<Integer>();
        RB_Tree<Integer> rb = new RB_Tree<Integer>();
        long start = System.nanoTime();
        for(int i=10000;i>=0;i--) avl.insert(i);
        long end = System.nanoTime();
        long avlTime = end - start;
        start = System.nanoTime();
        for(int i=10000;i>=0;i--) rb.insert(i);
        end = System.nanoTime();
        long rbTime = end - start;
        System.out.println(rbTime);
        System.out.println(avlTime);
        assertTrue(rbTime < avlTime);
    }

}
