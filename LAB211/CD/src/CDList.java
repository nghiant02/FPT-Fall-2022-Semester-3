import java.io.*;
import java.util.*;

public class CDList extends ArrayList<CD> {
    Scanner sc = new Scanner(System.in);
    int count = 0;

    public void readFormFile(String fileName) throws Exception {
        String thisLine;
        BufferedReader myInput;
        File f = new File(fileName);
        String fullPath = f.getAbsolutePath();
        FileInputStream file = new FileInputStream(fullPath);
        myInput = new BufferedReader(new InputStreamReader(file));
        while ((thisLine = myInput.readLine()) != null) {
            if (!thisLine.isEmpty()) {
                String[] split = thisLine.split(",");
                String CDID = split[0];
                String CDName = split[1];
                String CDType = split[2];
                String CDtitle = split[3];
                double unitprice = Double.parseDouble(split[4]);
                String publishingyear = split[5];
                CD cd = new CD(CDID, CDName, CDType, CDtitle, unitprice, publishingyear);
                this.add(cd);
            }
        }
        myInput.close();
    }

    public void saveFormFile(String fileName) throws Exception {
        File f = new File(fileName);
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        f = new File(fileName);
        String fullPath = f.getAbsolutePath();
        fileOutputStream = new FileOutputStream(fullPath);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        for (int i = 0; i < this.size(); i++) {
            if (i > 0) {
                bufferedWriter.newLine();
            }
            bufferedWriter.write(this.get(i).toString());
        }
        bufferedWriter.close();
    }


    public void addCD() {
        System.out.println("The list has " + this.size() + " elements.");
        int size = this.size();
        System.out.println(size);
        if (size > 3) {
            System.out.println("UNABLE TO ADD CD ! ");
        } else {
            String CDName, CDType, CDtitle, CDID, PublishingYear;
            double unitprice;
            CDName = Validator.getString1("Enter a name of CD : ", "(game|movie|music)", "MUST BE ENTER GAME/MOVIE/MUSIC");
            CDType = Validator.getString1("Enter type of CD : ", "(audio|video)", "MUST BE ENTER AUDIO/VIDEO");
            CDtitle = Validator.getString("Enter title of CD : ");
            unitprice = Validator.getDouble("Enter price of CD : ", 0);
            CDID = Validator.getString("Enter ID of CD : ");
            PublishingYear = Validator.getString1("Enter year of publishing CD : ", "\\d{4}", "MUST BE 4 NUMBER !! ");
            this.add(new CD(CDID, CDName, CDType, CDtitle, unitprice, PublishingYear));
            System.out.println("The new CD has been added successfully!!");
            count++;
        }

    }

    public void displaycatalog() {

        System.out.println("");
        System.out.println("There are " + count + " CD in storage. ");
        System.out.printf("%-7s|%-15s|%-15s|%-12s|%-12s|%-6s\n", "CDID", "CDName", "CDType", "CDTitle", "UnitPrice", "PublishingYear");
        for (CD cd : this) {
            cd.print();
        }
    }

    public void updateCD() {
        do {
            if (this.isEmpty()) {
                System.out.print("List is empty!");
            }
            System.out.println("Enter CD ID want to update: ");
            String id = sc.nextLine();
            int pos = searchCDID(id);
            if (pos == -1) {
                System.out.println("CD name does not exist!");
            } else {
                System.out.println("CDName: ");
                String CDName = sc.nextLine();
                System.out.println("CDType: ");
                String CDType = sc.nextLine();
                System.out.println("CDTitle: ");
                String CDtitle = sc.nextLine();
                System.out.println("CDID: ");
                String CDID = sc.nextLine();
                System.out.println("UnitPrice: ");
                int unitprice = Integer.parseInt(sc.nextLine());
                System.out.println("PublishingYear: ");
                String PublishingYear = sc.nextLine();
                this.get(pos).setCDName(CDName);
                this.get(pos).setCDType(CDType);
                this.get(pos).setCDtitle(CDtitle);
                this.get(pos).setCDID(CDID);
                this.get(pos).setUnitPrice(unitprice);
                this.get(pos).setPublishingYear(PublishingYear);
                System.out.println("Updated successfully!! ");
            }

            boolean check = Validator.CheckYesNo("Back to menu (yes/no): ");
            if (!check) return;
        } while (true);

    }

    public void deleteCD() {
        do {
            if (this.isEmpty()) {
                System.out.println("List is empty!");
                return;
            }
            System.out.println("Enter CD ID want to remove: ");
            String id = sc.nextLine();
            int pos = searchCDID(id);
            if (pos == -1) {
                System.out.println("CD name does not exist!");
            } else {
                this.remove(pos);
                System.out.println("Remove successful!");
            }
            boolean check = Validator.CheckYesNo("Back to menu (yes/no): ");
            if (!check) return;
        } while (true);

    }

    public void searchCDbyCDtitle() {
        do {
            if (this.isEmpty()) {
                System.out.print("List is empty!! ");
                return;
            }
            System.out.println("Enter title to search: ");
            String title = sc.nextLine();
            int pos = searchCDTitle(title);
            int count = 0;
            if (pos == -1) {
                System.out.println("Product not found!");
            } else {
                for (CD cd : this) {
                    if (cd.getCDtitle().equals(title)) {
                        System.out.printf("CDName", "CDType", "CDTitle", "UnitPrice", "CDID", "PublishingYear");
                        cd.print();
                    }
                }
            }

        } while (true);

    }

    public int searchCDID(String CDID) {
        for (int i = 0; i < this.size(); i++) {
            if ((this.get(i).getCDID()).equals(CDID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchCDTitle(String CDTilte) {
        for (int i = 0; i < this.size(); i++) {
            if ((this.get(i).getCDtitle()).equals(CDTilte)) {
                return i;
            }
        }
        return -1;
    }

    public void printCD() {
        Collections.sort(this, new Comparator<CD>() {
            @Override
            public int compare(CD o1, CD o2) {
                return o1.getCDName().compareTo(o2.getCDName());
            }
        });
        do {
            if (this.isEmpty()) {
                System.out.print("CD list is empty!\n");
                return;
            }

            System.out.printf("%-7s|%-15s|%-15s|%-12s|%-12s|%-6s\n", "CDID", "CDName", "CDType", "CDTitle", "UnitPrice", "PublishingYear");
            for (CD cd : this) {
                cd.print();
            }
            boolean check = Validator.CheckYesNo("Back to menu (yes/no): ");
            if (!check) return;
        } while (true);
    }
}

