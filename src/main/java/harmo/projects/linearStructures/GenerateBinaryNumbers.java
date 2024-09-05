package harmo.projects.linearStructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

    public static void main(String[] args) {

        var binaryNumbers = generateBinaryNumbers(4);
        System.out.println(Arrays.toString(binaryNumbers));
    }

    public static String[] generateBinaryNumbers(int n) {
        String[] binaryNumbers = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for(int i = 0; i < n; i++) {
            binaryNumbers[i] = queue.poll();
            String n1 = binaryNumbers[i] + "0";
            String n2 = binaryNumbers[i] + "1";
            queue.offer(n1);
            queue.offer(n2);
        }
        return binaryNumbers;
    }
}
