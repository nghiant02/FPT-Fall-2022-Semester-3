package tools;

import java.io.*;
import java.util.Scanner;

public class MyTools {
    public static Scanner sc = new Scanner(System.in);

    public static boolean checkFileExists(String fileName) {
        File f = new File(fileName);
        try {
            if (f.exists()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static String checkStringNotBlank(String mess) {
        String value;
        while (true) {
            try {
                System.out.print(mess);
                value = sc.nextLine();
                if (value.isEmpty()) {
                    throw new Exception("Please input is not blank");
                }
                return value.trim();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String checkStringWithPatter(String mess, String pattern) {
        String value;
        while (true) {
            try {
                System.out.print(mess);
                value = sc.nextLine();
                if (value.matches(pattern)) {
                    return value.trim();
                } else System.out.println("Pattern not match!");
                if (value.isEmpty()) {
                    System.out.println("Value can't be empty!");
                }

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

    }

    public static boolean CheckBoolValue(String mess) {
        String value;
        System.out.println(mess + "[1/0-Y/N-T/F]");
        value = sc.nextLine();
        char c = Character.toUpperCase(value.charAt(0));
        return (c == '1' || c == 'Y' || c == 'T');

    }
}
