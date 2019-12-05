import java.util.ArrayList;
import java.util.Collections;
public class MinHeap {

    private ArrayList <Integer> data;

    private MinHeap() {
        data = new ArrayList<>();
    }

    /**
     * Adds a new into to the heap and called reheapupward when needed.
     * @param e the integer we want to add.
     */
    public void add(int e){
        data.add(e);
        reHeapUpward(data.size()-1);
    }


    /**
     * rearranges the heap to fix an illegal placement.
     * @param idx the index of the illegal item.
     */
    private void reHeapUpward(int idx){
        if(idx <= 0){
            return;
        }
        int parentidx = ((idx-1)/2);
        if( data.get(idx) < data.get(parentidx) ){
            Collections.swap(data,idx, parentidx);
        }
        reHeapUpward(parentidx);
    }


    /**
     * removes the top item of the heap.
     * @return The integer we removed.
     */
    public int remove(){
        if (data.size() == 0) {
            throw new IllegalCallerException("The heap is empty");
        }
        int temp = top();
        data.remove(0);
        return temp;
    }

    /**
     * Gives us the top item of the heap.
     * @return the smallest integer of the heap.
     */

    public int top(){
        if (data.size() == 0) {
            throw new IllegalCallerException("The heap is empty");
        }
        return data.get(0);
    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "data=" + data +
                '}';
    }

    public static void main(String[] args) {
        MinHeap test = new MinHeap();
        System.out.println(test);
        // test null exceptions.
        try {
            test.remove();
        } catch (IllegalCallerException e) {
            System.out.println("Exception works");
        }
        try {
            test.top();
        } catch (IllegalCallerException e) {
            System.out.println("Exception works");
        }


        // test adding and removing.
        test.add(1);
        System.out.println(test);
        test.top();
        test.remove();
        System.out.println(test);

        // test null cases after adding and removing.
        try {
            test.remove();
        } catch (IllegalCallerException e) {
            System.out.println("Exception works");
        }
        try {
            test.remove();
        } catch (IllegalCallerException e) {
            System.out.println("Exception works");
        }

        // add 0 to 10
        for (int i = 0; i < 10; i++) {
            test.add(i);
        }

        // add 10 to 0
        System.out.println(test);
        for (int i = 10; i > 0; i--) {
            test.add(i);
        }

        // print and test remove on multiple item heap.
        System.out.println(test);
        test.remove();
        System.out.println(test);
        test.remove();
        System.out.println(test);
        test.top();

    }

}
