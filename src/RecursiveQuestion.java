public class RecursiveQuestion {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(FibBinaryRecursive(i));
			System.out.print(", ");
		}
		System.out.println();
		System.out.println(showCallLevel(10, 1));
		int numberOfDisks = 3;
		HanoiTower(numberOfDisks, 'A', 'B', 'C');

		for (int i = 0; i < 10; i++) {
			System.out.println(BinaryPrint(i));

		}
		Pattern(3, 0);

	}


	/**
	 * Fibonacci Calculator
	 * @param k the index of the fibonacci number you want to get. So if
	 *                 you want the nth fibonacci number, k is n.
	 * @return The fibonacci number you requested
	 */
	private static int FibBinaryRecursive(int k) {
		if (k <= 1) {
			return k;
		}
		return FibBinaryRecursive(k-1) + FibBinaryRecursive(k-2);
	}

	/**
	 * Print out the call ns of a linear binary function
	 * @param L the base case or end of the sequence.
	 * @param curl The starting number of the sequence. (should be 1
	 *                    usually)
	 * @return A string containing the call n print.
	 */
	private static String showCallLevel(int L, int curl) {
		if (L == 0) {
			return "\b\b\b\b\b\b";
		}
		String tabs = new String(new char[curl-1]).replace("\0",
		    "\t");

		return tabs + "This was written by call number" + curl + "x" +
		    "\n" + showCallLevel(L-1,curl+1) + "\n" + tabs +
		    "This was written by call number" + curl + "y";
	}

	/**
	 * prints solution instructions for the Towers of Hanoi game given a
	 * number of disks.
	 * @param a Number of disks.
	 * @param from Starting Peg (String 'A', 'B', or 'C')
	 * @param aux The peg that holds the disks temporarily before making
	 *                   it to the final peg.  (String 'A', 'B', or 'C')
	 * @param to Ending Peg  (String 'A', 'B', or 'C')
	 */
	private static void HanoiTower(int a, char from, char aux, char to) {
		if (a == 1) {
			System.out.println("Move disc 1 from " + from
			    + " to "+ to);
		}
		else {
			HanoiTower(a - 1, from, to, aux);

			System.out.println("Move disc " + a + " from " + from
			    + " to " + to);

			HanoiTower(a-1, aux, from, to);
		}
	}

	/**
	 * prints a given base 10 (decimal) number in binary form.
	 * @param n the decimal number you want to print in binary.
	 * @return The unsigned binary form of a decimal number
	 */
	private static int BinaryPrint(int n){
		if(n == 0){
			return 0;
		}
		else {
			return (n % 2 + 10 * (BinaryPrint(n / 2)));
		}
	}


	/**
	 * prints that weird pattern from the book
	 * @param n max asterisks
	 * @param fn starting tabs (usually 0)
	 */
	private static void Pattern(int n, int fn){
		if(n == 0){
			for(int i = 0; i < fn; i++){
				System.out.print(" ");
			}
			System.out.print("*");
		} else{
			Pattern(n-1, fn);
			System.out.println();
			int count = 2;
			for(int i = 1; i < n; i++){
				count = count * 2;
			}
			for(int i = 0; i < fn; i++){
				System.out.print(" ");
			}
			for(int i = 0; i < count; i++){
				System.out.print("*");
			}
			System.out.println();
			Pattern(n-1, count/2 + fn);
		}
	}

}