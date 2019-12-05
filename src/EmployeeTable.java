import java.awt.desktop.SystemEventListener;
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
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_BLACK = "\u001B[30m";
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_YELLOW = "\u001B[33m";
		final String ANSI_BLUE = "\u001B[34m";
		final String ANSI_PURPLE = "\u001B[35m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_WHITE = "\u001B[37m";
		StringBuilder thetable = new StringBuilder();
		thetable.append("EmployeeTable{ \n data=");
		for(Employee i : data){
			if (i != null) {
				thetable.append(ANSI_GREEN).append(", ").append(i);
			} else {
				thetable.append(ANSI_RESET).append(", null");
			}
		}
		thetable.append("\n\n keys=");
		for(Integer i : keys){
			if (i != null) {
				thetable.append(ANSI_GREEN).append(", ").append(i);
			} else {
				thetable.append(ANSI_RESET).append(", null");
			}
		}
		thetable.append("\n\n\n\n used=");
		for(boolean i : used){
			if (i) {
				thetable.append(ANSI_BLUE).append(", true");
			} else {
				thetable.append(ANSI_RED).append(", false");
			}
		}
		thetable.append(ANSI_RESET);
		return thetable.toString();
	}

	/**
	 * default constructor
	 */
	private EmployeeTable() {
		this.data = new Employee[400];
		this.keys = new Integer[400];
		this.used = new boolean[400];
	}

	/**
	 * checks for the index of a key
	 *
	 * @param key the key to find the index of.
	 * @return the index of the key or -1 if not found.
	 */
	public int findIndex(Integer key) {
		int idx = hashCode(key);
		int counter = hashCode(key);
		while (counter < data.length && used[idx]) {
			if (key.equals(keys[idx])) {
				return idx;
			} else {
				idx++;
				counter++;
			}
		}
		return -1;
	}

	/**
	 * @param key they key of the new item
	 * @param obj the new items value
	 */
	public void put(Integer key, Employee obj) {
		if (findIndex(key) == -1) {
			for (int i = hashCode(key); i < keys.length; i++) {
				if (!used[i]) {
					keys[i] = key;
					data[i] = obj;
					used[i] = true;
					return;
				}

			}
		} else {
			keys[findIndex(key)] = key;
			data[findIndex(key)] = obj;
			used[findIndex(key)] = true;
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
		if (findIndex(key) != -1) {
			for (int i = hashCode(key); i < keys.length; i++) {
				if (keys[i] != null && keys[i].equals(key)) {
					used[i] = false;
					return true;
				}

			}
			return false;
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
//		for (int i = hashCode(emp_no); i < keys.length; i++) {
//			if (keys[i] != null && !used[i] && keys[i] == emp_no) {
//				return i;
//			}
//		}
//		return -1;
		return findIndex(emp_no);
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

	/**
	 * runs the code to import the employees and add them to a hashmap
	 *
	 * @throws IOException if the file isn't there.
	 */
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
		System.out.println("|||FINAL LAB!!!!!|||");
		System.out.println("|||Testing Our HashTable|||");
		EmployeeTable test = new EmployeeTable();
		System.out.println("|||Testing nulls and negatives|||");
		System.out.println(test.remove(1));
		System.out.println(test.remove(-1));
		System.out.println(test.search(-1));
		System.out.println(test.search(1));
		System.out.println("|||Adding some dudes|||");
		test.put(999, new Employee("John", 999, 19, "NM", 88310,
		    new int[]{3, 2, 1}));
		test.put(1106026572, new Employee("John", 999, 19, "NM", 88310,
		    new int[]{3, 2, 1}));
		test.put(1106026571, new Employee("John2", 998, 19, "NM2",
		    88310,
		    new int[]{3, 2, 1}));
		System.out.println(test.search(999));
		System.out.println(test.remove(999));
		System.out.println(test.search(999));
		System.out.println("||||Printing the full hash table... (This" +
		    " " +
		    "won't be pretty)||||");
		System.out.println(test);
		System.out.println("|||DONE|||");
		System.out.println("|||_______________________|||");
		System.out.println("|||TESTING BUILT IN HASHMAP|||");
		HashMapRead();
		System.out.println("|||DONE|||");
	}
}