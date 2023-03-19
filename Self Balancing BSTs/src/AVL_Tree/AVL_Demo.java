package AVL_Tree;

public class AVL_Demo {
    public static void main(String[] args) {

        System.out.println("Hello World - AVL Demo");
        AVL_Tree<Integer> myTree = new AVL_Tree<Integer> ();
        myTree.insert(1);
        myTree.insert(2);
        myTree.insert(3);
        myTree.insert(4);
        myTree.insert(5);
        myTree.insert(6);
        myTree.insert(7);
        myTree.insert(8);
        myTree.insert(9);
        myTree.insert(10);
        myTree.insert(11);
        myTree.insert(12);
        myTree.insert(13);
        myTree.insert(14);
        myTree.insert(15);
        myTree.insert(16);
        System.out.println(myTree.getRootNode().data);
        System.out.println(myTree.getHeight());
        myTree.delete(8);
        System.out.println(myTree.getHeight());
        System.out.println(myTree.getRootNode().data);
        //myTree.traverse();
    }
}
