/**
 * A set of functions to test all the features of IntNode
 * also includes a testAll(); function just to run them some more because why
 * not.
 */

public class IntNodeTest {
	/**
	 * This main function just runs all the test functions.
	 */
	public static void main(String[] args) {
		IntNodeTest.testAddNodeAfterThis();
		IntNodeTest.testAddRangeAfterThis();
		IntNodeTest.testPrintData();
		IntNodeTest.testRemoveNodeAfterThis();
		IntNodeTest.testTestToString();
		IntNodeTest.testSearch();
		IntNodeTest.testAll();
	}


	private static void testAddRangeAfterThis() {
		IntNode myNode = new IntNode();
		myNode.addRangeAfterThis(0, 100);
		myNode.getLink().getLink().getLink().getLink()
		    .addRangeAfterThis(100,200);
		myNode.addRangeAfterThis(0, 100);
		myNode.addRangeAfterThis(1000, 1100);
		myNode.getLink().getLink().addRangeAfterThis(1000, 1100);

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
		IntNodeTest.testSearch();
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
		IntNodeTest.testAddNodeAfterThis();
		IntNodeTest.testAddRangeAfterThis();
		System.out.println("Testing toString()");
		System.out.println(myNode.toString());
		IntNodeTest.testPrintData();
		IntNodeTest.testRemoveNodeAfterThis();
		IntNodeTest.testTestToString();
	}

	private static void testSearch() {
		IntNode myNode = new IntNode();
		IntNode bools = new IntNode();
		for (int i = 0; i < 100000; i++){
			IntNode.search(myNode, i);

		}

		myNode.addNodeAfterThis(22);
		myNode.addNodeAfterThis(22);
		myNode.addNodeAfterThis(1000);
		myNode.addNodeAfterThis(-1000);
		myNode.addNodeAfterThis(-2000);
		myNode.addNodeAfterThis(0);
		for (int i = 0; i < 100000; i++){
			IntNode.search(myNode, i);

		}
		myNode.addRangeAfterThis(0, 100);
		myNode.getLink().getLink().getLink().getLink()
		    .addRangeAfterThis(100,200);
		myNode.addRangeAfterThis(0, 100);
		myNode.addRangeAfterThis(1000, 1100);
		myNode.getLink().getLink().addRangeAfterThis(1000, 1100);
		for (int i = 0; i < 100000; i++){
			if (IntNode.search(myNode, i)) {
				bools.addNodeAfterThis(1);
			} else{
				bools.addNodeAfterThis(0);
			}


		}
		System.out.println("test search results");
		bools.printData();
	}
}