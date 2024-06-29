/* Interface for a list.
   Data in each operation will be input from keyboard
*/
package ex02_1_Pkg;
public interface I_List {
   public void addItem();// Add new item
   public void searchItem(); // Search an item
   public void removeItem(); // Remove an item
   public void printAscendingOrder(); // print the list in ascending order
   public void printDescendingOrder(); // print the list in descending order
}
