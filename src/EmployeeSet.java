import java.util.Arrays;

/**
 * @author ziad
 *
 */
public class EmployeeSet {
	private int empCnt;
	private Employee[] empArr;

	public EmployeeSet() {
		this.empCnt = 0;
		this.empArr = new Employee[10];
	}

	public EmployeeSet(Object obj) {
		if (obj == null) {
			return;
		}
		if (obj instanceof EmployeeSet) {
			EmployeeSet emps = (EmployeeSet) obj;
			empCnt = emps.empCnt;
			this.empArr = new Employee[10];
            System.arraycopy(emps.empArr, 0, empArr, 0, emps.empCnt);

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
		if (!Arrays.equals(empArr, other.empArr))
			return false;
        return empCnt == other.empCnt;
    }

	public int size() {
		int size = 0;
        for (Employee employee : empArr) {
            if (employee != null) {
                size++;
            }
        }

		return size;
	}

	public int capacity() {
		return empArr.length;
	}

	public void add(Employee a) {
		this.empArr[empCnt] = a;
		this.empCnt++;
	}

	public boolean contains(Employee a) {
		if (a == null) {
			return false;
		}
		for (int i = 0; i <= empCnt; i++) {
			if (empArr[i].equals(a)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean remove(int eno) {
		if (eno == 0) {
			return false;
		}
		for (int i = 0; i <= empCnt; i++) {
			if (empArr[i].getNo() == eno) {
			    empArr[i] = empArr[empCnt];
			    empCnt--;
				return true;
			}
		}
		return false;
	}
	
	private void ensureCapacity() {
		if (empArr.length+1 >= capacity()) {
			Employee[] biggerArr = new Employee[capacity()*2];
			System.arraycopy(empArr, 0, biggerArr,0, empCnt);
			empArr = biggerArr;
		}
	}

	@Override
	public String toString() {
		return "EmployeeSet [empCnt=" + empCnt + ", empArr=" + Arrays.toString(empArr) + "]";
	}

	public int getEmployeeCnt() {
		return empCnt;
	}

	public void setEmployeeCnt(int empCnt) {
		this.empCnt = empCnt;
	}

	public Employee[] getEmployeeArr() {
		return empArr;
	}

	public void setEmployeeArr(Employee[] empArr) {
		this.empArr = empArr;
	}

	public static void main(String[] args) {
		Employee John = new Employee();
        Employee Ziad = new Employee();
        Employee Katie = new Employee();
        Employee Brianna = new Employee();

        Employee Joseph = new Employee();

        Employee[] StudyGroup = { Ziad, Katie, Brianna, Joseph, John };

        Employee.setAllAdv();

	}

}
