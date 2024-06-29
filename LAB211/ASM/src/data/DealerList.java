package data;

import tools.MyTools;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class DealerList extends ArrayList<Dealer> {
    public static Scanner sc = new Scanner(System.in);

    public DealerList() {
    }

    public boolean readLineFormFile(String filePath) throws Exception {
        Config cg = new Config();
        Properties properties = cg.readFileProperties();
        String filename = properties.getProperty(filePath);
        try {
            String thisLine; // content to read each line.
            BufferedReader myInput;// create Buffer
            File f = new File(filename);//open file
            if (!MyTools.checkFileExists(filename)) {
                System.exit(0);
                return false;
            }
            System.out.println(filename);
            String fullPath = f.getAbsolutePath();
            FileInputStream file = new FileInputStream(fullPath);
            myInput = new BufferedReader(new InputStreamReader(file));
            // read line until the end of the file
            while ((thisLine = myInput.readLine()) != null) {
                if (!thisLine.isEmpty()) {
                    String[] split = thisLine.split("\\|");
                    String ID = split[0];
                    String name = split[1];
                    String addr = split[2];
                    String phone = split[3];
                    String status = split[4];
                    Dealer dl = new Dealer(ID, name, addr, phone, status);
                    this.add(dl);
                }
            }
            myInput.close();

        } catch (Exception ex) {
            System.out.println("Can't read data!");
        }
        return true;
    }

    public void saveToFile(String filePath) throws Exception {
        Config cg = new Config();
        Properties properties = cg.readFileProperties();
        String filename = properties.getProperty(filePath);
        File f;
        FileOutputStream file;
        BufferedWriter myOutput;
        try {
            f = new File(filename);
            String fullPath = f.getAbsolutePath();
            file = new FileOutputStream(fullPath);
            myOutput = new BufferedWriter(new OutputStreamWriter(file));
            for (int i = 0; i < this.size(); i++) {
                if (i > 0) {
                    myOutput.newLine();
                }
                myOutput.write(this.get(i).outputString());
            }
            myOutput.close();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void addDealer() {
        String ID, name, addr, status, phone;
        String idPattern = "D\\d{3}";
        String phonePattern = ("\\d{9}|\\d{11}");
        while (true) {
            ID = MyTools.checkStringNotBlank("Input ID: ");
            int checkId = searchID(ID);
            if ((checkId == -1) && (ID.matches(idPattern))) {
                break;
            } else if (ID.isEmpty()) {
                System.out.println("ID can't be blank!");
            } else if (!ID.matches(idPattern)) {
                System.out.println("Please enter right format the ID Ex: D000");
            } else {
                System.out.println("Duplicate ID. Try with anther one!");
            }
        }
        name = MyTools.checkStringNotBlank("Input name: ");
        addr = MyTools.checkStringNotBlank("Input address: ");
        phone = MyTools.checkStringWithPatter("Input phone number: ", phonePattern);
        status = MyTools.checkStringNotBlank("Input status: ");
        this.add(new Dealer(ID, name, addr, phone, status));
        System.out.println("\nThe new Dealer has been added successfully!!");
    }

    public void searchDealerByID() {

        if (this.isEmpty()) {
            System.out.print("Dealer list is empty\n");
            return;
        }
        System.out.print("Input Name want to search: ");
        String inputName = sc.nextLine();
        int count = 0;
        for (Dealer dl : this) {
            if (dl.getName().equalsIgnoreCase(inputName)) {
                if (count == 0) {
                    System.out.printf("%-10s|%-35s|%-17s|%-15s|%-6s\n", "ID", " Name", "Address", "Phone", "Status");
                }
                dl.print();
                count++;
            }
        }
        if (count == 0) {
            System.out.printf("No Dealer has Name: %s\n", inputName);
        }
    }

    public void removeDealerById() {
        if (this.isEmpty()) {
            System.out.print("Dealer list is empty\n");
            return;
        }
        System.out.print("Enter ID want to remove: ");
        String input = sc.nextLine();
        int pos = searchID(input);
        if (pos == -1) {
            System.out.println("Not Found");
        } else {
            this.remove(pos);
            System.out.println("\nRemove successful!");
        }
    }

    public int searchID(String ID) {
        for (int i = 0; i < this.size(); i++) {
            if ((this.get(i).getID()).equals(ID)) return i;
        }
        return -1;
    }

    public void updateDealerById() {
        String ID, name, addr, phone, status;
        String phonePattern = ("\\d{9}|\\d{11}");
        while (true) {
            System.out.print("Input dealer id to update: ");
            ID = sc.nextLine();
            int Update = this.searchID(ID);
            if (Update != -1) {
                while (true) {
                    System.out.print("Input name: ");
                    name = sc.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("Name can't be blank!");
                    } else break;
                }

                while (true) {
                    System.out.print("Input address: ");
                    addr = sc.nextLine();
                    if (addr.isEmpty()) {
                        System.out.println("Address can't be blank!");
                    } else break;
                }

                while (true) {
                    System.out.print("Input phone number: ");
                    phone = sc.nextLine();
                    if (phone.matches(phonePattern)) {
                        break;
                    } else if (phone.isEmpty()) {
                        System.out.println("Phone number can't be empty!");
                    } else System.out.println("Please enter right format the phone number Ex: 9-11 number");

                }
                status = MyTools.checkStringNotBlank("Input status: ");
                this.get(Update).setName(name);
                this.get(Update).setAddr(addr);
                this.get(Update).setPhone(phone);
                this.get(Update).setStatus(status);
                break;
            } else {
                System.out.println("ID not Found!");
            }
        }
    }

    public void printAllDealer() {
        if (this.isEmpty()) {
            System.out.print("Dealer list is empty\n");
            return;
        }
        System.out.printf("%-10s|%-35s|%-17s|%-15s|%-6s\n", "ID", " Name", "Address", "Phone", "Status");
        for (Dealer dl : this) {
            dl.print();
        }
    }

}
