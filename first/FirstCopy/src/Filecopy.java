import java.io.*;

public class FileCopyProgram {

    public static void main(String[] args) {

        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        try {
            FileInputStream input = new FileInputStream(sourceFile);
            FileOutputStream output = new FileOutputStream(destFile);

            int data;
            while ((data = input.read()) != -1) {
                output.write(data);
            }

            input.close();
            output.close();

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}