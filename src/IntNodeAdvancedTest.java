/**
 * A set of functions to test all the features of IntNode
 * also includes a testAll(); function just to run them some more because why
 * not.
 */

public class IntNodeAdvancedTest {
	/**
	 * This main function just runs all the test functions.
	 */
	public static void main(String[] args) {
		System.out.println("Testing add node");
		testAddNodeAfterThis();
		testAddRangeAfterThis();
		testPrintData();
		testRemoveNodeAfterThis();
		testTestToString();
		testSearch();
		testListEvenNumber();
		testListLength();
		System.out.println("Testing Sum Last");
		testSumLast();
		System.out.println();
		System.out.println("Testing Copy ODD");
		testCopyOdd();
		System.out.println("TESTING REMOVE ALL");
		testRemoveAll();
		System.out.println("Testing All");
		testAll();
	}

	private static void testRemoveAll() {
		IntNode myNode = new IntNode();
		System.out.println(IntNode.removeAll(myNode, 5));
		myNode.addRangeAfterThis(0, 100);
		System.out.println(IntNode.removeAll(myNode, 5));

	}

	private static void testCopyOdd() {
		IntNode myNode = new IntNode();
		System.out.println(IntNode.copyOdd(myNode));
		myNode.addRangeAfterThis(0, 10);
		System.out.println(IntNode.copyOdd(myNode));

	}

	private static void testSumLast() {
		IntNode myNode = new IntNode();
		System.out.println(IntNode.sumLast(myNode, 2));
		myNode.addRangeToEnd(0, 100);
		System.out.println(myNode);
		System.out.println(IntNode.sumLast(myNode, 100));
		System.out.println(IntNode.sumLast(myNode, 1));
		for (int i = 0; i < 100; i++){
			System.out.print(IntNode.sumLast(myNode, i) + " ");
		}
	}


	private static void testListLength() {
		IntNode myNode = new IntNode();
		System.out.println(IntNode.listLength(myNode));
		myNode.addRangeAfterThis(0, 100);
		System.out.println(IntNode.listLength(myNode));
		myNode.addRangeAfterThis(1000, 2000);
		System.out.println(IntNode.listLength(myNode));

	}


	private static void testAddRangeAfterThis() {
		IntNode myNode = new IntNode();
		myNode.addRangeAfterThis(0, 100);
		myNode.getLink().getLink().getLink().getLink()
		    .addRangeAfterThis(100, 200);
		myNode.addRangeAfterThis(0, 100);
		myNode.addRangeAfterThis(1000, 1100);
		myNode.getLink().getLink().addRangeAfterThis(1000, 1100);

	}

	private static void testListEvenNumber() {
		IntNode myNode = new IntNode();
		System.out.println(IntNode.listEvenNumber(myNode));
		myNode.addRangeAfterThis(0, 100);
		System.out.println(IntNode.listEvenNumber(myNode));
		myNode.getLink().getLink().getLink().getLink()
		    .addRangeAfterThis(100, 200);
		System.out.println(IntNode.listEvenNumber(myNode));
		myNode.addRangeAfterThis(0, 100);
		System.out.println(IntNode.listEvenNumber(myNode));
		myNode.addRangeAfterThis(1000, 1100);
		System.out.println(IntNode.listEvenNumber(myNode));
		myNode.getLink().getLink().addRangeAfterThis(1000, 1100);
		System.out.println(IntNode.listEvenNumber(myNode));

	}


	private static void testAddNodeAfterThis() {
		IntNode myNode = new IntNode();
		myNode.addNodeAfterThis(22);
		myNode.addNodeAfterThis(22);
		myNode.addNodeAfterThis(1000);
		myNode.addNodeAfterThis(-1000);
		myNode.addNodeAfterThis(-2000);
		myNode.addNodeAfterThis(0);
	}


	private static void testRemoveNodeAfterThis() {
		IntNode myNode = new IntNode();
		myNode.removeNodeAfterThis();
		myNode.addRangeAfterThis(0, 100);
		myNode.removeNodeAfterThis();
	}


	private static void testTestToString() {
		IntNode myNode = new IntNode();
		System.out.println(myNode.toString());


	}


