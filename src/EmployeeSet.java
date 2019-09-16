import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author ziad
 */
public class EmployeeSet {
	private int cnt;
	private Employee[] empArr;
	private boolean sorted = false;

	/**
	 * regular constructor
	 */
	public EmployeeSet() {
		this.cnt = 0;
		this.empArr = new Employee[10];
	}

	/**
	 * copy constructor
	 *
	 * @param obj an EmployeeSet Object containing non-null values.
	 */
	public EmployeeSet(Object obj) {
		if (obj == null) {
			return;
		}
		if (obj instanceof EmployeeSet) {
			EmployeeSet emps = (EmployeeSet) obj;
			this.cnt = emps.cnt;
			this.empArr = new Employee[emps.empArr.length];
			System.arraycopy(
			    emps.empArr, 0,
			    this.empArr, 0, emps.cnt);

		}
	}

	/**
	 * add function
	 *
	 * @param a Emplyee object to add
	 */
	public void add(Employee a) {
		if (!(contains(a))) {
			ensureCapacity(cnt + 1);
			this.empArr[this.cnt++] = a;
			this.sorted = false;
		}

	}


	/**
	 * @param a Employee object to look for
	 * @return true or false if it was contained
	 */
	public boolean contains(Employee a) {
		if (a == null) {
			return false;
		}
		for (int i = 0; i < cnt; i++) {
			if (a.equals(empArr[i])) {
				return true;
			}
		}
		return false;
	}


	/**
	 * removes an employee by their ID number
	 *
	 * @param eno employee number
	 * @return true or false if it found one to remove
	 */
	public boolean remove(int eno) {
		for (int i = 0; i < cnt; i++) {
			if (empArr[i].getNo() == eno) {
				empArr[i] = empArr[--cnt];
				return true;
			}
		}
		return false;
	}

	/**
	 * ensures that the array has enough space for new employees
	 *
	 * @param minCap the minimum capacity required. Varies by case
	 */
	private void ensureCapacity(int minCap) {
		if (capacity() <= minCap) {
			Employee[] bigArr = new Employee[capacity() * 2];
			System.arraycopy(empArr, 0, bigArr, 0, cnt);
			this.empArr = bigArr;
		}
	}


	/**
	 * @param a Employee object to be added in the correct order by eNo
	 * @precondition Objects in current EmployeeSet must be ordered
	 * @precondition Objects in current EmployeeSet must be not NULL
	 */
	public void addOrdered(Employee a) {
		if (a == null) {
			return;
		}
		if (!sorted) {
			throw new IllegalArgumentException("Employees not " +
			    "sorted");
		}
		for (int i = 0; i < cnt; i++) {
			if (empArr[i].getNo() >= a.getNo()) {
				shiftRight(i, empArr);
				this.empArr[i] = a;
				this.cnt++;
				return;
			}

		}
		add(a);
		this.cnt++;
	}

	/**
	 * shifts all the objects to the left when inserting a new one
	 *
	 * @param ind the index where we are inserting
	 * @param arr the array we are inserting to
	 */
	private void shiftRight(int ind, Employee[] arr) {
		// ensure there is enough space to shift them over.
		ensureCapacity(cnt + 1);
		System.arraycopy(arr, ind, arr, ind + 1, cnt); // wow
	}


	/**
	 * toString method for count and array
	 *
	 * @return a string with all the values int he object formatted
	 */
	@Override
	public String toString() {
		return "EmployeeSet{" +
		    "cnt=" + cnt +
		    ", empArr=" + Arrays.toString(empArr) +
		    '}';
	}

	/**
	 * getters and setters
	 *
	 * @return a value if a getter else void
	 */

	public int size() {
		return cnt;
	}

	public int capacity() {
		return getEmpArr().length;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Employee[] getEmpArr() {
		return empArr;
	}

	public void setEmpArr(Employee[] empArr) {
		this.empArr = empArr;
	}


	/**
	 * reads the employee values from a csv object and adds them to
	 * the set
	 *
	 * @param fname the csv filename
	 * @throws IOException
	 * @precondition must be a CSV file with correct order of values
	 * @precondition first line must be the labels
	 * @precondition last line must be empty
	 */

	public void readCSV(String fname) throws IOException {
		BufferedReader csvReader =
		    new BufferedReader(new FileReader(fname));
		String row;
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			System.out.println(Arrays.toString(data));
			if (data.length > 1 && !(data[6].equals("Age"))) {
				Employee csvEmp = new Employee();
				csvEmp.setAdvisors(new int[]{1, 2, 3});
				csvEmp.setName(new String(data[0]
				    + data[1]));
				csvEmp.setAge(Integer.parseInt(data[6]));
				csvEmp.setNo(Integer.parseInt(data[2]));
				csvEmp.setState(data[3]);
				csvEmp.setZipCode(
				    Integer.parseInt(data[4].trim()));
				add(csvEmp);
			}
		}
		csvReader.close();
	}

	/**
	 * a simple sort function to test the addOrdered function
	 */

	public void bubbleSort() {
		Employee[] arr;
		arr = empArr;
		int n = cnt;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j].getNo() > arr[j + 1].getNo()) {
					// swap arr[j+1] and arr[i]
					Employee temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

		this.sorted = true;
	}

	public static void main(String[] args) throws IOException {
		Employee John = new Employee();
		John.setNo(42);
		EmployeeSet Janitors = new EmployeeSet();
		Janitors.readCSV("core_dataset.csv");
		System.out.println(Janitors.toString());

		EmployeeSet Janitors2 = new EmployeeSet(Janitors);

		Janitors2.add(John);
		Janitors2.remove(42);

		System.out.println(Janitors2.size());
		System.out.println(Janitors2.capacity());
		Employee Jacob = new Employee();
		Jacob.setNo(42);
		try {
			Janitors2.addOrdered(Jacob);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("Exception for unordered employeed" +
			    " works");
		}
		Janitors2.bubbleSort();
		Janitors2.addOrdered(Jacob);
		Employee Jingleheimer = new Employee();
		Jingleheimer.setNo(2147483647);
		Janitors2.addOrdered(Jingleheimer);

		System.out.println(Janitors2.toString());


	}

}
