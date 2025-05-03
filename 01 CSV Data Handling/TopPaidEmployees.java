import java.io.*;
import java.util.*;

public class TopPaidEmployees {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\shrin\\OneDrive\\Documents\\CSV_Read_File.csv";
        List<String[]> employeeList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");
                employeeList.add(columns); // Store employee details
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        employeeList.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));


        System.out.println("Top 5 highest-paid employees:");
        for (int i = 0; i < Math.min(5, employeeList.size()); i++) {
            String[] emp = employeeList.get(i);
            System.out.println("ID: " + emp[0] + ", Name: " + emp[1] + ", Department: " + emp[2] + ", Salary: " + emp[3]);
        }
    }
}
