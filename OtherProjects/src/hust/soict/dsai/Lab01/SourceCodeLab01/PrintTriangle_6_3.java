package hust.soict.dsai.Lab01.SourceCodeLab01;
import java.util.Scanner;

public class PrintTriangle_6_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the height of the triangle: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (2*n+1); j++) {
                if (j <= n-i || j >= n+i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}