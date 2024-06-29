/* Class for a phone */
package ex01_2;
public class Phone implements Comparable <Phone>{
    String code;      // ex: P01
    String manufacter; // Ex: Samsung
    String technique;  // ex: 3G
    int price;         // ex: 100
    
    @Override
    // Comparing 2 phones based on their codes. Ex: P01<P02
    public int compareTo(Phone o) {
        // Your code
        return 0;
    }
    // Constructor for searching a phone in a phone list based on it's code
    public Phone (String code){
        // Code yourself
    }
    // Constructor for intitializing a specific phone
    public Phone (String code, String manu, String tech, int price){
        // Code yourself
    }

    @Override
    // Convert the phone to string
    public String toString() {
        return ""; // Code your self
    }
}
