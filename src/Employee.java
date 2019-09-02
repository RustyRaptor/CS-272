import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private int no;
	private int age;
	private String state;
	private int zipCode;
	private int advisors[];
	public Employee() {
		this.name = null;
		this.state = null;
		this.zipCode = 0;
		this.no = 0;
		this.age = 0;
		this.advisors = null;
	}
	public Employee(Object obj) {
		if (obj == null) {
			return;
		}
		if (obj instanceof Employee) {
			Employee emp = (Employee)obj;
			name = emp.name;
			state = emp.state;
			zipCode = emp.zipCode;
			no = emp.no;
			age = emp.age;
			advisors = emp.advisors;
			
			
		}
	}
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
	@Override
	public String toString() {
		return "Employee [name=" + name + ", no=" + no + ", age=" + age + ", state=" + state + ", zipCode=" + zipCode
				+ ", advisors=" + Arrays.toString(advisors) + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
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
	public static void getAllAdvisors(Employee e1, Employee e2) {
		if ((e1 == null) || (e2 == null)) {
//			return null;
			System.out.println("NULL");
		}
		// checks if we are comparing it to itself
		// If it's the same object this saves time
		if (e1 == e2) {
//			return e1.getAdvisors();
			System.out.println(e1.getAdvisors());
		}
		if (!(e1 instanceof Employee) || !(e2 instanceof Employee) ) {
//			return null;
			System.out.println("NULL");
		}		
		List<int[]> merged = new ArrayList<int[]>(Arrays.asList(e1.getAdvisors()));
		merged.addAll(Arrays.asList(e2.getAdvisors()));
		System.out.println(merged);
		
		
	}
	
	public static void main(String[] args) {
		Employee Ziad = new Employee();
		Employee Brianna = new Employee();
		System.out.println(Ziad.getAdvisors());
		int ziadAdvNew[] = {0,0,0};
		Ziad.setAdvisors(ziadAdvNew);
		System.out.println(ziadAdvNew);
		System.out.println(Arrays.toString(Ziad.getAdvisors()));
		Brianna.setAdvisors(ziadAdvNew);
		
		Employee.getAllAdvisors(Ziad, Brianna);
	}
	
}
