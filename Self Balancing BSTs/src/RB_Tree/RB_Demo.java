package RB_Tree;

public class RB_Demo {
    public static void main(String[] args) {
//        int[] arr = {150, 100, 200, 50, 120, 130, 110};
//        RB_Tree<Integer> tree = new RB_Tree<Integer>();
//        for (int j : arr) tree.insert(j);
//        tree.delete(50);
//        List<RB_Node<Integer>> nodes = tree.convert_to_list();
//        System.out.println("Root is :" + tree.getRoot().getData());
//        for(RB_Node<Integer> node : nodes)
//            System.out.println(node.getData() + " isRed: " + node.isRed());

        RB_Demo myDemo = new RB_Demo();
        myDemo.testing();
//        myDemo.testing_2();
//        int[] arr = {5, 10, 15, 3};
//        RB_Tree<Integer> tree = new RB_Tree<Integer>();
//        for(int i = 0 ; i < 4 ; i++)
//            tree.insert(arr[i]);
//        tree.delete(3);
//        tree.insert(20);
//        tree.insert(20);
//        tree.delete(5);
//        tree.insert(18);
//        tree.delete(10);
//        tree.insert(10);
//        tree.delete(20);
//        tree.delete(20);
//        tree.insert(13);
//        tree.delete(18);
//        tree.insert(14);
//        tree.insert(16);
//        tree.insert(17);
//        tree.delete(17);
//        tree.delete(10);
//
//        List<RB_Node<Integer>> nodes = tree.convert_to_list();
//        System.out.println("Root is :" + tree.getRoot().getData());
//        for(RB_Node<Integer> node : nodes)
//            System.out.println(node.getData() + " isRed: " + node.isRed());
    }

    public void testing(){
        RB_Tree<String> myTree = new RB_Tree<String>();
//        System.out.println(myTree.insert("ab"));
//        System.out.println(myTree.delete("ab"));
        System.out.println(myTree.batchInsert("generated_words"));
        System.out.println(myTree.batchDelete("generated_words"));
//        System.out.println(myTree.batchDelete("dataToDelete"));
//        System.out.println(myTree.batchDelete("dataToDelete"));
//        myTree.export("output");
        myTree.validateTree();
    }

    public void testing_2(){
        RB_Tree<Integer> myTree = new RB_Tree<Integer>();
        System.out.println(myTree.insert(1));
        System.out.println(myTree.insert(2));
        System.out.println(myTree.insert(0));
        System.out.println(myTree.insert(100));
        System.out.println(myTree.insert(50));
        System.out.println(myTree.insert(23));
        System.out.println(myTree.insert(5));
        System.out.println(myTree.insert(200));
        System.out.println(myTree.insert(189));
        myTree.validateTree();
    }
}
