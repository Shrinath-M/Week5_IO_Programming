import java.io.*;
import java.util.*;

public class ReadStudentCSV {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\shrin\\OneDrive\\Documents\\students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0].trim());
                String name = columns[1].trim();
                int age = Integer.parseInt(columns[2].trim());
                String grade = columns[3].trim();

                students.add(new Student(id, name, age, grade));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }


        System.out.println("Student Records:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
