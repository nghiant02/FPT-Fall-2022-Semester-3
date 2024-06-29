import java.util.Scanner;

public class Validator {
    public static Scanner sc = new Scanner(System.in);

    public static boolean CheckYesNo(String mess) {
        String Value;
        while (true) {
            try {
                System.out.print(mess);
                Value = sc.nextLine();
                if (Value.equals("yes")) {
                    return false;
                } else if (Value.equals("no")) {
                    return true;
                } else throw new Exception("value must yes/no only!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getString1(String msg, String pattern, String err) {
        String result = "";
        boolean check = false;
        do {
            System.out.print(msg);
            result = sc.nextLine();
            if (!result.matches(pattern)) {
                System.out.println(err);
            } else {
                check = true;
            }
        } while (!check);
        return result;
    }

    public static String getString(String msg) {
        String result = "";
        boolean check = false;
        do {
            System.out.print(msg);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("CAN NOT BE EMPTY !!! ");
            } else {
                check = true;
            }
        } while (!check);
        return result;
    }

    public static double getDouble(String msg, double min) {
        double n = 0;
        boolean check = false;
        do {
            try {
                System.out.print(msg);
                n = Double.parseDouble(sc.nextLine());
                if (n <= min) {
                    System.out.println("CAN NOT LESS THAN " + min + " !!! ");
                } else {
                    check = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ENTER A NUMBER !!! ");
            }
        } while (!check);
        return n;
    }
}
