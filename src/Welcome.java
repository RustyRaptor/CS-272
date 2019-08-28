import java.io.IOException;

import fileops.fileops;


public class Welcome {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to Java");
		System.out.println(System.currentTimeMillis());
		Long timeLong = System.currentTimeMillis();
		String timeStr = new String(timeLong.toString());
		fileops.strToFile(timeStr, "eclipse_test.txt");
	}
}
