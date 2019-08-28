/*
 * Ziad Arafat
 * I just imported my strToFile function from the fileops package I created
 */

import fileops.fileops;
import java.io.IOException;
public class Addition {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		int number = 10;
		int step = 1;
		int summation =0;
		
		for (int i=0; i<number; i++){
			summation+=step;
			step *= 2;
		}
		// Convert into to string
		Integer summationInt = summation;
		String summationString = new String(summationInt.toString());
		
		System.out.println("Summation for number " + number +" is: " + summation);
		
		// output result string to file. 
		fileops.strToFile(summationString, "eclipse_test.txt");
		
	}
}
