package harmo.projects.linearStructures;

public class MaxMin {

    public static void main(String[] args) {

        int[] array = {2, 3, 5, 6, 8, 9, 12, 15};
        arrangeMaxMin(array);
        QuickSort.printArray(array);
    }

    public static void arrangeMaxMin(int[] arr) {
        int maxIndex = arr.length - 1;
        int minIndex = 0;
        int maxValue = arr[maxIndex] + 1;
        for(int i = 0; i< arr.length; i++) {
            if(i % 2 == 0) {
                //this equation enables to store two numbers in a single index
                arr[i] = arr[i] + ((arr[maxIndex] % maxValue) * maxValue);
                //once we use the max index ,we decrement it.
                maxIndex--;
            }else{
                arr[i] = arr[i] + ((arr[minIndex] % maxValue) * maxValue);
                //once we use the min index , we increment it.
                minIndex++;
            }
        }
        //converting back the array.
        for(int i = 0; i<arr.length; i++) {
            arr[i] = arr[i] / maxValue;
        }
    }
}
