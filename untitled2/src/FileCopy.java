//S16842

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            // Get filenames from user
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter source file name: ");
            String sourceFile = console.readLine();
            System.out.print("Enter destination file name: ");
            String destinationFile = console.readLine();

            // Open source and destination files
            reader = new BufferedReader(new FileReader(sourceFile));
            writer = new BufferedWriter(new FileWriter(destinationFile));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // keep the line breaks
            }

            System.out.println("File copied successfully from '" + sourceFile + "' to '" + destinationFile + "'.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing files: " + e.getMessage());
            }
        }
    }
}
