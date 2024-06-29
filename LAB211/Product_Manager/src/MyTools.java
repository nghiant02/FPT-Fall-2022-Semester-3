import java.util.Scanner;

public class MyTools {
    public static Scanner sc = new Scanner(System.in);

    public static String checkName(String mess) {
        String _name;
        while (true) {
            try {
                System.out.print(mess);
                _name = sc.nextLine();
                if (_name.length() < 5 || _name.contains(" ")) {
                    throw new Exception("Name must at least 5 char!!");
                }
                return _name.trim();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int checkInt(String mess, String errorMess, int lowerBound, int higherBound) {
        int value;
        while (true) {
            try {
                System.out.print(mess);
                value = Integer.parseInt(sc.nextLine());
                if (value < lowerBound || value > higherBound) {
                    throw new Exception(errorMess);
                }
                return value;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String CheckAvailable(String mess) {
        String Value;
        while (true) {
            try {
                System.out.print(mess);
                Value = sc.nextLine();
                if (Value.equals("yes")) {
                    return "Available";
                } else if (Value.equals("no")) {
                    return "Not Available";
                } else throw new Exception("value must yes/no only!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String CheckStringNotBlank(String mess) {
        String value;
        while (true) {
            try {
                System.out.print(mess);
                value = sc.nextLine();
                if (value.isEmpty()) {
                    throw new Exception("Value can't be blank!!");
                }
                return value.trim();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

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
}
