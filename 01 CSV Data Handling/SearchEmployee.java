import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployee {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\shrin\\OneDrive\\Documents\\CSV_Read_File.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filepath));
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter employee name to search: ");
            String searchName = scanner.nextLine().trim().toLowerCase();

            boolean isHeader = true;
            boolean found = false;
            String line;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }

                String[] columns = line.split(","); // CSV format: ID, Name, Department, Salary
                String name = columns[1].trim().toLowerCase();

                if (name.equals(searchName)) {
                    System.out.println("Department: " + columns[2]);
                    System.out.println("Salary: " + columns[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
