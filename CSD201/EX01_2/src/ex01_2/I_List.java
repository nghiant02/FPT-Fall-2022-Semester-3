/* Interface for managing a list*/
package ex01_2;
public interface I_List <E> {
    public void addItem(E item); // add new item to the end of a list
    E searchItem(E item); // search an item
    public boolean removeItem(E item); // remove an item
    public void printOrderedList(); // print the list in ascending order
}
