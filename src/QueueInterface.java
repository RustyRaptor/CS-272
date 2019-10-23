public interface QueueInterface <E> {
	void enqueue(E e);
	E dequeue();
	E front();
	int size();
	boolean isEmpty();
}
