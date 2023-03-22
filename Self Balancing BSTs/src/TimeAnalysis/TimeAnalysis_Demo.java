package TimeAnalysis;

public class TimeAnalysis_Demo {


    public static void main(String[] args) {
        AVL_RB_Comparison comparer = new AVL_RB_Comparison();
        comparer.AVL_RB_Insertion_Comparison(10000, (int) Math.pow(10, 7));
        //comparer.AVL_RB_Deletion_Comparison();
        comparer.AVL_RB_Search_Comparison();
    }

}
