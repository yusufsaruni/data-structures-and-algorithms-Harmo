package harmo.projects.nonLinearStructures;

public class MaxPQ {

    private Integer[] heap;
    private int n;
    public MaxPQ(int capacity){
        heap = new Integer[capacity + 1];
        n = 0;
    }
    public boolean isEmpty(){
        return n == 0;
    }
    public int size(){
        return n;
    }
    public static void main(String[] args) {
        MaxPQ maxPQ = new MaxPQ(3);
        maxPQ.insert(4);
        maxPQ.insert(5);
        maxPQ.insert(2);
        maxPQ.insert(6);
        maxPQ.insert(1);
        maxPQ.insert(3);
        System.out.println("Deleted: " + maxPQ.deleteMax());
        maxPQ.printMaxHeap();
        int[] array = {5,1, 9, 2, 10, 15, 20};
        System.out.println("Search key found at: "+ maxPQ.linearSearch(array,
                7, 10));
        System.out.println();
        System.out.println("Size: " + maxPQ.size());
    }

    private void resize(int newLength){
        Integer[] newHeap = new Integer[newLength];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
//        for(int i = 0; i < heap.length; i++){
//            newHeap[i] = heap[i];
//        }
        heap = newHeap;
    }
    public void printMaxHeap(){
        for(int i = 1; i <= n; i++){
            System.out.print(heap[i] + " ");
        }
    }
    public int deleteMax(){
        //storing the maxing integer in a local variable.
        int max = heap[1];
        //swapping the last and the first element.
        swap(1, n);
        n --;
        sink(1);
        heap[ n + 1] = null;
        if(n > 0 && (n == (heap.length - 1) / 4)){
            resize(heap.length / 2);
        }
        return max;
    }
    public int linearSearch(int[] arr, int length, int target){
        for(int i = 0; i < length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    private void sink(int k){
        while(2 * k <= n){
            int j = 2 * k;
            if(j < n && heap[j] > heap[j + 1]){
                j++;
            }
            if(heap[k] >= heap[j]){
                break;
            }
            swap(k, j);
            k = j;

        }
    }
    private void swap(int a , int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    public void insert(int val){
        if(n == heap.length - 1){
            resize(2 * heap.length);
        }
        n++; //At first this helps us not to insert in 0 index
        heap[n] = val;
        swim(n);
    }
    private void swim(int i){
        //the while block checks if the parent is less than the child.
        while(i > 1 && heap[i/2] < heap[i]){
            int temp = heap[i];
            heap[i] = heap[i/2];
            heap[i/2] = temp;
            i = i/2;// because we need to continue shifting up till new value
            // is at correct position
        }
    }
}
