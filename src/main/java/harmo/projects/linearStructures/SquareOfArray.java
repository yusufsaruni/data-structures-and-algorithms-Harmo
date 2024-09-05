package harmo.projects.linearStructures;

import static harmo.projects.linearStructures.QuickSort.printArray;

public class SquareOfArray {

    public static void main(String[] args) {
        int[] array = {-13, -4, -1, 0, 3, 10};
        int[] squares = sortedSquareOfArray(array);
        printArray(squares);
    }

    public static int[] sortedSquareOfArray(int[] arr) {
        int n = arr.length;
        int[] square = new int[arr.length];
        //i - beginning of the array
        //j - from the end of the array.
        int i = 0; int j = n - 1;
        for(int k = n -1; k >= 0; k--){
            if(Math.abs(arr[i]) > Math.abs(arr[j])){
                square[k] = arr[i] * arr[i];
                //we have used element in the i) position, so we increment it
                i++;
            }else{
                square[k] = arr[j] * arr[j];
                //we have used element at j position to we decrement it.
                j--;
            }
        }
        return square;
    }
}
