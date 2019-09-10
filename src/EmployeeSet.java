import java.util.Arrays;

/**
 * @author ziad
 *
 */
public class EmployeeSet {
	private int employeeCnt;
	private Employee[] employeeArr;

	public EmployeeSet() {
		this.employeeCnt = 0;
		this.employeeArr = new Employee[10];
	}

	public EmployeeSet(Object obj) {
		if (obj == null) {
			return;
		}
		if (obj instanceof EmployeeSet) {
			EmployeeSet emps = (EmployeeSet) obj;
			employeeCnt = emps.employeeCnt;
			employeeArr = emps.employeeArr;

		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EmployeeSet))
			return false;
		EmployeeSet other = (EmployeeSet) obj;
		if (!Arrays.equals(employeeArr, other.employeeArr))
			return false;
		if (employeeCnt != other.employeeCnt)
			return false;
		return true;
	}

	public int size() {
		int size = 0;
		for (int i = 0; i < this.employeeArr.length; i++) {
			if (this.employeeArr[i] != null) {
				size++;
			}
		}

		return size;
	}

	public int capacity() {
		return this.employeeArr.length;
	}

	public void add(Employee a) {
		this.employeeArr[this.employeeCnt] = a;
	}

	public boolean contains(Employee a) {
		if (a == null) {
			return false;
		}
		for (int i = 0; i <= this.employeeCnt; i++) {
			if (this.employeeArr[i].equals(a)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean remove(int eno) {
		if (eno == 0) {
			return false;
		}
		for (int i = 0; i <= this.employeeCnt; i++) {
			if (this.employeeArr[i].getNo() == eno) {
				return true;
			}
		}
		return false;
	}
	
	private void ensureCapacity(int minimumCapacity) {
		
	}

	@Override
	public String toString() {
		return "EmployeeSet [employeeCnt=" + employeeCnt + ", employeeArr=" + Arrays.toString(employeeArr) + "]";
	}

	public int getEmployeeCnt() {
		return employeeCnt;
	}

	public void setEmployeeCnt(int employeeCnt) {
		this.employeeCnt = employeeCnt;
	}

	public Employee[] getEmployeeArr() {
		return employeeArr;
	}

	public void setEmployeeArr(Employee[] employeeArr) {
		this.employeeArr = employeeArr;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee John = new Employee();

	}

}
