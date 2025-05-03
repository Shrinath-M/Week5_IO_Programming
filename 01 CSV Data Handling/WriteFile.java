import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\shrin\\OneDrive\\Documents\\CSV_Read_File.csv";

        try (BufferedWriter br = new BufferedWriter(new FileWriter(filepath))) {
            br.write("ID,Name,Department,Salary\n");
            br.write("104,Alice Williams,Finance,62000\n");
            br.write("105,Bob Johnson,Sales,58000\n");

            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception properly
        }
    }
}

