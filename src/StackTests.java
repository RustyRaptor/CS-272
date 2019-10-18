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
	static void announceTest(String name) {
		for (int i = 0; i < 50; i++) {
			System.out.print("=");
		}
		System.out.print("END OF TEST");
		System.out.println();
		System.out.println("TESTING " + name);

		System.out.println();
	}
	static void testListPush(){
		LinkStack<Integer> test = new LinkStack<Integer>();
		test.push(1);
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.push(i);
		}
		System.out.println(test);
	}

	static void testListPop(){
		LinkStack<Integer> test = new LinkStack<Integer>();
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
	static void testListTop(){
		LinkStack<Integer> test = new LinkStack<Integer>();
		test.top();
		System.out.println(test.top());
		test.push(0);
		System.out.println(test.top());
		for (int i = 0; i < 10; i++) {
			test.push(i);
		}
		System.out.println(test.top());

	}
	static void testListIsEmpty(){
		LinkStack<Integer> test = new LinkStack<Integer>();
		System.out.println(test.isEmpty());
		System.out.println(test.isEmpty());
		test.push(1);
		System.out.println(test.isEmpty());
		test.pop();
		System.out.println(test.isEmpty());
	}
	static void testArrPush(){
		ArraylistStack<Integer> test = new ArraylistStack<Integer>();
		test.push(1);
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.push(i);
		}
		System.out.println(test);
	}

	static void testArrPop(){
		ArraylistStack<Integer> test = new ArraylistStack<Integer>();
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
	static void testArrTop(){
		ArraylistStack<Integer> test = new ArraylistStack<Integer>();
		test.top();
		System.out.println(test.top());
		test.push(0);
		System.out.println(test.top());
		for (int i = 0; i < 10; i++) {
			test.push(i);
		}
		System.out.println(test.top());

	}
	static void testArrIsEmpty(){
		ArraylistStack<Integer> test = new ArraylistStack<Integer>();
		System.out.println(test.isEmpty());
		System.out.println(test.isEmpty());
		test.push(1);
		System.out.println(test.isEmpty());
		test.pop();
		System.out.println(test.isEmpty());
	}
	static void testArrSize(){
		ArraylistStack<Integer> test = new ArraylistStack<Integer>();
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
