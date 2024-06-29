package ex02_1_Pkg;
public class EmpMng {
    public static void main(String[] args) {
        EmpList list = new EmpList(); // khoi tao danh sach
        // Print the list in descending order
        list.printDescendingOrder();
        System.out.println();
        // Add 5 employees
        System.out.println("Add 5 employees.");
        for (int i= 1; i<=5; i++) {
            System.out.println("Adding the employee " + i + ":");
            list.addItem();
        }
        System.out.println();
        System.out.println();
        System.out.println("Test search operations:");
        // Search an employee. Case 1: Data does not exist.
        list.searchItem();
        // Search an employee. Case 2: Data existed.
        list.searchItem();
        System.out.println();
        // Print the list in ascending order
        System.out.println("The list in ascending order:");
        list.printAscendingOrder();
        // Print the list in descending order
        System.out.println();
        System.out.println("The list in descending order:");
        list.printDescendingOrder();
    }
}
