
public class Demo6 {

    public static double max(double[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        double m = max(a, n - 1);
        return m > a[n - 1] ? m : a[n - 1];
    }

    public static void main(String[] args) {
        double b[] = {1, 5, 9, 7, 2, 19, 10};
        System.out.println(max(b, 7));
    }
}
