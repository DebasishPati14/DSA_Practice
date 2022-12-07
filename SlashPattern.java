package DSA_Practice;

import java.util.Scanner;

public class SlashPattern {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    System.out.print("\t");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        scan.close();
    }
}
