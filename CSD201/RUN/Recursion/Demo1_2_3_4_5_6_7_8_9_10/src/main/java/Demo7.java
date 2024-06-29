
public class Demo7 {
    public static double min(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        double m = min(a, n - 1);
        return m < a[n - 1] ? m : a[n - 1];
    }

    public static void main(String[] args) {
        int b[] = {1, 5, 9, 7, 2, 19, 10};
        System.out.println(min(b, 7));
    }
    
}
