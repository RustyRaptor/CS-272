import java.util.Arrays;

/**
 * @author Ziad Arafat
 *
 */
public class Employee {
	private String name;
	private int no;
	private int age;
	private String state;
	private int zipCode;
	private int[] advisors;

	// constructor
	public Employee() {
		this.name = null;
		this.state = null;
		this.zipCode = 0;
		this.no = 0;
		this.age = 0;
		this.advisors = new int[3];
	}

	// copy constructor
	public Employee(Object obj) {
		if (obj == null) {
			return;
		}
		if (obj instanceof Employee) {
			Employee emp = (Employee) obj;
			name = new String(emp.name);
			state = new String(emp.state);
			zipCode = emp.zipCode;
			no = emp.no;
			age = emp.age;
			advisors = emp.advisors;

		}
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int[] getAdvisors() {
		return advisors;
	}

	public void setAdvisors(int[] advisors) {
		this.advisors = advisors;
	}

	// returns a string describing all the values.
	@Override
	public String toString() {
		return "Employee [name=" + name + ", no=" + no + ", age=" + age +
				", state=" + state + ", zipCode=" + zipCode
				+ ", advisors=" + Arrays.toString(advisors) + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj == null)) {
			return false;
		}
		// checks if we are comparing it to itself
		// If it's the same object this saves time
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (no != other.no) {
			return false;
		}
		return true;
	}

	// returns all DISTINCT advisors of two employees
	/**
	 * @param e1 an employee object you want to get advisors from
	 * @param e2 another employee object to get advisors from
	 */
	public static int[] getAllAdvisors(Employee e1, Employee e2) {
		if((e1 == null)||(e2 == null)) {
			System.out.println("This Employee is NULL");
			return new int[] {0,0,0};
		}
		int[] adv1 = e1.getAdvisors();
		int[] adv2 = e2.getAdvisors();

		int[] merged = new int[6];
		mergeArr(merged, adv1, adv2);
		descBubbleSort(merged);
		removeDup(merged);
		descBubbleSort(merged);

		int[] newMerged = removeZero(merged);
		return newMerged;
	}

	// Merges 2 arrays into 1
	/**
	 * @param arrMerge an empty array you want to merge the two arrays into
	 * @param arr1     the first array (will be placed first in the new array)
	 * @param arr2     the second array (will be inserted after arr1)
	 */
	public static void mergeArr(int[] arrMerge, int[] arr1, int[] arr2) {
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			arrMerge[cnt] = arr1[i];
			cnt++;
		}
		for (int i = 0; i < 3; i++) {
			arrMerge[cnt] = arr2[i];
			cnt++;
		}
	}

	// Sorts an array using bubble sort in descending order
	// this is done to put the zeroes in an array at the end.
	/**
	 * @param arr the array you want to sort
	 */
	public static void descBubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] < arr[j + 1]) {
					// swap arr[j+1] and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	// sets duplicate items in an array to 0
	/**
	 * @param arr the array you want to remove duplicates from
	 */
	public static void removeDup(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] == arr[j + 1]) {
					// swap arr[j+1] and arr[i]
					int temp = arr[j];
					arr[j] = 0;
					arr[j + 1] = temp;
				}
	}

	// counts number of non-zero items in an array
	/**
	 * @param arr the array you want to count advisors in
	 */
	public static int countAdv(int[] arr) {
		int n = arr.length;
		int cnt = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == 0) {
				continue;
			} else {
				cnt++;
			}
		}
		return cnt;
	}

	// creates a new copy of an array without the 0 values
	/**
	 * @param arr the array you want to remove 0s from
	 */
	public static int[] removeZero(int[] arr) {
		int cnt = 0;
		int[] newMerged = new int[countAdv(arr)];
		for (int i = 0; i < countAdv(arr); i++) {
			newMerged[cnt] = arr[i];
			cnt++;
		}
		return newMerged;
	}
	
	
	// random values on an array of employees. 
	/**
	 * @param emps an array of employee objects to set values on
	 */
	public static void setAllAdv(Employee[] emps) {
		int cnt = 0;
		for(int i = 0; i < emps.length; i++) {
			if(emps[i] == null) {
				return;
			}
			if(!(emps[i] instanceof Employee)) {
				return;
			}
			emps[i].setName("Student");
			emps[i].setAdvisors(new int[] { 
					(int) getRandomInt(1, 20), 
					(int) getRandomInt(1, 20), 
					(int) getRandomInt(1, 20) });
			emps[i].setAge((int) getRandomInt(18, 25));
			emps[i].setNo((int) getRandomInt(10000, 99999));
			emps[i].setState("NM");
			emps[i].setZipCode((int) getRandomInt(87001, 88439));
		}
	}
	
	
	// prints out the toString() values of an array of employees
	/**
	 * @param emps an array of employee objects to get values of
	 */
	public static void getAllEmployees(Employee[] emps) {
		int cnt = 0;
		for(int i = 0; i < emps.length; i++) {
			if(emps[i] == null) {
				return;
			}
			if(!(emps[i] instanceof Employee)) {
				return;
			}
			System.out.println(emps[i].toString());
		}
	}

	
	// generates a random double (to be cast to an int) between a min and max
	/**
	 * @param min the minimum value int
	 * @param max the maximum value int
	 */
	public static double getRandomInt(double min, double max){
	    double x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	
	// Main function
	public static void main(String[] args) {
		Employee Ziad = new Employee();
		Employee Katie = new Employee();
		Employee Brianna = new Employee();
		
		Employee Joseph = null;
		
		Employee[] StudyGroup = {Ziad, Katie, Brianna, Joseph};
		
		Employee.setAllAdv(StudyGroup);
		Employee Angel = new Employee(Ziad);
		Employee.getAllEmployees(StudyGroup);
		Ziad.setAdvisors(new int[] { 22, 5, 3 });
		Katie.setAdvisors(new int[] { 10, 22, 3 });
		Angel.setName("Angel");
		Ziad.setName("Ziad");
		Brianna.setName("Brianna");
		System.out.println(Brianna.toString());

		System.out.println(
				Arrays.toString(Employee.getAllAdvisors(Ziad, Katie)));
		System.out.println(
				Arrays.toString(Employee.getAllAdvisors(null, null)));
		System.out.println(
				Arrays.toString(Employee.getAllAdvisors(Ziad, Joseph)));
		System.out.println(
				Arrays.toString(Employee.getAllAdvisors(Joseph, Ziad)));
		
		System.out.println(Ziad.toString());
		System.out.println(Angel.toString());
		Ziad.setAdvisors(new int[] {0,0,0});
		System.out.println(Angel.toString());
		System.out.println(Ziad.toString());
	}

}
