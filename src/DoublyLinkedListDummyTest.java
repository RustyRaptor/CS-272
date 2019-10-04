public class DoublyLinkedListDummyTest {

	public static void main(String[] args) {
		System.out.println("TESTING ADD END");
		testAddEnd();
		System.out.println("TESTING REMOVE FROM HEAD");
		testRemoveFromHead();
	}

	public static void testAddEnd() {
		DoublyLinkedListDummy test = new DoublyLinkedListDummy();
		for (int i = 1; i <= 10; i++) {
			test.addEnd(i);
		}
		test.printStatistics();
		System.out.println(test);
		System.out.println(test.getHead().getNext().getNext());

	}

	public static void testRemoveFromHead() {
		DoublyLinkedListDummy test = new DoublyLinkedListDummy();
		test.removeFromHead();
		test.removeFromHead();
		test.removeFromHead();
		test.removeFromHead();
		test.printStatistics();
		System.out.println(test);

	}
}
