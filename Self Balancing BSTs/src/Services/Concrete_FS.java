package Services;

import java.util.*;
import java.io.*;

public class Concrete_FS <T> implements File_Scanner_IF<T>{
    @Override
    public List<T> importData(String filePath) {
        filePath = System.getProperty("user.dir").concat("/../Words_Generator/IO/").concat(filePath);
        ArrayList<T> data = new ArrayList<>();
        File file = new File(filePath);
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String word = sc.nextLine();
                data.add((T)word);
            }
            //System.out.println("Data was imported successfully.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public void exportData(String outputPath, List<T> data) {
        outputPath = System.getProperty("user.dir").concat("/../Words_Generator/IO/").concat(outputPath);;
        File file = new File(outputPath);
        try {
            FileWriter fileWriter = new FileWriter(file);
            for(T word : data)
                fileWriter.write(word + "\n");
            fileWriter.close();
            System.out.println("Data was exported successfully.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
