import java.util.Arrays;
import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		LinkedQueue<String> wordq = new LinkedQueue<String>();
		LinkedQueue<String> wordj = new LinkedQueue<String>();

		Scanner inp = new Scanner(System.in);

		System.out.println("enter sentence");
		String nn = inp.nextLine();
		nn = nn.toLowerCase();
		String[] punct = {"!", ".", "?",","};
		System.out.println(nn);
		for (String s : punct) {
			nn = nn.replace(s, "");
		}
		String[] nn2 = nn.split(" ");
		System.out.println(Arrays.toString(nn2));
		for (String s : nn2) {
			wordq.enqueue(s);
		}
		System.out.println(wordq);
		for (int i = nn2.length-1; i >= 0; i--) {
			wordj.enqueue(nn2[i]);
		}
		System.out.println(wordj);
		boolean palindrome = true;
		while(!wordj.isEmpty()) {
			if (!wordj.dequeue().equals(wordq.dequeue())){
				palindrome = false;
				break;
			}
		}


		if (palindrome){

			System.out.println("This sentence is a palindrome " +
			    "indeed");
		} else {
			System.out.println("This sentence is not a palindrome");
		}

	}
}
