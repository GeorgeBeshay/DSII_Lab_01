package TimeAnalysis;

import java.util.*;

public class TimeAnalysis_Demo {


    public static void main(String[] args) {
        ArrayList<Integer> sizesToObserve = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();
        for(int i = 10 ; i < (int)Math.pow(10, 6) * 9 ; i *= 2) {
            sizesToObserve.add(i);
            results.add(i + "\t");
        }
        AVL_RB_Comparison comparison = new AVL_RB_Comparison(sizesToObserve, null);
        comparison.AVL_RB_Deletion_Comparison(
                comparison.AVL_RB_Height_Comparison(
                        comparison.AVL_RB_Search_Comparison(
                                comparison.AVL_RB_Insertion_Comparison(results)
                        )
                )
        );
        System.out.println("All columns in any point of comparison starts by AVL.");
        System.out.println("Size - Insertion - Searching - getHeight - Height - Deletion");
        for(String result : results)
            System.out.println(result);
    }

}
