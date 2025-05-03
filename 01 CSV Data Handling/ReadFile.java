import java.io.*;
import java.util.*;
public class ReadFile {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\shrin\\OneDrive\\Documents\\CSV Read File.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            while((line = br.readLine()) != null){
                String[] columns = line.split(",");
                System.out.println("ID: " + columns[0] + ", Name : " + columns[1]);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
