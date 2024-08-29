package harmo.projects.linearStructures;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        LinearSearch obj = new LinearSearch();
        System.out.println("Found at: "+obj.search(arr, arr.length, 11));
    }

    public int search(int[] arr, int n, int key) {
        for(int i = 0; i < n; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
}
