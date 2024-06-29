/* Class for an employee*/
package ex01_1;
public class Employee implements Comparable {
    String code="";
    String name="";
    int salary=0;    

    public Employee(String code, String name, int salary) {
    }
    
    @Override
    public int compareTo(Object o) {
        return -1;
    }
}
