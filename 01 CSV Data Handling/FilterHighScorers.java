import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterHighScorers {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\shrin\\OneDrive\\Documents\\students_scores.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");
                int marks = Integer.parseInt(columns[2]);

                if (marks > 80) {
                    System.out.println("ID: " + columns[0] + ", Name: " + columns[1] + ", Marks: " + marks);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
