public class DoublyLinkedListDummyTest {

	public static void main(String[] args) {
		announceTest("ADD END");
		testAddEnd();
		announceTest("REMOVE FROM HEAD");
		testRemoveFromHead();
		announceTest("PRINT STATISTICS");
		testPrintStatistics();
		announceTest("SUBLIST");
		testSubList();
		announceTest("REMOVEALL");
		testRemoveAll();
	}

	public static void announceTest(String name) {
		for (int i = 0; i < 50; i++) {
			System.out.print("=");
		}
		System.out.println();
		System.out.println("TESTING " + name);

		System.out.println();
	}
	public static void testAddEnd() {
		DoublyLinkedListDummy test = new DoublyLinkedListDummy();
		for (int i = 1; i <= 10; i++) {
			test.addEnd(i);
		}
		System.out.println(test);
		test.addEnd(20);
		System.out.println(test);

	}

	public static void testRemoveFromHead() {
		DoublyLinkedListDummy test = new DoublyLinkedListDummy();
		test.removeFromHead();
		System.out.println(test);
		test.removeFromHead();
		System.out.println(test);
		for (int i = 1; i <= 10; i++) {
			test.addEnd(i);
		}
		System.out.println(test);
		for (int i = 0; i < 5; i++) {
			test.removeFromHead();
		}
		System.out.println(test);


	}
	public static void testPrintStatistics() {
		DoublyLinkedListDummy test = new DoublyLinkedListDummy();
		test.printStatistics();
		test.printStatistics();
		for (int i = 1; i <= 10; i++) {
			test.addEnd(i);
		}
		test.printStatistics();
		for (int i = 1; i <= 10; i++) {
			test.addEnd(i);
		}
		test.printStatistics();
		test.addEnd(10);
		test.addEnd(5);
		test.addEnd(1);
		test.addEnd(10);
		test.printStatistics();
		for (int i = 0; i < 5; i++) {
			test.removeFromHead();
		}
		test.printStatistics();
		for (int i = 0; i < 20; i++) {
			test.removeFromHead();
		}
		test.printStatistics();

	}

	public static void testSubList() {
		DoublyLinkedListDummy test = new DoublyLinkedListDummy();
		test.subList(0, 10);
		test.subList(10, 20);
		System.out.println(test.subList(0, 10));
		for (int i = 1; i <= 30; i++) {
			test.addEnd(i);
		}
		System.out.println(test.subList(0, 10));
		System.out.println(test.subList(10, 20));
		System.out.println(test.subList(0, 100));
		System.out.println(test.subList(-1, -10));

	}

	public static void testRemoveAll() {
		DoublyLinkedListDummy test = new DoublyLinkedListDummy();
		test.removeAll(0);
		System.out.println(test);
		for (int i = 1; i <= 10; i++) {
			test.addEnd(i);
		}
		System.out.println(test);
		test.removeAll(5);
		System.out.println(test);
		for (int i = 1; i <= 5; i++) {
			test.addEnd(5);
		}
		System.out.println(test);
		test.removeAll(5);
		System.out.println(test);
	}
}
