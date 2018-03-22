package LAB;

import java.io.*;

public class P09_Print_File {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.print("Enter full path to the file to print: ");
                String filePath = reader.readLine().trim();

                try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
                    br.lines().forEach(System.out::println);
                    System.out.println("File printed successfully");
                    break;
                } catch (FileNotFoundException e) {
                    System.out.println("File not found");
                    System.out.print("Enter 'y' to retry: ");
                    if (!"y".equalsIgnoreCase(reader.readLine().trim())) {
                        break;
                    }
                }
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
