
public class Demo3 {

    public static double ap(int n, double a, double d) {
        if (n == 1) {
            return a;
        }
        return ap(n - 1, a, d) + d;
    }

    public static void main(String[] args) {
        System.out.println(ap(6, 1.5, 2));
    }
}
