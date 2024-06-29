package ex01_2;
/* Program for managing phones */
public class PhoneMng {   
    public static void main(String[] args) {
        PhoneList pList = new PhoneList();
        pList.addItem(new Phone("P01", "Samsung A1", "3G", 100));
        pList.addItem(new Phone("P05", "Nokia L6", "3G", 30));
        pList.addItem(new Phone("P03", "Samsung A3", "3G", 60));
        pList.addItem(new Phone ("P04", "Samsung S8", "4G", 130));
        pList.addItem(new Phone ("P02", "Sony T1", "3G", 110));
        System.out.println("\nPhone Manager\n");
        System.out.println("Phone List:");
        pList.printOrderedList();
        String code = "P07";
        Phone p = new Phone(code);
        System.out.print("\nSearch " + code + " phone:" );
        if (pList.searchItem(p)==null)
            System.out.println("Not existed!\n" );
        else System.out.println("Existed!\n" );
        code = "P03";
        p = new Phone(code);
        System.out.print("Remove " + code + " phone:" );
        if (pList.remove(p))
            System.out.println("Done.\n" );
        else System.out.println("Not Existed!\n" );
        System.out.println("Phone List:\n");
        pList.printOrderedList();
    }
}
