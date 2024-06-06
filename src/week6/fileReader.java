package week6;

import java.io.*;

public class fileReader {
    public static void main(String[] args) {
        String data = "5\n10\n20\n12\n33\n";

        try {

            FileWriter fWriter = new FileWriter("Patika.txt", false);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(data);
            bWriter.close();


            FileReader fReader = new FileReader("Patika2.txt");
            BufferedReader bReader = new BufferedReader(fReader);
            String line;
            int sum = 0;
            while ((line = bReader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    sum += number;
                    System.out.println("Read number: " + number);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Sum result = " + sum);
            bReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
