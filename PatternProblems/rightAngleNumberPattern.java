package DSA_Practice.PatternProblems;

import java.util.*;

public class rightAngleNumberPattern {
    public static void main(String[] args) {
        System.out.print("Enter Length");
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int printingNumber = 1;
        for (int row = 1; row < length; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(printingNumber + "\t");
                printingNumber++;
            }
            System.out.println("\n");
        }

        scan.close();
    }

}
