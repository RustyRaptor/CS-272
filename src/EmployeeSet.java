import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author ziad
 */
public class EmployeeSet {
	private int cnt;
	private Employee[] empArr;

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
			cnt = emps.cnt;
			this.empArr = new Employee[10];
			System.arraycopy(
			    emps.empArr, 0,
			    empArr, 0, emps.cnt);

		}
	}


	public void add(Employee a) {
		if (!(contains(a))){
			ensureCapacity(cnt + 1);
			this.empArr[this.cnt++] = a;
		}

	}

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

	public boolean remove(int eno) {
		for (int i = 0; i < cnt; i++) {
			if (empArr[i].getNo() == eno) {
				empArr[i] = empArr[--cnt];
				return true;
			}
		}
		return false;
	}

	private void ensureCapacity(int minCap) {
		if (capacity() <= minCap) {
			Employee[] bigArr = new Employee[capacity() * 2];
			System.arraycopy(empArr, 0, bigArr, 0, cnt);
			empArr = bigArr;
		}
	}


	/**
	 *
	 * @param a Employee object
	 * @precondition
	 * Objects in current EmployeeSet must be ordered by employee number.
	 *
	 *
	 */
	public void addOrdered(Employee a) {
		if (a == null) {
			return;
		}
		for (int i = 0; i < cnt; i++) {
			if (empArr[i].getNo() >= a.getNo()) {
				shiftRight(i, empArr);
				empArr[i] = a;
				return;
			}

		}
		add(a);
	}

	private void shiftRight(int ind, Employee[] arr){
		ensureCapacity(cnt + 1);
//		for (int i = cnt-1; i > ind; i--) {
//			arr[i] = arr[i+1];
//		}
		System.arraycopy(arr,ind, arr, ind+1, cnt );
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
				csvEmp.setName(new String(data[0] + data[1]));
				csvEmp.setAge(Integer.parseInt(data[6]));
				csvEmp.setNo(Integer.parseInt(data[2]));
				csvEmp.setState(data[3]);
				csvEmp.setZipCode(Integer.parseInt(data[4].trim()));
				add(csvEmp);
			}
		}
		csvReader.close();
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


	}

}
