import java.util.Scanner;
public class SumOfMatrices_6_6 {
	public static void main(String[] arg) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int m = input.nextInt();
		System.out.println("Enter the number of columns: ");
		int n = input.nextInt();
		int[][] a1 = new int[m][n];
		int[][] a2 = new int[m][n];
		System.out.println("Entries for matrix 1: ");
		for(int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a1[i][j] = input.nextInt();
			}
		}
		System.out.println("Entries for matrix 2: ");
		for(int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a2[i][j] = input.nextInt();
			}
		}
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = a1[i][j] + a2[i][j];
			}
		}
		System.out.println("Sum of the two matrices: ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}

