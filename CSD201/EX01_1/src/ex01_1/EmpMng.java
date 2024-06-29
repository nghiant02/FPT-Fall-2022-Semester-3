package ex01_1;
public class EmpMng {
    public static void main(String[] args) {
        EmpList list = new EmpList(); // khoi tao danh sach
        // them 5 employees
        list.addItem(new Employee("E005", "ABC", 123));
        list.addItem(new Employee("E002", "DEF", 150));
        list.addItem(new Employee("E001", "GHI", 145));
        list.addItem(new Employee("E004", "JKL", 210));
        list.addItem(new Employee("E007", "MNP", 576));
        // tim nhan vien
        if (list.searchItem("E009")!=null) System.out.println("Existed\n");
        else System.out.println("Not Existed\n");
        // xoa 1 nhan vien
        list.removeItem("E004");
        // xuat ds
        list.printOrderedList();
    }
}
