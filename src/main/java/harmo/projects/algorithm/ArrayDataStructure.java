package harmo.projects.algorithm;

public class ArrayDataStructure {

    public static void main(String[] args) {
        int[] myArray = {0, 34, 0, 34, 33, 1};
        System.out.println("Minimum value: " + findMinimum(myArray));
        System.out.println("Second max: " + findSecondMax(myArray));
        zerosAtTheEnd(myArray);
        printArray(myArray);
    }

    //MOVING THE ZEROS TO THE END OF AN ARRAY.
    private static void zerosAtTheEnd(int[] array) {
        int n = array.length;
        int j = 0; //to keep track of the index of elements with zeros only.
        // Note: j can only be incremented if the value of the elements bearing this
        //index is not zero(0). If it is zero, we don't perform any increment.
        //i) will focus on non-zeros
        for(int i = 0; i < n; i++) {
            if(array[i] != 0 && array[j]==0){
                //in this case, we do the swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            //incremented if j doesn't hold a zero
            if(array[j] != 0){
                j++;
            }
        }
    }
    //FINDING THE SECOND MAXIMUM VALUE
    private static int findSecondMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int j : array) {
            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j > secondMax && j != max) {
                secondMax = j;
            }
        }
        return secondMax;
    }
    public static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
        System.out.println("-".repeat(20));
    }
    //REMOVING EVEN INTEGERS FROM AN ARRAY.
    private static int[] removeEven(int[] arr) {
        //GETTING THE SIZE OF THE RESULTING ARRAY.
        int evenCount = 0;
        for (int j : arr) {
            if (j % 2 == 0) {
                evenCount++;
            }
        }
        //CREATING AN ARRAY WITH THE FIXED SIZE OF EXPECTED RESULT.
        int[] result = new int[arr.length - evenCount];
        int resultIndex = 0;
        for (int j : arr) {
            if(j % 2 != 0){
                result[resultIndex++] = j;
            }
        }
        return result;
    }
    //REVERSING AN ARRAY- USING SWAPPING ELEMENTS(FIRST AND LAST).
    private static void reverseArray(int[] arr, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = arr[startIndex];//storing the first element to a temp variable
            // assigning the value of end index to the already do with start index
            arr[startIndex] = arr[endIndex];
            // assigning the value in the temp variable(start index value) to the
            //end index.
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    //FINDING THE MINIMUM VALUE OF AN ARRAY
    private static int findMinimum(int[] arr) {
        if(arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array is null or empty");
        }
        int min = arr[0];//hold the minimum value of an array.
        for (int i = 1; i < arr.length; i++) {
            if( arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
