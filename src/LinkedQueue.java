public class LinkedQueue <E> implements QueueInterface {
	private SNode<E> front;
	private SNode<E> rear;
	private int size;

	public LinkedQueue() {
		this.front = new SNode<E>();
		this.rear = new SNode<E>();
		this.size = 0;
	}

	@Override
	public void enqueue(Object o) {
		getRear().setLink(new SNode<E>((E)o, null));
	}

	@Override
	public E dequeue() {
		E tempdata = front();
		setFront(getFront().getLink());
		return tempdata;
	}


	@Override
	public E front() {
		return front.getData();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	public SNode<E> getFront() {
		return front;
	}

	public void setFront(SNode<E> front) {
		this.front = front;
	}

	public SNode<E> getRear() {
		return rear;
	}

	public void setRear(SNode<E> rear) {
		this.rear = rear;
	}
}
