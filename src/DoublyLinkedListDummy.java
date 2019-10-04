public class DoublyLinkedListDummy {
	private DIntNode head;
	private DIntNode tail;


	public DoublyLinkedListDummy() {
		head = new DIntNode();
		tail = new DIntNode();
		head.setNext(tail);
		tail.setPrev(head);
	}

	/**
	 * Adds a Node to the end of the list. (after the tail)
	 *
	 * @param element The data to add.
	 *                <p>
	 *                Time Complexity: O(1)
	 */
	public void addEnd(int element) {
		DIntNode newNode = new DIntNode(element, null, null);
		newNode.setPrev(this.getTail());
		newNode.setNext(null);
		this.getTail().setNext(newNode);
		this.setTail(newNode);
	}

	/**
	 * Removes the first node in this list. (The head)
	 * Time Complexity: 0(1)
	 */
	public void removeFromHead() {
		if (head.getNext() == null) {
			return;
		}
		if (tail.getPrev() == null) {
			return;
		}
		this.setHead(this.getHead().getNext());
		this.getHead().setPrev(null);
	}


	@Override
	public String toString() {
		StringBuilder forward = new StringBuilder("");
		StringBuilder backward = new StringBuilder("");
		for (DIntNode cursor = this.getHead(); cursor != null; cursor
		    = cursor.getNext()) {
			forward.append(cursor.getData());
			forward.append("<->");
		}
		for (DIntNode cursor = this.getTail(); cursor != null; cursor
		    = cursor.getPrev()) {
			backward.append(cursor.getData());
			backward.append("<->");
		}
		return "DoublyLinkedListDummy: " +
		    "(forward)" + forward.toString() +
		    ",(backward)" + backward.toString();
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
	 * Time Complexity: O(n)
	 */
	public int countOccurrence(int e) {
		int count = 0;
		DIntNode cursor = this.head;
		while (cursor != null) {
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
	 * Time Complexity: O(n) where n is the size of the array we are
	 * searching in.
	 */
	public boolean removeAll(int e) {
		DIntNode cursor = this.head;
		boolean result = false;
		while (cursor.getNext() != null) {
			if (cursor.getData() == e) {
				cursor.getPrev().setNext(cursor.getNext());
				cursor.getNext().setPrev(cursor.getPrev());
				result = true;
			}
			cursor = cursor.getNext();
		}
		return result;
	}

	/**
	 * returns a sublist of the current list
	 *
	 * @param beginIdx The starting index of the sublist
	 * @param endIdx   The ending index of the sublist
	 * @return a new List being a sublist of this list.
	 * <p>
	 * Time Complexity: O(n) where n is the number of elements from the
	 * start of the host list to endIdx
	 */
	public DoublyLinkedListDummy subList(int beginIdx, int endIdx) {
		DoublyLinkedListDummy newList = new DoublyLinkedListDummy();
		DIntNode cursor = this.head;
		for (int i = 0; i <= endIdx; i++) {
			if (i == beginIdx) {
				newList.setHead(cursor);
			} else if (i > beginIdx) {
				newList.addEnd(cursor.getData());
			}
			cursor = cursor.getNext();
		}
		return newList;
	}

	public int listLength() {
		if (this.head == null || this.head.getNext() == this.tail) {
			return 2;
		}
		int cnt = 2;
		for (DIntNode cursor = this.head; cursor != null; cursor
		    = cursor.getNext()) {
			cnt++;
		}
		return cnt;
	}


	public void printStatistics() {
		int size = this.listLength();
		DoublyLinkedListDummy nums = new DoublyLinkedListDummy();

		for (DIntNode cursor = this.head; cursor != null; cursor
		    = cursor.getNext()) {
			if (nums.countOccurrence(cursor.getData())<1) {
				nums.addEnd(cursor.getData());
			}
		}
		System.out.println("number occurrence");
		for (DIntNode cursor = nums.getTail(); cursor.getPrev() != null; cursor
		    = cursor.getPrev()) {
			System.out.println( cursor.getData() + " " + this.countOccurrence(cursor.getData()));
		}
	}

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
}
