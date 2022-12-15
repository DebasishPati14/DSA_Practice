package DSA_Practice.PatternProblems;

import java.util.Scanner;

public class rightAngledFibonacciPattern {
    public static void main(String[] args) {
        System.out.print("Enter length: ");
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int a = 0;
        int b = 1;
        int c = 0;
        for (int row = 1; row < length; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(c + "\t");
                a = b;
                b = c;
                c = a + b;
            }

            System.out.println();
            scan.close();
        }
    }
}
