package week5;

import java.util.Scanner;

public class listSelectedIndex {
    public static void main(String[] args) {

        int[] array = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an index: ");
        int index = scanner.nextInt();


        String result = getElementAtIndex(array, index);
        System.out.println(result);

        scanner.close();
    }

    public static String getElementAtIndex(int[] array, int index) {
        try {
            int element = array[index];
            return "Element at index " + index + " is: " + element;
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Index is out of bounds!";
        }
    }
}
