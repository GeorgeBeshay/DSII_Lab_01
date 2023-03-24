package AVL_Tree;

public class AVL_Demo {
    public static void main(String[] args) {


        AVL_Tree<String> myTree = new AVL_Tree<String> ();

        myTree.batchInsert("generatedWords");
        System.out.println(myTree.getSize());
        System.out.println(myTree.getHeight());
        System.out.println(myTree.getRootNode().data);
        System.out.println(myTree.getRootNode().left.data);
        System.out.println(myTree.getRootNode().right.data);
        myTree.batchDelete("generatedWords");
        System.out.println(myTree.getSize());

    }
}
