/* Class for a phone list */
package ex01_2;
import java.util.LinkedList;
import java.util.Collections;
public class PhoneList extends LinkedList<Phone> 
                       implements I_List<Phone>{

    @Override
    //Add item to the emnd of the list. Code yourself
    public void addItem(Phone item) {
       // Your code
    }
    @Override
    //Search a phone, return the phone found. Code yourself
    public Phone searchItem(Phone item) {
        return null; // Code yourself   
    }

    @Override
    // Remove a phone based on it's code
    public boolean removeItem(Phone item) {
        // code yourself
        return true;
    }

    @Override
    // Print the list in ascending order of phone codes
    public void printOrderedList() {
        Collections.sort(this);
        // Code yourself
    }
}
