package week6;

import java.io.*;
import java.util.Scanner;

public class fileWriter {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Bir metin girin: ");
            String data = input.nextLine();

            try {

                FileWriter fWriter = new FileWriter("file.txt", true);
                BufferedWriter bWriter = new BufferedWriter(fWriter);
                bWriter.write(data);
                bWriter.close();
                //Okuma
                FileReader fReader = new FileReader("file.txt");
                BufferedReader bReader = new BufferedReader(fReader);
                String line;
                while ((line = bReader.readLine()) != null) {
                    try {
                        System.out.println(line);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.print(" ");
    }
}
