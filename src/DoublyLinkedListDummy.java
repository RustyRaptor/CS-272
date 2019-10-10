public class DoublyLinkedListDummy {
	private DIntNode head;
	private DIntNode tail;

	/**
	 * this is used to keep track of the status of the list's emptiness.
	 */
	private boolean empty;

	/**
	 * No-arg constructor
	 * sets the head's next to tail and the tail's prev to head
	 * Initializes empty as true.
	 */
	public DoublyLinkedListDummy() {
		this.head = new DIntNode();
		this.tail = new DIntNode();
		this.head.setNext(tail);
		this.tail.setPrev(head);
		this.empty = true;
	}

	/**
	 * Adds a Node to the end of the list. (after the tail)
	 *
	 * @param element The data to add.
	 *                <p>
	 *                Time Complexity(worst): O(1)
	 */
	public void addEnd(int element) {
		// new node with element and the previous is the last item
		// the next is the tail
		DIntNode newNode = new DIntNode(element, getTail().getPrev(),
		    getTail());

		// set the tail's prev's next to the newNode
		getTail().getPrev().setNext(newNode);

		// set the tail's prev to the newnode
		getTail().setPrev(newNode);

		setNotEmpty();
	}

	/**
	 * Removes the first node in this list. (The head)
	 * Time Complexity(worst): 0(1)
	 */
	public void removeFromHead() {

		// if it's empty return
		if (checkEmpty()) {
			return;
		}

		// set the head's next to it's link's link.
		getHead().setNext(getHead().getNext().getNext());

		// set the head's next's prev to the head.
		getHead().getNext().setPrev(getHead());

		// check if empty now
		checkEmpty();
	}

	/**
	 * to string which accounts for empty lists.
	 *
	 * @return a string of the list.
	 * Time Complexity(worst): O(n) where n is the size of the list we
	 * are converting to a string.
	 */
	@Override
	public String toString() {
		if (checkEmpty()) {
			return "EMPTY LIST";
		}
		StringBuilder forward = new StringBuilder("");
		StringBuilder backward = new StringBuilder("");
		for (DIntNode cursor = getHead().getNext(); cursor != getTail(); cursor
		    = cursor.getNext()) {
			forward.append(cursor.getData());
			if (cursor.getNext() != getTail()) {
				forward.append("<->");
			}
		}


		for (DIntNode cursor = getTail().getPrev(); cursor != getHead(); cursor
		    = cursor.getPrev()) {
			backward.append(cursor.getData());
			if (cursor.getPrev() != getHead()) {
				backward.append("<->");
			}
		}
		return "DoublyLinkedListDummy: " + "{" + "\n" +
		    "(forward) " + forward.toString() + "\n" +
		    "(backward)" + backward.toString() + "\n" + "}";
	}

	/**
	 * Returns the count of a given data
	 *
	 * @param e the data we want to count occurences of.
	 * @return the count of the data
	 * <p>
	 * Note: In this case the input itself is constant. The real input to
	 * base the time complexity on is the size of the list in the object
	 * it's being called from.
	 * <p>
	 * Time Complexity(worst): O(n) where n is the size of the list.
	 */
	public int countOccurrence(int e) {
		if (checkEmpty()) {
			return 0;
		}
		int count = 0;
		DIntNode cursor = getHead().getNext();
		while (cursor != getTail()) {
			if (cursor.getData() == e) {
				count++;
			}
			cursor = cursor.getNext();
		}
		return count;
	}

	/**
	 * Removes all elements that match a given integer from the list.
	 *
	 * @param e an integer to remove from the list.
	 * @return true or false if one was found and removed.
	 * Time Complexity(worst): O(n) where n is the size of the list we are
	 * searching in.
	 */
	public boolean removeAll(int e) {
		if (checkEmpty()) {
			return false;
		}
		DIntNode cursor = getHead().getNext();
		boolean result = false;
		while (cursor.getNext() != getTail()) {
			if (cursor.getData() == e) {
				cursor.getPrev().setNext(cursor.getNext());
				cursor.getNext().setPrev(cursor.getPrev());
				result = true;
			}
			cursor = cursor.getNext();
		}
		checkEmpty();
		return result;

	}

	/**
	 * returns a sublist of the current list
	 *
	 * @param beginIdx The starting index of the sublist
	 * @param endIdx   The ending index of the sublist
	 * @return a new List being a sublist of this list
	 * Time Complexity(worst): O(n) where n is the number of elements in
	 * the list.
	 * start of the host list to endIdx
	 */
	public DoublyLinkedListDummy subList(int beginIdx, int endIdx) {
		if (checkEmpty()) {
			return this;
		}
		if (beginIdx <= 0 && endIdx >= listLength()) {
			return this;
		}
		if (beginIdx < 0) {
			beginIdx = 0;
		}
		DoublyLinkedListDummy newList = new DoublyLinkedListDummy();
		DIntNode cursor = getHead().getNext();
		for (int i = 0; i < endIdx && cursor != getTail(); i++) {
			if (i >= beginIdx) {
				newList.addEnd(cursor.getData());
			}
			cursor = cursor.getNext();
		}
		return newList;
	}

	/**
	 * Gets the size of the list
	 *
	 * @return integer of the size
	 * Time Complexity(worst): O(n) where n is the size of the list we
	 * are checking the size of.
	 */
	public int listLength() {
		if (checkEmpty()) {
			return 0;
		}
		int cnt = 2;
		for (DIntNode cursor = getHead().getNext(); cursor != getTail(); cursor
		    = cursor.getNext()) {
			cnt++;
		}
		return cnt;
	}


	/**
	 * prints a list of all distinct items in the list and their count
	 * Time Complexity(worst): O(n) where n is the size of the list we
	 * are printing.
	 */
	public void printStatistics() {
		if (checkEmpty()) {
			System.out.println("EMPTY LIST");
			return;
		}
		DoublyLinkedListDummy items =
		    new DoublyLinkedListDummy();
		for (DIntNode cursor = this.getHead().getNext(); cursor != getTail(); cursor
		    = cursor.getNext()) {
			if (items.countOccurrence(cursor.getData()) == 0) {
				items.addEnd(cursor.getData());
			}
		}
		System.out.println("Number | Occurrences");
		for (DIntNode cursor = items.getHead().getNext(); cursor != items.getTail(); cursor
		    = cursor.getNext()) {
			System.out.print(cursor.getData() + "\t \t");
			System.out.print(this.countOccurrence(cursor.getData()) + "\n");

		}
	}

	// getters and setters.
	public DIntNode getHead() {
		return head;
	}

	public void setHead(DIntNode head) {
		this.head = head;
	}

	public DIntNode getTail() {
		return tail;
	}

	public void setTail(DIntNode tail) {
		this.tail = tail;
	}

	/**
	 * set the list to empty
	 */
	public void setEmpty() {
		this.empty = true;
	}

	/**
	 * set the list to NOT empty
	 */
	public void setNotEmpty() {
		this.empty = false;
	}

	/**
	 * this checks if the list is empty and sets the status accordingly.
	 *
	 * @return a boolean. True if it's empty False if it's not empty.
	 */
	public boolean checkEmpty() {
		if (getHead().getNext() == getTail() && getTail().getPrev() == getHead()) {
			setEmpty();
			return true;
		}
		setNotEmpty();
		return false;
	}
}
