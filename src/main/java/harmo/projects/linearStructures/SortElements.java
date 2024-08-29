package harmo.projects.linearStructures;

public class SortElements {

    public static void main(String[] args) {
        int[] unSortedArr = {3, 9, 1, 10, 4, 23, 2};
        SortElements sortElements = new SortElements();
        sortElements.printArray(unSortedArr);
        sortElements.bubbleSort(unSortedArr);
        sortElements.printArray(unSortedArr);
        System.out.println("-".repeat(40));
        int[] array = {3, 10, 1, 4, 23, 2};
        sortElements.printArray(array);
        sortElements.insertionSort(array);
        sortElements.printArray(array);
        int[] array2 = {3, 10, 1, 4, 23, 2};
        sortElements.selectionSort(array2);
        sortElements.printArray(array2);
    }
    private void selectionSort(int[] unSortedArr) {
        int n = unSortedArr.length;
        for(int i = 0; i < n - 1; i++) {
            int minIndex = i;
            //j+1 - j starts from the next index(unsorted part).
            for(int j = i + 1; j < n; j++) {
                //checking if the current element is less than our minimum
                if(unSortedArr[j] < unSortedArr[minIndex]) {
                    minIndex = j;
                }
            }
            //swapping the minimum with the leftmost(denoted by i)
            int temp = unSortedArr[i];
            unSortedArr[i] = unSortedArr[minIndex];
            unSortedArr[minIndex] = temp;
        }
    }

    private void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    private void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean isSwapped;
        for(int i = 0; i < n ; i++){
            isSwapped = false;
            //-i) ensures that we don't include the last element that is already
            //sorted in the iteration.
            for(int j = 0; j < n - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped)break;
        }
    }
    private void insertionSort(int[] arr) {
        int n = arr.length;
        //We are assuming that the first element at index 0 is already sorted
        //that's why we are starting at index 1.
        for (int i = 1; i < n; i++) {//unsorted
            int temp = arr[i];
            int j = i - 1;//accessing the sorted part.
            while (j >= 0 && arr[j] > temp) {
                //shifting larger than temp elements to the right.
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = temp;
        }
    }
}
