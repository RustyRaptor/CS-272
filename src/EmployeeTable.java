import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class EmployeeTable {
	private Employee[] data;
	private Integer[] keys;
	private boolean[] used;

	@Override
	public String toString() {
		return "EmployeeTable{" +
		    "data=" + Arrays.toString(data) +
		    ", keys=" + Arrays.toString(keys) +
		    ", used=" + Arrays.toString(used) +
		    '}';
	}

	/**
	 * default constructor
	 */
	private EmployeeTable() {
		this.data = new Employee[701];
		this.keys = new Integer[701];
		this.used = new boolean[701];
	}


	/**
	 * @param key they key of the new item
	 * @param obj the new items value
	 */
	public void put(Integer key, Employee obj) {

		for (int i = hashCode(key); i < keys.length; i++) {
			if (!used[i]) {
				keys[i] = key;
				data[i] = obj;
				used[i] = true;
				return;
			}

		}
		throw new OutOfMemoryError();
	}


	/**
	 * removes a key from the hashtable
	 *
	 * @param key the key of the item to remove.
	 * @return returns false if it didn't remove anything true if it did.
	 */
	public boolean remove(Integer key) {
		for (int i = hashCode(key); i < keys.length; i++) {
			if (keys[i] != null && keys[i].equals(key)) {
				used[i] = false;
				return true;
			}

		}
		return false;
	}


	/**
	 * find an employee by number.
	 *
	 * @param emp_no the number of the employee to find.
	 * @return the index of the employee.
	 */
	public int search(int emp_no) {
		for (int i = hashCode(emp_no); i < keys.length; i++) {
			if (keys[i] != null && !used[i] && keys[i] == emp_no) {
				return i;
			}
		}
		return -1;
	}


	/**
	 * generates a hashcode based on employee number.
	 *
	 * @param key the employee number
	 * @return the new key value.
	 */
	private int hashCode(Integer key) {
		return Math.abs(key.hashCode()) % keys.length;
	}


	// getters and setters
	public Employee[] getData() {
		return data;
	}

	public void setData(Employee[] data) {
		this.data = data;
	}

	public Integer[] getKeys() {
		return keys;
	}

	public void setKeys(Integer[] keys) {
		this.keys = keys;
	}

	public boolean[] getUsed() {
		return used;
	}

	public void setUsed(boolean[] used) {
		this.used = used;
	}


	private static void HashMapRead() throws IOException {
		String line;
		String[] items;
		HashMap<Integer, Employee> workers = new HashMap<>();
		BufferedReader reader =
		    new BufferedReader(new FileReader("core_dataset.csv"));
		reader.readLine();
		while ((line = reader.readLine()) != null) {
			items = line.split(",");
			if (items.length <= 0) {
				break;
			}
			workers.put(Integer.parseInt(items[2]),
			    new Employee(items[0].concat(items[1]),
				Integer.parseInt(items[2]),
				Integer.parseInt(items[6]), items[3],
				Integer.parseInt(items[4].strip()),
				null));
		}
		System.out.println(workers.size());
		System.out.println(workers.remove(1112030816));
		System.out.println(workers.size());
		System.out.println(workers.remove(1111030148));
		System.out.println(workers.size());
		System.out.println(workers.remove(602000312));
		System.out.println(workers.size());
		System.out.println(workers.containsKey(1501072093));
		System.out.println(workers.size());
		System.out.println(workers.containsKey(1111030148));
		System.out.println(workers.size());
	}

	public static void main(String[] args) throws IOException {
		EmployeeTable test = new EmployeeTable();
		test.remove(1);
		test.remove(-1);
		test.search(-1);
		test.search(1);
		test.put(-1, new Employee("John", 999, 19, "NM", 88310,
		    new int[]{3, 2, 1}));
		test.put(1106026572, new Employee("John", 999, 19, "NM", 88310,
		    new int[]{3, 2, 1}));
		test.put(1106026571, new Employee("John2", 998, 19, "NM2",
		    88310,
		    new int[]{3, 2, 1}));
		for (int i = 0; i < 100; i++) {
			test.put(1106026000 + i, new Employee("John2" + i,
			    998, 19,
			    "NM2",
			    88310,
			    new int[]{3, 2, 1}));
		}
		System.out.println(test);
		test.remove(1106026571);
		System.out.println(test.search(1106026571));
		test.search(1106026571);
		test.search(1106026572);
		System.out.println(test);
		HashMapRead();


	}
}