import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {
        CDList list = new CDList();
        list.readFormFile("Account.dat");
        String[] options = {"Add CD to the catalog", "Search CD by CD title", "Display the catalog", "Update CD", "Delete CD", "Save account to file", "Print list CDs from the file", "Quit"};
        int choice;
        do {
            System.out.println("------------Product manager------------");
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    list.addCD();
                    break;
                case 2:
                    list.searchCDbyCDtitle();
                    break;
                case 3:
                    list.displaycatalog();
                    break;
                case 4:
                    list.updateCD();
                    break;
                case 5:
                    list.deleteCD();
                    break;
                case 6:
                    list.saveFormFile("Account.dat");
                    System.out.println("Save successfully!");
                    break;
                case 7:
                    list.printCD();
                    break;
            }
        } while (choice > 0 && choice < 8);
    }
}
