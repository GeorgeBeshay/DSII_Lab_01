package Services;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        File_Scanner_IF<String> fileScanner = new Concrete_FS<String>();
        List<String> in = fileScanner.importData("generated_words");
        for(String word : in){
            System.out.println(word);
        }
        fileScanner.exportData("output", in);
    }
}
