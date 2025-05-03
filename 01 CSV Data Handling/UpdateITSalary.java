import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateITSalary {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\shrin\\OneDrive\\Documents\\employees.csv";
        String outputFile = "C:\\Users\\shrin\\OneDrive\\Documents\\updated_employees.csv";

        List<String> updatedRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    updatedRecords.add(line); // Add header row unchanged
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");
                String department = columns[2].trim();
                double salary = Double.parseDouble(columns[3].trim());

                // Increase salary by 10% if department is "IT"
                if ("IT".equalsIgnoreCase(department)) {
                    salary *= 1.10;
                }

                // Format the updated record and store it
                updatedRecords.add(columns[0] + "," + columns[1] + "," + department + "," + String.format("%.2f", salary));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Write the updated records to a new CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String record : updatedRecords) {
                bw.write(record);
                bw.newLine();
            }
            System.out.println("Updated employees.csv file saved as updated_employees.csv!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
