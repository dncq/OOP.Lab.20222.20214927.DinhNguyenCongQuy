package hust.soict.dsai.Lab01.JavaBasics.src;

import java.util.Scanner;
public class InputFromKeyboard_6_2 {
	public static void main(String[] arg) {
		Scanner keyboard = new Scanner(System.in);
		
		
		System.out.println("What's your name?");
		String strName = keyboard.nextLine();
		System.out.println("How old are you?");
		int iAge = keyboard.nextInt();
		System.out.println("How tall are you? (m)");
		double dHeight = keyboard.nextDouble();
		
		
		System.out.println("Mrs/Ms. " + strName + ", " + iAge + " years old. " 
							+ "Your height is " + dHeight + ".");
	}
}
