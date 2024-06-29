package data;

import java.io.File;
import java.util.Properties;
import java.util.Scanner;

public class AccountChecker {
    public static Scanner sc = new Scanner(System.in);

    public static boolean getLogin(String filePath) {
        Config config = new Config();
        Properties properties = config.readFileProperties();
        String fileName = properties.getProperty(filePath);
        boolean isAuthenticated = false;
        System.out.println("Pleas login in");
        System.out.print("Name: ");
        String accName = sc.nextLine();
        System.out.print("Pass: ");
        String pwd = sc.nextLine();
        System.out.print("Role: ");
        String role = sc.nextLine();
        Account acc = new Account(accName, pwd, role);
        File AccountFile = new File(fileName);
        try {
            Scanner inputBuffer = new Scanner(AccountFile);
            while (inputBuffer.hasNext()) {
                String line = inputBuffer.nextLine();
                String[] split = line.split("\\|");
                if (split[0].equals(acc.getAccName())) {
                    if (split[1].equals(acc.getPwd())) {
                        if (split[2].equals(acc.getRole())) {
                            isAuthenticated = true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("File not Found!");
        }
        return isAuthenticated;
    }
}
