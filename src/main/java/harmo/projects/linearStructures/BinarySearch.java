package harmo.projects.linearStructures;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 11;
        int pos = searchInsert(arr, target);
        if (pos >= 0) {
            System.out.println("Found at index [" + pos+"]");
        }else{
            System.out.println("Not found, to insert at index ["+pos+"]");
        }
    }
//this is just a comment and don't mind about it
    private static int searchInsert(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if(target < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (array[mid] == target) return mid;
            //if target is less than the mid-value, we can ignore the last half
            //by shifting the high
            if(target < array[mid]) high = mid - 1;
            //if target is greater than the mid-value , we can ignore the first
            //half by shifting the low.
            else low = mid + 1;
        }
        return -1;
    }
}
