import java.io.*;

public class ChunkCSVReader {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\shrin\\OneDrive\\Documents\\large_data.csv";
        int batchSize = 100;
        int totalProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            boolean isHeader = true;
            int count = 0;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }


                System.out.println("Processing: " + line);

                count++;
                totalProcessed++;


                if (count == batchSize) {
                    System.out.println("Processed " + totalProcessed + " records so far...");
                    count = 0;
                }
            }

            System.out.println("Total records processed: " + totalProcessed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
