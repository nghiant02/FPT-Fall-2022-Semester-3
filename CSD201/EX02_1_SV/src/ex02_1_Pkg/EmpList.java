/* Class for a list of employees */
package ex02_1_Pkg;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Iterator;
public class EmpList extends TreeSet<Employee> implements I_List {
    public static Scanner sc = new Scanner(System.in);
    public EmpList() {
       super();
    }
    
    @Override
    /* Add new item, data will be input from keyboard 
       Input format:
    Code:E001
    Name:Michel
    Salary:500
    Attention: Employee code anf name must be converted to uppercase
    */
    public void addItem() {       
        /* Your code */
    }
    @Override
    /* Search an employee based on employee's code
       Employee's code will be input from keyboard
       Input format: Searched code:E001
       If the data is not found, the string "This employee does not exist!",
       Else, data of the item is printed out.
    */
    public void searchItem() {
        /* Your code */
    }
    @Override
    /* Remove an item, data will be input from keyboard
    Input format: Removed code:E001
       If the item is not found, 
             the string "This employee does not exist!" is printede out;
       Else, the string "This employee has been removed." is printed out.
    */
    public void removeItem() {
        /* Your code */
    }
    @Override
    /* Print the list in ascending order
       If the list is empty, the string "Empty list." is printed out,
       Else, all items are printed out line-by-line. 
    */
    public void printAscendingOrder(){
        /* Your code */ 
    }
    /* Print the list in descending order
       If the list is empty, the string "Empty list." is printed out,
       Else, all items are printed out line-by-line. 
    */
    @Override
    public void printDescendingOrder(){
        /* Your code */ 
    }
} // EmpList class



