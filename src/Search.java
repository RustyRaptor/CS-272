public class Search {
    /**
     * imoplements binary search
     * @param A the array we want to search in.
     * @param e the int we are looking for in the array.
     * @return the index of the item we are finding.
     */
    private static int binarySearch(int[] A, int e){
        int end = A.length-1;
        int start = 0;
        int mid = (end+start)/2;

        while((start <= end)){
            if(A[mid] == e) {
                return mid;
            }
            if(A[mid] < e){
                start = mid+1;
                mid = (end+start)/2;
            }
            if(A[mid] > e){
                end = mid-1;
                mid = (end+start)/2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] myArray = {1,2,3,4,5,6,7,8,9,10};
        // test for each section of the array.
        System.out.println(binarySearch(myArray, 6));
        System.out.println(binarySearch(myArray, 11));
        System.out.println(binarySearch(myArray, 3));
    }

}
