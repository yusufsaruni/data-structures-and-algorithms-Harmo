package harmo.projects.algorithm;

public class ArrayResizing {

    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println("Original size: " + arr.length);
        arr = resize(arr, 20);
        System.out.println("New array size: " + arr.length);
        arr = resize(arr, 30);
        System.out.println("New array size: " + arr.length);
    }

    private static int[] resize(int[] array, int size) {
        int[] temp = new int[size];
        System.arraycopy(array, 0, temp, 0, array.length);
        return temp;
    }
}
