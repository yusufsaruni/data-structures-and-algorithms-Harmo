package harmo.projects.algorithm;

public class ArrayUtils {
    public static void main(String[] args) {

        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("that"));
    }
    private static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1)/2;
        for(int num: arr){
            sum -= num;
        }
        return sum;
    }

    private static boolean isPalindrome(String str) {
        char[] stringChars = str.toCharArray();
        int startIndex = 0;
        int endIndex = stringChars.length - 1;
        while(startIndex < endIndex){
            if(stringChars[startIndex] != stringChars[endIndex]){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
