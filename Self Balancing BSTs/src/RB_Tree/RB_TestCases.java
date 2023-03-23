package RB_Tree;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RB_TestCases<T extends Comparable<T>> {

    public void insertFromList (List<T> data, RB_Tree<T> tree){
        for(T tempData : data)
            tree.insert(tempData);
    }

    @Test
    public void test_insertion_easy(){
        // Insertion Case => Easy case (Parent is black)
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {12, 10, 15};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(Arrays.asList(data), tree);
        Collections.sort(dataList);
        // -------------- Separator --------------
        assertEquals(tree.filter(tree.convert_to_list()), dataList);
        assertTrue(tree.validateTree());
    }

    @Test
    public void test_insertion_P_U_red(){
        // Insertion Case => Parent & Uncle are red
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {12, 10, 15, 5};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(Arrays.asList(data), tree);
        Collections.sort(dataList);
        // -------------- Separator --------------
        assertEquals(tree.filter(tree.convert_to_list()), dataList);
        assertTrue(tree.validateTree());
        assertEquals(3, tree.getBlackHeight());
        assertEquals(4, tree.getHeight());
    }

    @Test
    public void test_insertion_Par_R_Un_B_LL(){
        // Insertion Case => Parent R, Uncle B (Null) LL
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {12, 10, 5};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(Arrays.asList(data), tree);
        Collections.sort(dataList);
        // -------------- Separator --------------
        assertEquals(tree.filter(tree.convert_to_list()), dataList);
        assertTrue(tree.validateTree());
        assertEquals(2, tree.getBlackHeight());
        assertEquals(3, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 10);
    }

    @Test
    public void test_insertion_Par_R_Un_B_RR(){
        // Insertion Case => Parent R, Uncle B (Null) RR
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {12, 15, 20};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(Arrays.asList(data), tree);
        Collections.sort(dataList);
        // -------------- Separator --------------
        assertEquals(tree.filter(tree.convert_to_list()), dataList);
        assertTrue(tree.validateTree());
        assertEquals(2, tree.getBlackHeight());
        assertEquals(3, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 15);
    }

    @Test
    public void test_insertion_Par_R_Un_B_LR(){
        // Insertion Case => Parent R, Uncle B (Null) LR
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {17, 12, 15};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(Arrays.asList(data), tree);
        Collections.sort(dataList);
        // -------------- Separator --------------
        assertEquals(tree.filter(tree.convert_to_list()), dataList);
        assertTrue(tree.validateTree());
        assertEquals(2, tree.getBlackHeight());
        assertEquals(3, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 15);
    }

    @Test
    public void test_insertion_Par_R_Un_B_RL(){
        // Insertion Case => Parent R, Uncle B (Null) RL
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {10, 20, 15};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(Arrays.asList(data), tree);
        Collections.sort(dataList);
        // -------------- Separator --------------
        assertEquals(tree.filter(tree.convert_to_list()), dataList);
        assertTrue(tree.validateTree());
        assertEquals(2, tree.getBlackHeight());
        assertEquals(3, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 15);
    }

    @Test
    public void test_deletion_easy(){
        // Deletion Case => Child is R or parent is R.
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {10, 5, 15};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(dataList, tree);
        tree.delete(5);
        // -------------- Separator --------------
        assertTrue(tree.validateTree());
        assertEquals(2, tree.getBlackHeight());
        assertEquals(3, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 10);
    }

    @Test
    public void test_deletion_hard_case1_1(){
        // Deletion Case => U, V, S and its children are all black, parent is B
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {10, 5, 15, 0};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(dataList, tree);
        tree.delete(0); // to reach the required structure.
        tree.delete(5);
        // -------------- Separator --------------
        assertTrue(tree.validateTree());
        assertEquals(2, tree.getBlackHeight());
        assertEquals(3, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 10);
        assertEquals(tree.getSize(), 2);
    }

    @Test
    public void test_deletion_hard_case1_2(){
        // Deletion Case => U, V, S and its children are all black, parent is R
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {10, 5, 15, 2, 7, 0};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(dataList, tree);
        tree.delete(0); // to reach the required structure.
        tree.delete(2);
        // -------------- Separator --------------
        assertTrue(tree.validateTree());
        assertEquals(3, tree.getBlackHeight());
        assertEquals(4, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 10);
        assertEquals(tree.getSize(), 4);
    }

    @Test
    public void test_deletion_hard_case2_RR(){
        // Deletion Case => U, V, S are black and S's R child is red => Left rotation around the sibling
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {10, 5, 15, 20};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(dataList, tree);
        tree.delete(5);
        // -------------- Separator --------------
        assertTrue(tree.validateTree());
        assertEquals(3, tree.getBlackHeight());
        assertEquals(3, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 15);
        assertEquals(tree.getSize(), 3);
    }

    @Test
    public void test_deletion_hard_case2_LL(){
        // Deletion Case => U, V, S are black and S's R child is red => Right rotation around the sibling
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {10, 5, 15, 0};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(dataList, tree);
        tree.delete(15);
        // -------------- Separator --------------
        assertTrue(tree.validateTree());
        assertEquals(3, tree.getBlackHeight());
        assertEquals(3, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 5);
        assertEquals(tree.getSize(), 3);
    }

    @Test
    public void test_deletion_hard_case2_RL(){
        /*
         * Deletion Case => U, V, S are black and S's R child is red => Left rotation around
         * the child, right rotation around the sibling.
         */
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {10, 5, 15, 12};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(dataList, tree);
        tree.delete(5);
        // -------------- Separator --------------
        assertTrue(tree.validateTree());
        assertEquals(3, tree.getBlackHeight());
        assertEquals(3, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 12);
        assertEquals(tree.getSize(), 3);
    }

    @Test
    public void test_deletion_hard_case2_LR(){
        /*
         * Deletion Case => U, V, S are black and S's R child is red => right rotation around
         * the child, left rotation around the sibling.
         */
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {10, 5, 15, 7};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(dataList, tree);
        tree.delete(15);
        // -------------- Separator --------------
        assertTrue(tree.validateTree());
        assertEquals(3, tree.getBlackHeight());
        assertEquals(3, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 7);
        assertEquals(tree.getSize(), 3);
    }

    @Test
    public void test_deletion_hard_case2_RR_2(){
        /*
         * Deletion Case => U, V, S are black and S's R child is red => right rotation around
         * the sibling, alpha and parent are red
         */
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {15, 10, 20, 5, 12, 13, 11};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(dataList, tree);
        tree.delete(5);
        // -------------- Separator --------------
        assertTrue(tree.validateTree());
        assertEquals(3, tree.getBlackHeight());
        assertEquals(5, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 15);
        assertEquals(tree.getSize(), 6);
    }

    @Test
    public void test_deletion_hard_case3(){
        /*
         * U, V are black, S is red.
         */
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        RB_TestCases<Integer> myClass = new RB_TestCases<Integer>();
        // -------------- Separator --------------
        Integer[] data = {10, 5, 15, 12, 20, 25};
        List<Integer> dataList = Arrays.asList(data);
        // -------------- Separator --------------
        myClass.insertFromList(dataList, tree);
        tree.delete(5);
        // -------------- Separator --------------
        assertTrue(tree.validateTree());
        assertEquals(3, tree.getBlackHeight());
        assertEquals(4, tree.getHeight());
        assertEquals(tree.getRoot().getData(), 15);
        assertEquals(tree.getSize(), 5);
    }

    @Test
    public void test_batchInsert(){
        /*
         * Batch insert from a file containing 10k words randomly generated.
         */
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        // -------------- Separator --------------
        tree.batchInsert("batchInsert_testcase_1");
        // -------------- Separator --------------
        assertTrue(tree.validateTree());
        assertTrue(tree.getHeight() <= tree.getBlackHeight() * 2);
        assertEquals(tree.getSize(), 10000);
    }

    @Test
    public void test_batchInsert_batchDelete(){
        /*
         * Batch insert from a file containing 10k words randomly generated.
         */
        RB_Tree<Integer> tree = new RB_Tree<Integer>();
        // -------------- Separator --------------
        assertEquals(tree.batchInsert("batchInsert_testcase_2"), 10000);
        assertEquals(tree.batchInsert("batchInsert_testcase_2"), 0);
        assertEquals(tree.batchDelete("batchDelete_testcase_2"), 1403 - 70);
        // -------------- Separator --------------
        assertTrue(tree.validateTree());
        assertTrue(tree.getHeight() <= tree.getBlackHeight() * 2);
        assertEquals(tree.getSize(), 10000 - 1403 + 70);
    }

}
