package hust.soict.dsai.garbage;


import java.io.*;

public class GarbageCreator {
	public static void main(String[] args) throws IOException {
		FileReader input = null;
		long start = System.currentTimeMillis();
		String outputString = "";
		try {
			input = new FileReader("C:\\Eclipse Workspace\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\test.txt");
			
			int c;
			while((c = input.read()) != -1) {
				outputString += c;
			}
			System.out.println("Execution time: " + (System.currentTimeMillis() - start));
		} finally {
			if (input != null) {
				input.close();
			}
		}
		System.out.println("String is: " + outputString);
	}
}
