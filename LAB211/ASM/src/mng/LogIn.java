package mng;

import data.AccountChecker;
import data.DealerList;

import java.util.Collections;
import java.util.Scanner;

public class LogIn {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //login
        do {
            boolean isLogin = AccountChecker.getLogin("FileOfAccount");
            if (isLogin) {
                System.out.println("Login successful!");
                break;
            } else System.out.println("Fail to login!");
        }
        while (true);
        //Call DealerList and Main
        DealerList dl = new DealerList();
        try {
            if (!dl.readLineFormFile("FileOfDealer")) {
                return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] options = {"Add new dealer", "Search a dealer", "Remove a dealer", "Update a dealer", "Print all dealer", "Write to file"};
        int choice;
        do {
            System.out.println("------------Managing Dealer-----------------");
            Collections.sort(dl);
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    dl.addDealer();
                    break;
                case 2:
                    dl.searchDealerByID();
                    break;
                case 3:
                    dl.removeDealerById();
                    break;
                case 4:
                    dl.updateDealerById();
                    break;
                case 5:
                    dl.printAllDealer();
                    break;
                case 6:
                    try {
                        dl.saveToFile("FileOfDealer");
                        System.out.println("Save successfully!");
                    } catch (Exception e) {
                        throw new RuntimeException("File not found!");
                    }
                    break;
            }
        } while (choice > 0 && choice < 7);
    }
}
