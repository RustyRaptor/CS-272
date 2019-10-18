import java.util.ArrayList;

public class ArraylistStack<E> implements StackInterface {
	private ArrayList<E> data;
	private int cnt;

	public ArraylistStack() {
		data = new ArrayList<E>();
		cnt = -1;
	}

	@Override
	public boolean push(Object o) {
		cnt++;
		return data.add((E) o);
	}


	@Override
	public E pop() {
		if (!isEmpty()) {
			return data.get(cnt--);
		}
		return null;
	}

	@Override
	public E top() {
		if (!isEmpty()) {
			return data.get(cnt);
		}
		return null;
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return cnt <= -1;
	}

	public String toString() {
		return data.toString();
	}
}
