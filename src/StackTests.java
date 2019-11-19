public class StackTests {
	public static void main(String[] args) {
		System.out.println("=====TESTING LinkedList STACK=====");
		announceTest("LIST PUSH");
		testListPush();
		announceTest("LIST POP");
		testListPop();
		announceTest("LIST TOP");
		testListTop();
		announceTest("LIST isEmpty");
		testListIsEmpty();
		System.out.println("=====LinkedList STACK TESTS " +
		    "COMPLETE!!!=====");
		System.out.println("=====TESTING ArrayList STACK=====");
		announceTest("ARR PUSH");
		testArrPush();
		announceTest("ARR POP");
		testArrPop();
		announceTest("ARR TOP");
		testArrTop();
		announceTest("ARR isEmpty");
		testArrIsEmpty();
		announceTest("ARR SIZE");
		testArrSize();
		System.out.println("=====ARRAYLIST STACK TESTS " +
		    "COMPLETE!!!=====");

	}
	private static void announceTest(String name) {
		for (int i = 0; i < 50; i++) {
			System.out.print("=");
		}
		System.out.print("END OF TEST");
		System.out.println();
		System.out.println("TESTING " + name);

		System.out.println();
	}
	private static void testListPush(){
		LinkStack<Integer> test = new LinkStack<>();
		test.push(1);
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.push(i);
		}
		System.out.println(test);
	}

	private static void testListPop(){
		LinkStack<Integer> test = new LinkStack<>();
		test.pop();
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.push(i);
		}
		test.pop();
		test.pop();
		for (int i = 0; i < 10; i++) {
			test.pop();
		}
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.push(i);
		}
		System.out.println(test);
		System.out.println(test.pop());
	}
	private static void testListTop(){
		LinkStack<Integer> test = new LinkStack<>();
		test.top();
		System.out.println(test.top());
		test.push(0);
		System.out.println(test.top());
		for (int i = 0; i < 10; i++) {
			test.push(i);
		}
		System.out.println(test.top());

	}
	private static void testListIsEmpty(){
		LinkStack<Integer> test = new LinkStack<>();
		System.out.println(test.isEmpty());
		System.out.println(test.isEmpty());
		test.push(1);
		System.out.println(test.isEmpty());
		test.pop();
		System.out.println(test.isEmpty());
	}
	private static void testArrPush(){
		ArraylistStack<Integer> test = new ArraylistStack<>();
		test.push(1);
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.push(i);
		}
		System.out.println(test);
	}

	private static void testArrPop(){
		ArraylistStack<Integer> test = new ArraylistStack<>();
		test.pop();
		test.isEmpty();
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.push(i);
		}
		test.pop();
		test.pop();
		for (int i = 0; i < 10; i++) {
			test.pop();
		}
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.push(i);
		}
		System.out.println(test);
		System.out.println(test.pop());
	}
	private static void testArrTop(){
		ArraylistStack<Integer> test = new ArraylistStack<>();
		test.top();
		System.out.println(test.top());
		test.push(0);
		System.out.println(test.top());
		for (int i = 0; i < 10; i++) {
			test.push(i);
		}
		System.out.println(test.top());

	}
	private static void testArrIsEmpty(){
		ArraylistStack<Integer> test = new ArraylistStack<>();
		System.out.println(test.isEmpty());
		System.out.println(test.isEmpty());
		test.push(1);
		System.out.println(test.isEmpty());
		test.pop();
		System.out.println(test.isEmpty());
	}
	private static void testArrSize(){
		ArraylistStack<Integer> test = new ArraylistStack<>();
		test.size();
		test.push(0);
		test.size();
		test.push(0);
		test.size();
		test.pop();
		test.size();
		test.pop();
		test.size();
	}
}
