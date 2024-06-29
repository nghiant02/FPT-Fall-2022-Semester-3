/* Interface for a list*/
package ex01_1;
public interface I_List {
   public void addItem(Object obj);// thêm vào cuối ds một phần tử
   public Object searchItem(String id); // tìm một phần tử
   public Object removeItem(String id); // xóa một phần tử
   public void printOrderedList(); // xuất ds có thứ tự.
}
