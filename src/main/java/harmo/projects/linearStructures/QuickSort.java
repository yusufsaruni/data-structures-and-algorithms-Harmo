package harmo.projects.linearStructures;
import java.util.Random;

public class QuickSort {


    public static void main(String[] args) {
        int[] unsorted = {10, 3, 7,2, 3, 8, 11};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(unsorted, 0, unsorted.length - 1);
        printArray(unsorted);
        getRandomNumber();

    }
    private static void getRandomNumber(){
      var random = new Random();
      int randomNumber = random.nextInt();
      System.out.println(randomNumber);
    }
    public void sort(int[] arr, int low, int high){
        if(low < high){//base case
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        int j = low;
        while(i <= high){
            if(arr[i] <= pivot){
                //taking less elements to the left
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j - 1;
    }
  
    public static void printArray(int[] arr) {
        for(var value: arr){
            System.out.print(value + " ");
        }
    }
}
