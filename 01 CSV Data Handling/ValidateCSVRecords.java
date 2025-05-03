import java.io.*;
import java.util.regex.*;

public class ValidateCSVRecords {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\shrin\\OneDrive\\Documents\\CSV_Read_File.csv";


        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                String[] columns = line.split(",");

                String email = columns[3].trim();
                String phone = columns[4].trim();

                boolean isValidEmail = emailPattern.matcher(email).matches();
                boolean isValidPhone = phonePattern.matcher(phone).matches();

                if (!isValidEmail || !isValidPhone) {
                    System.out.println("Invalid row: " + line);
                    if (!isValidEmail) {
                        System.out.println("Error: Invalid Email format -> " + email);
                    }
                    if (!isValidPhone) {
                        System.out.println("Error: Invalid Phone Number (must be 10 digits) -> " + phone);
                    }
                    System.out.println();
                }
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
