import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Permutation {
	public static void main(String[] args) {
		ArrayList<String> testArray1 = new ArrayList<>(Arrays.asList(
		    "A"));

		ArrayList<String> testArray2 = new ArrayList<>(Arrays.asList(
		    "A",
		    "B"));

		ArrayList<String> testArray5 = new ArrayList<>(Arrays.asList(
		    "A",
		    "B", "C", "D", "E"));

		ArrayList<String> testArray10 = new ArrayList<>(Arrays.asList(
		    "A",
		    "B", "C", "D", "E", "F", "G", "H", "I", "J"));

		Permutation(testArray1, 0, testArray1.size()-1);
		Permutation(testArray2, 0, testArray2.size()-1);
		Permutation(testArray5, 0, testArray5.size()-1);
		Permutation(testArray10, 0, testArray10.size()-1);
	}

	public static void Permutation(ArrayList<String> a, int i, int n)
	{
		int j;
		if (i == n)                  // If we've chosen all the characters then:
			System.out.println((a.toString()));        //
			// we're done, so
			// output it
		else
		{
			for (j = i; j <= n; j++) // Otherwise, we've chosen characters a[0] to a[j-1]
			{                        // so let's try all possible characters for a[j]
				Collections.swap(a, i, j);    // Choose
				// which
				// one out of a[j] to a[n] you will choose
				Permutation(a, i+1, n);  // Choose the remaining
				// letters
				Collections.swap(a, i, j);   // Undo the
				// previous
				// swap so we
				// can
				// choose the next possibility for a[j]
			}
		}
	}
}
