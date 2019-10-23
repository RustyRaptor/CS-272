public class ArrayQueue <E> implements QueueInterface {
	private E[] data;
	private int front, rear;
	private int size;


	public ArrayQueue() {
		this.data = (E[]) new Object[10];
		this.front = 0;
		this.rear = 0;
		this.size = 0;
	}

	@Override
	public void enqueue(Object o) {
		data[rear] = (E) o;
		rear++;
		size++;
	}

	@Override
	public E dequeue() {
		size--;
		return data[front++];
	}

	@Override
	public E front() {
		return data[front];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
}