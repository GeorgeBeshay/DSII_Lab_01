package AVL_Tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVL_Test {

    // insertion
    //Insert one element        --> 10
    @Test
    void insert_0 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(0));
    }
    @Test
    void insert_1 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(1));
    }
    @Test
    void insert_567 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(567));
    }
    @Test
    void insert_10000 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(10000));
    }
    @Test
    void insert_10000000 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(10000000));
    }
    @Test
    void insert_Neg1000 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(-1000));
    }
    @Test
    void insert_PI_with_3_SigFig () {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(3.14f));
    }
    @Test
    void insert_PI_with_5_SigFig () {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(3.1415f));
    }
    @Test
    void insert_PI_with_7_SigFig () {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(3.141592f));
    }
    @Test
    void insert_NegPI_with_7_SigFig () {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(-3.141592f));
    }
    //////////////////////////////////////////////////////
    // insert one Dup       --> 5
    @Test
    void insert_0_again( ){
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(0));
        assertFalse(myTree.insert(0));
    }
    @Test
    void insert_1_again( ){
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(1));
        assertFalse(myTree.insert(1));
    }
    @Test
    void insert_100000_again( ){
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(100000));
        assertFalse(myTree.insert(100000));
    }
    @Test
    void insert_Neg100_againAndAgain() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(-100));
        assertFalse(myTree.insert(-100));
    }
    @Test
    void insert_PI_with_7_SigFig_again() {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(-3.141592f));
        assertFalse(myTree.insert(-3.141592f));
    }
    ///////////Tricky/////////////
    @Test
    void T_typeOfInput() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(1));
        assertFalse(myTree.insert(001));
    }
    //////////////////////////////////////////////////////
    // combinations of the above 2      --> 3
    @Test
    void insert_12_elementsWith_5_Dups () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(1));
        assertTrue(myTree.insert(2));
        assertTrue(myTree.insert(3));
        assertFalse(myTree.insert(3));
        assertTrue(myTree.insert(4));
        assertTrue(myTree.insert(5));
        assertFalse(myTree.insert(5));
        assertTrue(myTree.insert(6));
        assertFalse(myTree.insert(6));
        assertTrue(myTree.insert(7));
        assertFalse(myTree.insert(7));
        assertFalse(myTree.insert(7));
    }
    @Test
    void insaneIntegerInsertion() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(1));
        assertTrue(myTree.insert(2));
        assertTrue(myTree.insert(3));
        assertFalse(myTree.insert(3));
        assertTrue(myTree.insert(4));
        assertTrue(myTree.insert(5));
        assertFalse(myTree.insert(5));
        assertTrue(myTree.insert(6));
        assertFalse(myTree.insert(6));
        assertTrue(myTree.insert(7));
        assertFalse(myTree.insert(7));
        assertFalse(myTree.insert(7));
        assertTrue(myTree.insert(-11));
        assertTrue(myTree.insert(21));
        assertTrue(myTree.insert(31));
        assertTrue(myTree.insert(12));
        assertTrue(myTree.insert(22));
        assertTrue(myTree.insert(32));
        assertTrue(myTree.insert(13));
        assertTrue(myTree.insert(-23));
        assertTrue(myTree.insert(-33));
        assertTrue(myTree.insert(14));
        assertTrue(myTree.insert(-24));
        assertTrue(myTree.insert(34));
        assertTrue(myTree.insert(15));
        assertTrue(myTree.insert(-25));
        assertTrue(myTree.insert(35));
        assertTrue(myTree.insert(16));
        assertTrue(myTree.insert(26));
        assertTrue(myTree.insert(36));
        assertTrue(myTree.insert(17));
        assertTrue(myTree.insert(27));
        assertTrue(myTree.insert(37));
        assertFalse(myTree.insert(17));
        assertFalse(myTree.insert(27));
        assertFalse(myTree.insert(37));
    }
    @Test
    void insaneFloatInsertion() {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(1.0f));
        assertTrue(myTree.insert(2.4f));
        assertTrue(myTree.insert(3.7f));
        assertFalse(myTree.insert(3.70f));
        assertTrue(myTree.insert(4.04f));
        assertTrue(myTree.insert(5.0001f));
        assertFalse(myTree.insert(5.0001f));
        assertTrue(myTree.insert(6.4789f));
        assertFalse(myTree.insert(6.4789f));
        assertTrue(myTree.insert(7.4156f));
        assertFalse(myTree.insert(7.4156f));
        assertFalse(myTree.insert(7.4156f));
        assertTrue(myTree.insert(11.45f));
        assertTrue(myTree.insert(21.416f));
        assertTrue(myTree.insert(31.7789f));
        assertTrue(myTree.insert(12.789f));
        assertTrue(myTree.insert(22.694f));
        assertTrue(myTree.insert(32.4123f));
        assertTrue(myTree.insert(13.5987f));
        assertTrue(myTree.insert(23.4512f));
        assertTrue(myTree.insert(33.47f));
        assertTrue(myTree.insert(14.112f));
        assertTrue(myTree.insert(24.789f));
        assertTrue(myTree.insert(34.2365f));
        assertTrue(myTree.insert(15.4123f));
        assertTrue(myTree.insert(25.478f));
        assertTrue(myTree.insert(35.145f));
        assertTrue(myTree.insert(16.1f));
        assertTrue(myTree.insert(26.4f));
        assertTrue(myTree.insert(36.1122f));
        assertTrue(myTree.insert(17.48f));
        assertTrue(myTree.insert(27.418f));
        assertTrue(myTree.insert(37.41f));
    }
/////////////////////////////////////////////////////
    //Deletion
    @Test
    void delete_1_Element() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1);
        assertTrue(myTree.delete(1));
    }

    @Test
    void deleteNonExistingElement() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1);
        assertFalse(myTree.delete(0));
    }

    @Test
    void deleteManyElements() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1);
        myTree.insert(2);
        myTree.insert(3);
        myTree.insert(4);
        myTree.insert(5);
        assertFalse(myTree.delete(0));
        assertTrue(myTree.delete(1));
        assertTrue(myTree.delete(2));
        assertTrue(myTree.delete(3));
        assertFalse(myTree.delete(50));
        assertTrue(myTree.delete(4));
        assertTrue(myTree.delete(5));
        assertFalse(myTree.delete(78));
    }

    //Size
    @Test
    void sizeWithInsertion () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1);
        myTree.insert(2);
        myTree.insert(23);
        myTree.insert(5);
        myTree.insert(1);
        myTree.insert(5);
        assertEquals(4 , myTree.getSize());
    }

    @Test
    void sizeNullTree() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertEquals(0 , myTree.getSize());
    }

    @Test
    void sizeWithI_and_D() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1);
        myTree.insert(2);
        myTree.insert(23);
        myTree.insert(5);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(1);
    }
}