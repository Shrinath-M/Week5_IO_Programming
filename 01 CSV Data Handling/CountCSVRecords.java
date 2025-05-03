import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRecords {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\shrin\\OneDrive\\Documents\\CSV_Read_File.csv";
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                recordCount++;
            }

            System.out.println("Total records (excluding header): " + recordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
