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
    
}
