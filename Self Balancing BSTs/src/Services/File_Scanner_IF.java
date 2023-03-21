package Services;

import java.util.*;
public interface File_Scanner_IF<T> {

    List<T> importData(String filePath);
    void exportData(String outputPath, List<T> data);

}
