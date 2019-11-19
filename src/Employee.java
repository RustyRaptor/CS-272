import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Ziad Arafat
 * Main method is at very bottom.
 */
public class Employee {
    private String name;
    private int no;
    private int age;
    private String state;
    private int zipCode;
    private int[] advisors;

    // constructor
    Employee() {
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
            assert false;
            System.arraycopy(emp.advisors, 0, advisors, 0, emp.advisors.length);


        }
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getAge() {
        return age;
    }

    void setAge(int age) {
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

    void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    private int[] getAdvisors() {
        return advisors;
    }

    void setAdvisors(int[] advisors) {
        this.advisors = advisors;
    }

    // returns a string describing all the values.
    @Override
    public String toString() {
        return "Employee [name=" + name + ", no=" + no + ", age=" + age + ", state=" + state + ", zipCode=" + zipCode
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
        return no == other.no;
    }

    // returns all DISTINCT advisors of two employees

    /**
     * @param e1 an employee object you want to get advisors from
     * @param e2 another employee object to get advisors from
     */
    private static int[] getAllAdvisors(Employee e1, Employee e2) {
        if ((e1 == null) || (e2 == null)) {
            System.out.println("This Employee is NULL");
            return new int[]{0, 0, 0};
        }
        int[] adv1 = e1.getAdvisors();
        int[] adv2 = e2.getAdvisors();

        int[] merged = new int[6];
        mergeArr(merged, adv1, adv2);
        descBubbleSort(merged);
        removeDup(merged);
        descBubbleSort(merged);

        return removeZero(merged);
    }

    // Merges 2 arrays into 1

    /**
     * @param arrMerge an empty array you want to merge the two arrays into
     * @param arr1     the first array (will be placed first in the new array)
     * @param arr2     the second array (will be inserted after arr1)
     */
    private static void mergeArr(int[] arrMerge, int[] arr1, int[] arr2) {
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
    private static void descBubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // sets duplicate items in an array to 0

    /**
     * @param arr the array you want to remove duplicates from
     */
    private static void removeDup(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] == arr[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = 0;
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // counts number of non-zero items in an array

    /**
     * @param arr the array you want to count advisors in
     */
    private static int countAdv(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != 0) {
                cnt++;
            }
        }
        return cnt;
    }

    // creates a new copy of an array without the 0 values

    /**
     * @param arr the array you want to remove 0s from
     */
    private static int[] removeZero(int[] arr) {
        int cnt = 0;
        int[] newMerged = new int[countAdv(arr)];
        for (int i = 0; i < countAdv(arr); i++) {
            newMerged[cnt] = arr[i];
            cnt++;
        }
        return newMerged;
    }

    public static String nameGen() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);
    }

    // random values on an array of employees.



    // prints out the toString() values of an array of employees


    // generates a random double (to be cast to an int) between a min and max

    /**
     * @param min the minimum value int
     * @param max the maximum value int
     */
    private static double getRandomInt(double min, double max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    // Main function
    public static void main(String[] args) {
        Employee Ziad = new Employee();
        Employee Katie = new Employee();
        Employee Brianna = new Employee();

        Employee Joseph = null;

        Employee Angel = new Employee();
        Ziad.setAdvisors(new int[]{22, 5, 3});
        Katie.setAdvisors(new int[]{10, 22, 3});
        Angel.setName("Angel");
        Ziad.setName("Ziad");
        Brianna.setName("Brianna");
        System.out.println(Brianna.toString());

        System.out.println(Arrays.toString(Employee.getAllAdvisors(Ziad, Katie)));
        System.out.println(Arrays.toString(Employee.getAllAdvisors(null, null)));
        System.out.println(Arrays.toString(Employee.getAllAdvisors(Ziad, Joseph)));
        System.out.println(Arrays.toString(Employee.getAllAdvisors(Joseph, Ziad)));

        System.out.println(Ziad.toString());
        System.out.println(Angel.toString());
        Ziad.setAdvisors(new int[]{0, 0, 0});
        System.out.println(Angel.toString());
        System.out.println(Ziad.toString());
    }

}
