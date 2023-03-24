package AVL_Tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVL_Test {

    // insertion        --> 2 might 3
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
    ///////////         Tricky          /////////////
    @Test
    void T_typeOfInput() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(10));
        assertTrue(myTree.insert(0010));        // this is octal value
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
    //////////////////////////////////////////////////////////////
    //Deletion      --> 2
    // delete 1 element     --> 3
    @Test
    void delete_1() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1);
        assertTrue(myTree.delete(1));
    }
    @Test
    void delete_1464587() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1464587);
        assertTrue(myTree.delete(1464587));
    }
    @Test
    void delete_Neg894() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(-894);
        assertTrue(myTree.delete(-894));
    }

    // delete non Existing  element     -->  3
    @Test
    void deleteNonExisting_0() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1);
        assertFalse(myTree.delete(0));
    }
    @Test
    void deleteNonExisting_1() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1);
        assertFalse(myTree.delete(01000));      //octal
    }
    @Test
    void deleteNonExisting_Neg46989() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(46989);
        assertFalse(myTree.delete(-46989));
    }

    // delete combination of the above 2 --> 3
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
    @Test
    void insaneIntegerDeletion() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1);
        myTree.insert(2);
        myTree.insert(33);
        myTree.insert(414);
        myTree.insert(5378);
        myTree.insert(1312);
        myTree.insert(201);
        myTree.insert(34);
        myTree.insert(484);
        myTree.insert(503);
        myTree.insert(114);
        myTree.insert(27);
        myTree.insert(3);
        myTree.insert(4);
        myTree.insert(51);
        myTree.insert(-27);
        myTree.insert(-3);
        myTree.insert(-4);
        myTree.insert(-51);
        assertFalse(myTree.delete(22));
        assertFalse(myTree.delete(32));
        assertFalse(myTree.delete(13));
        assertFalse(myTree.delete(-23));
        assertFalse(myTree.delete(-33));
        assertFalse(myTree.delete(14));
        assertFalse(myTree.delete(-24));
        assertTrue(myTree.delete(34));
        assertFalse(myTree.delete(15));
        assertFalse(myTree.delete(-25));
        assertFalse(myTree.delete(35));
        assertFalse(myTree.delete(34));
        assertTrue(myTree.delete(27));
        assertFalse(myTree.delete(34));
        assertFalse(myTree.delete(17));
        assertFalse(myTree.delete(27));
        assertTrue(myTree.delete(-27));
        assertTrue(myTree.delete(-51));
        assertTrue(myTree.delete(-4));
        assertFalse(myTree.delete(-4));
    }
    @Test
    void insaneFloatDeletion() {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        myTree.insert(1.4f);
        myTree.insert(2.0f);
        myTree.insert(33.4f);
        myTree.insert(414.3f);
        myTree.insert(5378.9f);
        myTree.insert(1312.4f);
        myTree.insert(201.7f);
        myTree.insert(34.69f);
        myTree.insert(484.41f);
        myTree.insert(503.58f);
        myTree.insert(114.4f);
        myTree.insert(27.7f);
        myTree.insert(3.894f);
        myTree.insert(4.456f);
        myTree.insert(51.78f);
        myTree.insert(-27.69f);
        myTree.insert(-3.698f);
        myTree.insert(-4.47f);
        myTree.insert(-51.58f);
        assertFalse(myTree.delete(22.6f));
        assertFalse(myTree.delete(32.89f));
        assertFalse(myTree.delete(13.478f));
        assertFalse(myTree.delete(-23.64f));
        assertFalse(myTree.delete(-33.648f));
        assertFalse(myTree.delete(14.69874f));
        assertFalse(myTree.delete(-24.645123f));
        assertTrue(myTree.delete(34.69f));
        assertFalse(myTree.delete(15.489f));
        assertFalse(myTree.delete(-25.6941f));
        assertFalse(myTree.delete(35.8971f));
        assertFalse(myTree.delete(34.69f));
        assertTrue(myTree.delete(27.7f));
        assertFalse(myTree.delete(34.364f));
        assertFalse(myTree.delete(17.69f));
        assertFalse(myTree.delete(27.69845f));
        assertTrue(myTree.delete(-27.69f));
        assertTrue(myTree.delete(-51.58f));
        assertTrue(myTree.delete(-4.47f));
        assertFalse(myTree.delete(-4.47f));
    }
    ///////////////////////////////////////////////////////////////
    //Search        --> 2
    // one element search --> 10
    @Test
    void search_0 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(0));
        assertTrue(myTree.search(0));
    }
    @Test
    void search_1 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(1));
        assertTrue(myTree.search(1));
    }
    @Test
    void search_567 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(567));
        assertTrue(myTree.search(567));
    }
    @Test
    void search_10000 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(10000));
        assertTrue(myTree.search(10000));
    }
    @Test
    void search_10000000 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(10000000));
        assertTrue(myTree.search(10000000));
    }
    @Test
    void search_Neg1000 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(-1000));
        assertTrue(myTree.search(-1000));
    }
    @Test
    void search_PI_with_3_SigFig () {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(3.14f));
        assertTrue(myTree.search(3.14f));
    }
    @Test
    void search_PI_with_5_SigFig () {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(3.1415f));
        assertTrue(myTree.search(3.1415f));
    }
    @Test
    void search_PI_with_7_SigFig () {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(3.141592f));
        assertTrue(myTree.search(3.141592f));
    }
    @Test
    void search_NegPI_with_7_SigFig () {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(-3.141592f));
        assertTrue(myTree.search(-3.141592f));
    }
    ///////////         Tricky          /////////////
    @Test
    void T_typeOfInputSearch() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(0010));        // this is octal value
        assertTrue(myTree.search(8));
    }
    //////////////////////////////////////////////////////
    // non existing element search --> 5
    @Test
    void search_167 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(1));
        assertFalse(myTree.search(167));
    }
    @Test
    void search_5 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(567));
        assertFalse(myTree.search(5));
    }
    @Test
    void search_PI_with_6_SigFig () {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(3.1415f));
        assertFalse(myTree.search(3.14415f));
    }
    @Test
    void search_PI_with_4_SigFig () {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(3.141592f));
        assertFalse(myTree.search(3.14f));
    }
    @Test
    void search_NegPI_with_1_SigFig () {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        assertTrue(myTree.insert(-3.141592f));
        assertFalse(myTree.search(-3.0f));
    }

    // search combination of the above 2 --> 3
    @Test
    void searchManyElements() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1);
        myTree.insert(2);
        myTree.insert(3);
        myTree.insert(4);
        myTree.insert(5);
        assertFalse(myTree.search(0));
        assertTrue(myTree.search(1));
        assertTrue(myTree.search(2));
        assertTrue(myTree.search(3));
        assertFalse(myTree.search(50));
        assertTrue(myTree.search(4));
        assertTrue(myTree.search(5));
        assertFalse(myTree.search(78));
    }
    @Test
    void insaneIntegerSearch() {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1);
        myTree.insert(2);
        myTree.insert(33);
        myTree.insert(414);
        myTree.insert(5378);
        myTree.insert(1312);
        myTree.insert(201);
        myTree.insert(34);
        myTree.insert(484);
        myTree.insert(503);
        myTree.insert(114);
        myTree.insert(27);
        myTree.insert(3);
        myTree.insert(4);
        myTree.insert(51);
        myTree.insert(-27);
        myTree.insert(-3);
        myTree.insert(-4);
        myTree.insert(-51);
        assertFalse(myTree.search(22));
        assertFalse(myTree.search(32));
        assertFalse(myTree.search(13));
        assertFalse(myTree.search(-23));
        assertFalse(myTree.search(-33));
        assertFalse(myTree.search(14));
        assertFalse(myTree.search(-24));
        assertTrue(myTree.search(34));
        assertFalse(myTree.search(15));
        assertFalse(myTree.search(-25));
        assertFalse(myTree.search(35));
        assertTrue(myTree.search(34));
        assertTrue(myTree.search(27));
        assertTrue(myTree.search(34));
        assertFalse(myTree.search(17));
        assertTrue(myTree.search(27));
        assertTrue(myTree.search(-27));
        assertTrue(myTree.search(-51));
        assertTrue(myTree.search(-4));
        assertTrue(myTree.search(-4));
    }
    @Test
    void insaneFloatSearch() {
        AVL_Tree<Float> myTree = new AVL_Tree<Float>();
        myTree.insert(1.4f);
        myTree.insert(2.0f);
        myTree.insert(33.4f);
        myTree.insert(414.3f);
        myTree.insert(5378.9f);
        myTree.insert(1312.4f);
        myTree.insert(201.7f);
        myTree.insert(34.69f);
        myTree.insert(484.41f);
        myTree.insert(503.58f);
        myTree.insert(114.4f);
        myTree.insert(27.7f);
        myTree.insert(3.894f);
        myTree.insert(4.456f);
        myTree.insert(51.78f);
        myTree.insert(-27.69f);
        myTree.insert(-3.698f);
        myTree.insert(-4.47f);
        myTree.insert(-51.58f);
        assertFalse(myTree.search(22.6f));
        assertFalse(myTree.search(32.89f));
        assertFalse(myTree.search(13.478f));
        assertFalse(myTree.search(-23.64f));
        assertFalse(myTree.search(-33.648f));
        assertFalse(myTree.search(14.69874f));
        assertFalse(myTree.search(-24.645123f));
        assertTrue(myTree.search(34.69f));
        assertFalse(myTree.search(15.489f));
        assertFalse(myTree.search(-25.6941f));
        assertFalse(myTree.search(35.8971f));
        assertTrue(myTree.search(34.69f));
        assertTrue(myTree.search(27.7f));
        assertFalse(myTree.search(34.364f));
        assertFalse(myTree.search(17.69f));
        assertFalse(myTree.search(27.69845f));
        assertTrue(myTree.search(-27.69f));
        assertTrue(myTree.search(-51.58f));
        assertTrue(myTree.search(-4.47f));
        assertTrue(myTree.search(-4.47f));
    }
    ///////////////////////////////////////////////////////////////
    //Size  --> 4       ----> 1
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
    void sizeWithInsaneInsertion () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(1);
        myTree.insert(2);
        myTree.insert(23);
        myTree.insert(564);
        myTree.insert(1121245);
        myTree.insert(76422);
        myTree.insert(5676523);
        myTree.insert(577576);
        myTree.insert(175676);
        myTree.insert(5672);
        myTree.insert(25673);
        myTree.insert(55467);
        myTree.insert(15768);
        myTree.insert(27656);
        myTree.insert(277573);
        myTree.insert(4575);
        myTree.insert(85671);
        myTree.insert(74542);
        myTree.insert(2783);
        myTree.insert(67865);
        myTree.insert(2781);
        myTree.insert(782);
        myTree.insert(27853);
        myTree.insert(7855);
        myTree.insert(121);
        myTree.insert(245);
        myTree.insert(278523);
        myTree.insert(587);
        myTree.insert(451);
        myTree.insert(1232);
        myTree.insert(27573);
        myTree.insert(5454);
        myTree.insert(00114);
        myTree.insert(221);
        myTree.insert(2453);
        myTree.insert(57856);
        myTree.insert(186);
        myTree.insert(72);
        myTree.insert(233);
        myTree.insert(5452);
        myTree.insert(112);
        myTree.insert(20);
        myTree.insert(203);
        myTree.insert(500);
        assertEquals(44 , myTree.getSize());
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
        myTree.delete(1);
        myTree.delete(5);
        myTree.delete(78);
        assertEquals(2 , myTree.getSize());
    }
    //Height    --> 3        -> 1
    @Test
    void iHeightOfNull () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertEquals(-1 , myTree.getHeight());
    }
    @Test
    void HeightOfOne () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(1));
        assertEquals(0 , myTree.getHeight());
    }
    @Test
    void HeightOf4 () {
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        assertTrue(myTree.insert(1));
        assertTrue(myTree.insert(2));
        assertTrue(myTree.insert(3));
        assertTrue(myTree.insert(4));
        assertEquals(2 , myTree.getHeight());
    }
    //////////////////////////////////////////////////////////////
    //////////       Rotations         /////////////
    //Left rotation
    @Test
    void RootNodeBecomes_2L () {   //root node is 8 before rotation and 5 after rotation
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(0);
        myTree.insert(1);
        myTree.insert(2);
        myTree.insert(3);
        myTree.insert(4);
        myTree.insert(5);
        assertEquals(3, myTree.getRootNode().data);
        assertEquals(2, myTree.getHeight());
    }
    //right rotation
    @Test
    void RootNodeBecomes_2R () {   //root node is 8 before rotation and 5 after rotation
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(5);
        myTree.insert(4);
        myTree.insert(3);
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(0);
        assertEquals(2, myTree.getRootNode().data);
        assertEquals(2, myTree.getHeight());
    }
    @Test
    void height_Before_Right_Rotation_Is_3_After_Is_2() {   //root node is 8 before rotation and 5 after rotation
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(8);
        myTree.insert(10);
        myTree.insert(5);
        myTree.insert(3);
        myTree.insert(7);
        myTree.insert(4);
        myTree.insert(3);
        assertEquals(5, myTree.getRootNode().data);
        assertEquals(2, myTree.getHeight());
    }
    //left_right rotation
    @Test
    void height_Before_Left_Right_Rotation_Is_3_After_Is_2() {      //root node is 8 before rotation and 7 after rotation
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(8);
        myTree.insert(10);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(4);
        myTree.insert(6);
        assertEquals(7, myTree.getRootNode().data);
        assertEquals(2, myTree.getHeight());
    }
    //right_left rotation
    @Test
    void height_Before_Right_Left_Rotation_Is_3_After_Is_2() {  ////root node is 3 before rotation and 4 after rotation
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer>();
        myTree.insert(3);
        myTree.insert(6);
        myTree.insert(1);
        myTree.insert(4);
        myTree.insert(8);
        myTree.insert(5);
        assertEquals(4, myTree.getRootNode().data);
        assertEquals(2, myTree.getHeight());
    }
}
