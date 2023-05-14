import java.util.Scanner;
public class Sort_the_Array_6_5{
	public static void sort(int[] arr) {
		int swapped;
		do {
			swapped = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i+1]) {
					int tmp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = tmp;
					swapped = 1;
				}
			}
		}
		while (swapped == 1);
	}
	public static int sumofarray(int[] arr){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	public static double average(int [] arr) {
		return sumofarray(arr) / (arr.length);
	}
	public static void main(String[] arg) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) { 
			arr[i] = input.nextInt();
		}
		sort(arr);
		System.out.println("The sorted array: ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(" ");
		System.out.println("The sum of the array: " + sumofarray(arr));
		System.out.println("The average of the array: " + average(arr));
	}
}
	

