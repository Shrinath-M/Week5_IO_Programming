import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\shrin\\OneDrive\\Documents\\students1.csv";
        String file2 = "C:\\Users\\shrin\\OneDrive\\Documents\\students2.csv";
        String outputFile = "C:\\Users\\shrin\\OneDrive\\Documents\\merged_students.csv";

        Map<String, String[]> studentMap = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] columns = line.split(",");
                studentMap.put(columns[0], new String[]{columns[1], columns[2]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] columns = line.split(",");
                if (studentMap.containsKey(columns[0])) {
                    String[] studentInfo = studentMap.get(columns[0]);
                    studentMap.put(columns[0], new String[]{studentInfo[0], studentInfo[1], columns[1], columns[2]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n");

            for (Map.Entry<String, String[]> entry : studentMap.entrySet()) {
                String[] details = entry.getValue();
                bw.write(entry.getKey() + "," + String.join(",", details) + "\n");
            }

            System.out.println("Merged file saved as merged_students.csv!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
