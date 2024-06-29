
public class Demo4 {

    public static double gp(int n, double a, double q) {
        if (n == 1) {
            return a;
        }
        return gp(n - 1, a, q) * q;
    }

    public static void main(String[] args) {
        System.out.println(gp(6, 1.5, 2));
    }
}
