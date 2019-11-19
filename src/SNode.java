public class SNode<E> {

	/**
	 * data: an integer stored
	 * link: the next intnode in the linked list
	 */
	private E data;
	private SNode<E> link;


	/**
	 * default constructor
	 */
	public SNode() {
		this.data = null;
		this.link = null;
	}

	SNode(E _data, SNode<E> _link) {
		this.data = _data;
		this.link = _link;
	}


	// Getters and setters
	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data =  data;
	}

	public SNode<E> getLink() {
		return link;
	}

	public void setLink(SNode<E> link) {
		this.link = link;
	}


	/**
	 * adds a new SNode after the node it's called from
	 *
	 * @param newData the data you want to add (int)
	 */
	void addNodeAfterThis(E newData) {
		setLink(new SNode<>(newData, this.link));
	}


	/**
	 * removes the SNode after the one it's called from
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
	 * @return the number of items in the List
	 */
	public int listLength() {
		if (this.data == null) {
			return 0;
		}
		int cnt = 1;
		for (SNode<E> cursor = this.getLink(); cursor != null; cursor
		    = cursor.getLink()) {
			cnt++;
		}
		return cnt-1;
	}


	/**
	 * adds a new integer to the end of the linked list.
	 *
	 * @param newData the new integer to be added.
	 */
	public void addToEnd(E newData) {
		SNode cursor = this;
		while(cursor.getLink() != null){ cursor = cursor.getLink(); }
		cursor.addNodeAfterThis(newData);
	}


	/**
	 * Builds a string from all the nodes in the list.
	 *
	 * @return a string of the data separated by arrows.
	 */
	@Override
	public String toString() {
		StringBuilder linkStr = new StringBuilder();
		SNode answer = null;
		for (SNode<? extends E> cursor = getLink(); cursor != null; cursor =
		    cursor.getLink()) {
			linkStr.append(cursor.getData());
			if (cursor.getLink() != null) {
				linkStr.append("->");
			}
		}

		return "SNode{" +
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
