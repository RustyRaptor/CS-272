import java.util.EmptyStackException;

public class LinkedQueue <E> implements QueueInterface {
	private SNode<E> front;
	private SNode<E> rear;
	private int size;

	public LinkedQueue() {
		this.front = new SNode<E>((E) new Object(), null);
		this.rear = front;
		this.size = 0;
	}

	@Override
	public void enqueue(Object o) {
		rear.setLink(new SNode<E>((E) o, null));
		rear = rear.getLink();
		size++;
	}

	@Override
	public E dequeue() {
		if (size <= 0) {
			throw new EmptyStackException();
		}
		if (size == 1){
			E tempdata = front();
			this.front = new SNode<E>((E) new Object(), null);
			this.rear = front;
			this.size = 0;
			return tempdata;
		}
		E tempdata = front();
		front.setLink(front.getLink().getLink());
		size--;
		return tempdata;
	}


	@Override
	public E front() {
		if (size <= 0) {
			throw new EmptyStackException();
		}
		return front.getLink().getData();
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

	@Override
	public String toString() {
		return "LinkedQueue{" +
		    "front=" + front +
		    ", rear=" + rear +
		    ", size=" + size +
		    '}';
	}

	public void setRear(SNode<E> rear) {
		this.rear = rear;
	}
}
