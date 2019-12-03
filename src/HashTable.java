public interface HashTable {
	Object get(Object key);

	void put(Object key, Object obj);

	boolean remove(Object key);

	int findIndex(Object key);

	int hashCode(Object key);
}
