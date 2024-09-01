package harmo.projects.linearStructures;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{9, 5, 2, 4, 3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array, new int[array.length], 0,
                array.length - 1);
        mergeSort.printArray(array);
    }

    public void printArray(int[] arr) {
        for(var arr1 : arr) {
            System.out.print(arr1 + " ");
        }
    }

    public void sort(int[] arr, int[] temp, int low, int high) {
        if(low < high) {
            //getting the mid element
            int mid = low + (high - low) / 2;
            //sorting through division - Left side
            sort(arr, temp, low, mid);
            //sorting through division - Right side
            sort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    public void merge(int[] arr, int[] temp, int low, int mid, int high) {

        //coping the element to the temp array
        if (high + 1 - low >= 0) System.arraycopy(arr, low,
                temp, low, high + 1 - low);
//        for(int i = low; i <= high; i++) {
//            temp[i] = arr[i];
//        }

        int i = low;// left array( from low to mid)
        int j = mid + 1;// right array(from mid +1)
        int k = low;//keep track in the original array (merging)

        while(i <= mid && j <= high) {
            if(temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            }else{
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        //If right is exhausted(Remaining elements in the left array)
        while(i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}
