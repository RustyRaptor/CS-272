public class IntNode {

	/**
	 * data: an integer stored
	 * link: the next intnode in the linked list
	 */
	private int data;
	private IntNode link;


	/**
	 * default constructor
	 */
	public IntNode() {
		this.data = 0;
		this.link = null;
	}

	/**
	 * @param _data The new data value to assign
	 * @param _node The next IntNode in the list
	 */
	public IntNode(int _data, IntNode _node) {
		this.data = _data;
		this.link = _node;
	}


	/**
	 * removes an X number of nodes starting from the node it's called
	 * from
	 *
	 * @param count the number of nodes you want to remove
	 */
	public void removeXNodesAfterThis(int count) {
		this.removeNodeAfterThis();
		if (count < 0 || this.getLink() == null) {
			return;
		}
		this.removeXNodesAfterThis(--count);

	}


	/**
	 * add a range of ints to a List
	 *
	 * @param start the start of the range
	 * @param end   the end of the range
	 */
	public void addRangeAfterThis(int start, int end) {
		for (int i = end; i > start; i--) {
			this.addNodeAfterThis(i);
		}

	}

	/**
	 * Adds a range of numbers to end the of the linked list.
	 *
	 * @param start the start of the range
	 * @param end   the end of the range
	 */
	public void addRangeToEnd(int start, int end) {
		for (int i = start; i <= end; i++) {
			this.addToEnd(i);
		}
	}


	// Getters and setters
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public IntNode getLink() {
		return link;
	}

	public void setLink(IntNode link) {
		this.link = link;
	}


	/**
	 * adds a new IntNode after the node it's called from
	 *
	 * @param newData the data you want to add (int)
	 */
	public void addNodeAfterThis(int newData) {
		setLink(new IntNode(newData, this.link));
	}


	/**
	 * removes the IntNode after the one it's called from
	 */
	public void removeNodeAfterThis() {
		if (getLink() == null) {
			System.out.println("The list is empty, Nothing to " +
			    "remove");
		} else {
			setLink(getLink().getLink());
		}
	}


	/**
	 * gets the number of nodes after the one it's called from.
	 *
	 * @param head the head node you want to start from
	 * @return the number of items in the List
	 */
	public static int listLength(IntNode head) {
		if (head == null) {
			return 0;
		}
		int cnt = 1;
		for (IntNode cursor = head.getLink(); cursor != null; cursor
		    = cursor.getLink()) {
			cnt++;
		}
		return cnt;

	}

	/**
	 * returns number of even numbers in the list starting from "head" node
	 *
	 * @param head the node to start from.\
	 * @return integer
	 */
	public static int listEvenNumber(IntNode head) {
		if (head == null) {
			return 0;
		}
		int cnt = 1;
		for (IntNode cursor = head.getLink(); cursor != null; cursor
		    = cursor.getLink()) {
			if (cursor.data % 2 == 0) {
				cnt++;
			}
		}
		return cnt;

	}

	/**
	 * adds a new integer to the end of the linked list.
	 *
	 * @param newData the new integer to be added.
	 */
	public void addToEnd(int newData) {
		IntNode cursor;
		for (cursor = this; cursor.getLink() != null; cursor
		    = cursor.getLink()){
			continue;
		}
		cursor.addNodeAfterThis(newData);
	}

	public static int sumLast(IntNode head, int num) {
		int sum = 0;
		int numLast = IntNode.listLength(head) - num;
		int cnt = 0;
		for (IntNode cursor = head; cursor != null; cursor =
		    cursor.getLink()) {
			if (cnt >= numLast) {
				sum += cursor.getData();
			}
			cnt++;
		}
		return sum;
	}

	/**
	 * searches for a data input and returns whether or not it exists in
	 * the List
	 *
	 * @param head  the head node to start from in the search loop
	 * @param _data the data you want to search for
	 * @return true or false depending on what it finds
	 */
	public static boolean search(IntNode head, int _data) {
		if (head == null) {
			return false;
		}
		for (IntNode cursor = head.getLink(); cursor != null; cursor
		    = cursor.getLink()) {
			if (cursor.data == _data) {
				return true;
			}
		}
		return false;
	}

	/**
	 * returns a new Linked list with all the odd numbers from source
	 * @param source the source node to copy from.
	 * @return new IntNode with odd nums from source IntNode
	 */
	public static IntNode copyOdd (IntNode source) {
		IntNode copyHead;
		IntNode copyTail;

		if (source == null) return null;

		copyHead = new IntNode(source.getData(), null);
		copyTail = copyHead;

		while (source.getLink() != null) {
			source = source.getLink();
			if (source.getData() % 2 != 0) {
				copyTail.addNodeAfterThis(source.getData());
				copyTail = copyTail.getLink();
			}
		}
		return copyHead;
	}

	public static IntNode removeAll(IntNode head, int e) {
		if(head == null) return null;
		IntNode newHead = head;
		while (newHead.getData() != e) {
			newHead = newHead.getLink();
		}

		for (IntNode cursor = newHead; cursor.getLink() != null; cursor
		    = cursor.getLink()){
			if (cursor.getLink().getData() == e){
				cursor.removeNodeAfterThis();
			}
		}
		return newHead;
	}

	/**
	 * Builds a string from all the nodes in the list.
	 *
	 * @return a string of the data separated by arrows.
	 */
	@Override
	public String toString() {
		StringBuilder linkStr = new StringBuilder();
		IntNode answer = null;
		linkStr.append(this.getData());
		if (getLink() != null) {
			linkStr.append("->");
		}
		for (IntNode cursor = getLink(); cursor != null; cursor =
		    cursor.getLink()) {
			linkStr.append(cursor.getData());
			if (cursor.getLink() != null) {
				linkStr.append("->");
			}
		}

		return "IntNode{" +
		    "data=" + linkStr +
		    '}';
	}

	/**
	 * prints out the toString value of the Node.
	 */
	public void printData() {
		System.out.println(this.toString());
	}


}
