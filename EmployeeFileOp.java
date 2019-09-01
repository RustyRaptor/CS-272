package fileops;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;


/*
 * Ziad Arafat
 * Used powerpoint functions as reference
 * I then created seperate functions to get and store the column names and the data
 * I used switch statements to only print the specific columns and checked the age
 * IMPORTANT: Check the README
 */
public class fileops {
	
	public static void main(String[] args) throws IOException {
		writeData(readCSV("core_dataset.csv"),
				readCSVCols("core_dataset.csv"),"young_employee.csv");
	}
	
	
	

	

	
	
	// Read the data from the CSV and return as a 2D String array. 
	public static String[][] readCSV(String inFname) throws IOException {
		BufferedReader inputStream = new BufferedReader(new FileReader(inFname));
		String line;
		int lineno = 1;
		String[][] data = new String[302][20];
		while ((line = inputStream.readLine()) != null) {
			String[] numbers = line.split(",");
			if (lineno == 1) {
				System.out.println();
			}else {
				data[lineno-2] = numbers;
			}
			lineno++;
		}		
		inputStream.close();
		
		return(data);
	}
	

	// Read only the column labels from the fiile and store in it's own 1D array for later use
	public static String[] readCSVCols(String inFname) throws IOException {
		BufferedReader inputStream = new BufferedReader(new FileReader(inFname));
		String line = inputStream.readLine();
		String[] cols = new String[25];
		String[] labels = line.split(",");
		cols = labels;
		inputStream.close();
		return(cols);
	}
	
	// Write data from 2D String array containing data and 1D String array containing labels
	public static void writeData(
			String[][] inData, String[] inDataLabels, String outFname
			) throws IOException {
		PrintWriter outputStream = null;
		Integer ageInt;
		String ageStr;
		
		// print the data labels to the file
		try {
			outputStream = new PrintWriter(new FileWriter(outFname));
			for (int j = 0; j < inDataLabels.length
					&& (inDataLabels[j] != null); j++) {
				
				// This switch case is to ensure only the correct column labels are used in the labels array.
				switch (inDataLabels[j]) {
				case "Employee Fname":
					outputStream.printf(inDataLabels[j] + ",");
					break;
				case "Employee Lname":
					outputStream.printf(inDataLabels[j] + ",");
					break;
				case "Employee Number":
					outputStream.printf(inDataLabels[j] + ",");
					break;
				case "State":
					outputStream.printf(inDataLabels[j] + ",");
					break;
				case "Zip":
					outputStream.printf(inDataLabels[j] + ",");
					break;
				case "Age":
					outputStream.printf(inDataLabels[j] + ",");
					break;
				case "Sex":
					outputStream.printf(inDataLabels[j] + ",");
					break;
				default:
					break;
				}
			}
			// print the data to the file
			outputStream.println();
			for (int i = 0; (i < inData.length-1) && (inData[i] != null); i++) {
				// I parse the age value to an integer for checking age. 
				ageStr = new String(inData[i][6]);
				ageInt = Integer.parseInt(ageStr);
				if (ageInt <= 30) {
					for (int j = 0; j < inDataLabels.length
							&& (inData[i][j] != null); j++) {
						
						// This switch case is to ensure only the correct column labels are used in the data array.
						switch (inDataLabels[j]) {
						case "Employee Fname":
							System.out.println(inData[i][j]);
							System.out.println();
							outputStream.printf(inData[i][j] + ",");
							break;
						case "Employee Lname":
							System.out.println(inData[i][j]);
							outputStream.printf(inData[i][j] + ",");
							break;
						case "Employee Number":
							System.out.println(inData[i][j]);
							outputStream.printf(inData[i][j] + ",");
							break;
						case "State":
							System.out.println(inData[i][j]);
							outputStream.printf(inData[i][j] + ",");
							break;
						case "Zip":
							System.out.println(inData[i][j]);
							outputStream.printf(inData[i][j] + ",");
							break;
						case "Age":
							System.out.println(inData[i][j]);
							outputStream.printf(inData[i][j] + ",");
							break;
						case "Sex":
							System.out.println(inData[i][j]);
							outputStream.printf(inData[i][j] + ",");
							break;
						default:
							break;
						}
					}
					// print a newline when we finish a row
					outputStream.println();
				}
			}
			
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}

	}
	
	
	// This function is not used here it is for later use. It's a simple function to write strings to a file. 
	public static void strToFile(String inStr, String outFname)
			throws IOException {
		String inputStr;
		PrintWriter outputStream = null;
		try {
			inputStr = new String(inStr);
			outputStream = new PrintWriter(new FileWriter(outFname));
			outputStream.println(inputStr);
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}
