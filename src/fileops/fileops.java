package fileops;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;


/*
 * I just copied the functions from the powerpoint and studied them.
 * Then I used the copyLine function to make a strToFile function.
 */
public class fileops {

	public static void copyCharacter(String inFname, String outFname) throws IOException {
		FileReader in = new FileReader(inFname);
		FileWriter out = new FileWriter(outFname);

		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}

		in.close();
		out.close();
		System.out.println("output	is	" + outFname);
	}

	public static void copyLine(String inFname, String outFname) throws IOException {
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(inFname));
			outputStream = new PrintWriter(new FileWriter(outFname));
			String line;
			while ((line = inputStream.readLine()) != null) {
				outputStream.println(line);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
	
	
	
	public static void readTestCase(String testFname) throws IOException {
		BufferedReader inputStream = new BufferedReader(new FileReader(testFname));
		String line;
		int lineno = 1;
		while ((line = inputStream.readLine()) != null) {
			String[] numbers = line.split("	");
			System.out.println("Line	" + (lineno++) + "	parameters:");
			for (int i = 0; i < numbers.length; i++)
				System.out.print(numbers[i] + "	");
			System.out.println();
		}
		inputStream.close();
	}
	
	public static void strToFile(String inStr, String outFname) throws IOException {
		String inputString;
		PrintWriter outputStream = null;
		try {
			inputString = new String(inStr);
			outputStream = new PrintWriter(new FileWriter(outFname));
			outputStream.println(inputString);
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}
