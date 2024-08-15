package harmo.projects.algorithm;

public class TimeComplexityDemo {

    public static void main(String[] args) {
        double now = System.currentTimeMillis();
        TimeComplexityDemo demo = new TimeComplexityDemo();
        System.out.println(demo.findSum2(99999));
        demo.print(3);
        System.out.println("Time taken: " + (System.currentTimeMillis() - now) +
                "milliseconds");
    }

    public int findSum(int n){
        return n * (n + 1) / 2;
    }
    public int findSum2(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
    }
    public void print(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.println("i = " + i + ", j = " + j);
            }
            System.out.println("End of inner loop");
        }
        System.out.println("End of outer loop");
    }
}