	private static void testPrintData() {
		IntNode myNode = new IntNode();
		System.out.println(myNode.toString());
		myNode.printData();
		myNode.addNodeAfterThis(22);
		myNode.printData();
		myNode.addRangeAfterThis(0, 100);
		myNode.printData();
		myNode.removeNodeAfterThis();
		myNode.removeNodeAfterThis();
		myNode.printData();
		myNode.removeXNodesAfterThis(100);
		myNode.printData();
	}

	private static void testAll() {
		IntNode myNode = new IntNode();
		IntNodeAdvancedTest.testSearch();
		System.out.println(myNode.toString());
		System.out.println("Testing toString with Null");
		myNode.printData();
		myNode.addNodeAfterThis(22);
		System.out.println("Testing Add Node After This");
		myNode.printData();
		myNode.addRangeAfterThis(0, 100);
		System.out.println("Testing add range");
		myNode.printData();
		myNode.removeNodeAfterThis();
		myNode.removeNodeAfterThis();
		System.out.println("Testing Remove Node After THis");
		myNode.printData();
		myNode.removeXNodesAfterThis(100);
		System.out.println("Testing Remove X Nodes");
		myNode.printData();
		System.out.println(myNode.toString());
		myNode.addRangeAfterThis(0, 100);
		myNode.addRangeAfterThis(1000, 1100);
		myNode.getLink().getLink().addRangeAfterThis(1000, 1100);
		myNode.removeNodeAfterThis();
		myNode.addRangeAfterThis(0, 100);
		myNode.removeNodeAfterThis();
		myNode.addNodeAfterThis(22);
		myNode.addNodeAfterThis(22);
		myNode.addNodeAfterThis(1000);
		myNode.addNodeAfterThis(-1000);
		myNode.addNodeAfterThis(-2000);
		myNode.addNodeAfterThis(0);
		myNode.addRangeAfterThis(0, 100);
		myNode.addRangeAfterThis(0, 100);
		System.out.println(myNode.toString());
		IntNodeAdvancedTest.testAddNodeAfterThis();
		IntNodeAdvancedTest.testAddRangeAfterThis();
		System.out.println("Testing toString()");
		System.out.println(myNode.toString());
		IntNodeAdvancedTest.testPrintData();
		IntNodeAdvancedTest.testRemoveNodeAfterThis();
		IntNodeAdvancedTest.testTestToString();
		System.out.println(IntNode.listEvenNumber(myNode));
		myNode.addRangeAfterThis(0, 100);
		System.out.println(IntNode.listEvenNumber(myNode));
		myNode.getLink().getLink().getLink().getLink()
		    .addRangeAfterThis(100, 200);
		System.out.println(IntNode.listEvenNumber(myNode));
		myNode.addRangeAfterThis(0, 100);
		System.out.println(IntNode.listEvenNumber(myNode));
		myNode.addRangeAfterThis(1000, 1100);
		System.out.println(IntNode.listEvenNumber(myNode));
		myNode.getLink().getLink().addRangeAfterThis(1000, 1100);
		System.out.println(IntNode.listEvenNumber(myNode));
	}

	private static void testSearch() {
		IntNode myNode = new IntNode();
		IntNode bools = new IntNode();
		for (int i = 0; i < 100000; i++) {
			IntNode.search(myNode, i);

		}

		myNode.addNodeAfterThis(22);
		myNode.addNodeAfterThis(22);
		myNode.addNodeAfterThis(1000);
		myNode.addNodeAfterThis(-1000);
		myNode.addNodeAfterThis(-2000);
		myNode.addNodeAfterThis(0);
		for (int i = 0; i < 100000; i++) {
			IntNode.search(myNode, i);

		}
		myNode.addRangeAfterThis(0, 100);
		myNode.getLink().getLink().getLink().getLink()
		    .addRangeAfterThis(100, 200);
		myNode.addRangeAfterThis(0, 100);
		myNode.addRangeAfterThis(1000, 1100);
		myNode.getLink().getLink().addRangeAfterThis(1000, 1100);
		for (int i = 0; i < 100000; i++) {
			if (IntNode.search(myNode, i)) {
				bools.addNodeAfterThis(1);
			} else {
				bools.addNodeAfterThis(0);
			}


		}
		System.out.println("test search results");
		bools.printData();
	}
}