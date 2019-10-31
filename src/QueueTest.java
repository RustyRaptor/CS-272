public class QueueTest {
	public static void main(String[] args) {
		System.out.println("=====TESTING LinkedList Queue=====");
		announceTest("LIST Enqueue");
		testListEnqueue();
		announceTest("LIST Dequeue");
		testListDequeue();
		announceTest("LIST Front");
		testListFront();
		announceTest("LIST isEmpty");
		testListIsEmpty();
		System.out.println("=====LinkedList Queue TESTS " +
		    "COMPLETE!!!=====");
		System.out.println("=====TESTING Array Queue=====");
		announceTest("ARR Enqueue");
		testArrEnqueue();
		announceTest("ARR Dequeue");
		testArrDequeue();
		announceTest("ARR TOP");
		testArrFront();
		announceTest("ARR isEmpty");
		testArrIsEmpty();
		announceTest("ARR SIZE");
		testArrSize();
		System.out.println("=====Array Queue TESTS " +
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
	static void testListEnqueue(){
		LinkedQueue<Integer> test = new LinkedQueue<Integer>();
		test.enqueue(1);
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.enqueue(i);
		}
		System.out.println(test);
		for (int i = 0; i < 100; i++) {
			test.enqueue(i);
		}
		System.out.println(test);
	}

	static void testListDequeue(){
		LinkedQueue<Integer> test = new LinkedQueue<Integer>();
		try {
			test.dequeue();
			System.out.println("WARNING: EXCEPTION BROKEN");
		} catch (Exception e) {
			System.out.println("EMPTY STACK EXCEPTION WORKS!!!");
		}
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.enqueue(i);
		}
		System.out.println(test);
		test.dequeue();
		test.dequeue();
		for (int i = 0; i < 10; i++) {
			try {
				test.dequeue();
			} catch (Exception e) {
				System.out.println("EXCEPTION WORKED");
			}
		}
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.enqueue(i);
		}
		System.out.println(test);
		System.out.println(test.dequeue());
	}
	static void testListFront(){
		LinkedQueue<Integer> test = new LinkedQueue<Integer>();
		try {
			test.front();
			System.out.println(test.front());
		} catch (Exception e) {
			System.out.println("EXCEPTION SUCCESS!!");
		}
		test.enqueue(0);
		System.out.println(test.front());
		for (int i = 0; i < 10; i++) {
			test.enqueue(i);
		}
		System.out.println(test.front());

	}
	static void testListIsEmpty(){
		LinkedQueue<Integer> test = new LinkedQueue<Integer>();
		System.out.println(test.isEmpty());
		System.out.println(test.isEmpty());
		test.enqueue(1);
		System.out.println(test.isEmpty());
		test.dequeue();
		System.out.println(test.isEmpty());
	}
	static void testArrEnqueue(){
		ArrayQueue<Integer> test = new ArrayQueue<Integer>();
		test.enqueue(1);
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.enqueue(i);
		}
		System.out.println(test);
		System.out.println("TESTING CHECK CAPACITY");
		for (int i = 0; i < 10; i++) {
			test.enqueue(i);
		}
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.dequeue();
		}
		System.out.println(test);
		for (int i = 0; i < 100; i++) {
			test.enqueue(i);
		}
		System.out.println(test);
	}

	static void testArrDequeue(){
		ArrayQueue<Integer> test = new ArrayQueue<Integer>();
		try {
			test.dequeue();
		} catch (Exception e) {
			System.out.println("EXCEPTION FOR ARRAY WORKS");
		}
		test.isEmpty();
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.enqueue(i);
		}
		test.dequeue();
		test.dequeue();
		try {
			for (int i = 0; i < 10; i++) {
				test.dequeue();
			}
		} catch (Exception e) {
			System.out.println("EXCEPTION WORKS");
		}
		System.out.println(test);
		for (int i = 0; i < 10; i++) {
			test.enqueue(i);
		}
		System.out.println(test);
		System.out.println(test.dequeue());
	}
	static void testArrFront(){
		ArrayQueue<Integer> test = new ArrayQueue<Integer>();

		try {
			test.front();
			System.out.println(test.front());
		} catch (Exception e) {
			System.out.println("EXCEPTION WORKS");
		}

		test.enqueue(0);
		System.out.println(test.front());
		for (int i = 0; i < 10; i++) {
			test.enqueue(i);
		}
		System.out.println(test.front());

	}
	static void testArrIsEmpty(){
		ArrayQueue<Integer> test = new ArrayQueue<Integer>();
		System.out.println(test.isEmpty());
		System.out.println(test.isEmpty());
		test.enqueue(1);
		System.out.println(test.isEmpty());
		test.dequeue();
		System.out.println(test.isEmpty());
	}
	static void testArrSize(){
		ArrayQueue<Integer> test = new ArrayQueue<Integer>();
		test.size();
		test.enqueue(0);
		test.size();
		test.enqueue(0);
		test.size();
		test.dequeue();
		test.size();
		test.dequeue();
		test.size();
	}
}
