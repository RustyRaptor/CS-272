import java.util.EmptyStackException;

public class LinkStack<E> implements StackInterface {
	private SNode<E> top;

	public SNode<E> getTop() {
		return top;
	}

	public void setTop(SNode<E> top) {
		this.top = top;
	}

	public LinkStack(){
		setTop(new SNode<E>(null, null));
	}

	@Override
	public boolean push(Object o) {
		 getTop().addNodeAfterThis((E)o);
		 return true;
	}

	@Override
	public E pop() {
		if (getTop().getLink() != null) {
			SNode<E> popped =
			    new SNode<E>(this.getTop().getLink().getData(),
			    null);
			setTop(getTop().getLink());
			return popped.getData();
		}
		return null;
	}

	@Override
	public E top() {
		if (getTop().getLink() != null) {
			return getTop().getLink().getData();
		}
		return null;
	}

	@Override
	public int size() {
		int count = 0;
		SNode<E> cursor = getTop().getLink();
		for (cursor = cursor; cursor != null; cursor = cursor.getLink()){
			count++;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return size() <= 0;
	}

	public String toString(){
		if (getTop().getLink() != null) {
			return this.getTop().toString();
		}
		return "EMPTY LIST STACK";
	}
}
