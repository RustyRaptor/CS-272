import java.util.Arrays;
import java.util.EmptyStackException;

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
		ensureCapacity();
		data[rear] = (E) o;
		rear++;
		size++;
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		size--;
		if (!isEmpty()) {
			return data[front++];
		}
		return data[0];

	}



	public void ensureCapacity() {
		if (front > 0 && rear >= data.length-1) {
			rear = 0;
		}
		if (rear < 0) {
			rear = data.length - 1;
		}
		if (front == 0 && rear >= data.length - 1) {
			E[] bigarr = (E[]) new Object[data.length*2];
			System.arraycopy(getData(), 0, bigarr, 0, data.length);
			data = bigarr;
		}
		if (rear == front && size >= data.length) {
			E[] bigarr = (E[]) new Object[data.length*2];
			System.arraycopy(data, front, bigarr, 0,
			    data.length - front);
			System.arraycopy(data, 0, bigarr,
			    data.length - front,
			    data.length - (data.length - front));
			data = bigarr;
		}
	}

	@Override
	public E front() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return data[front];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		E[] newarr = (E[]) new Object[data.length];
		System.arraycopy(data, 0, newarr, 0, size);
		return "ArrayQueue{" +
		    "data=" + Arrays.toString(newarr) +
		    ", front=" + front +
		    ", rear=" + rear +
		    ", size=" + size +
		    '}';
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	public E[] getData() {
		return data;
	}

	public void setData(E[] data) {
		this.data = data;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getRear() {
		return rear;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}