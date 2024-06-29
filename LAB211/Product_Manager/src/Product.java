import java.util.Comparator;

public class Product implements Comparable<Product>{
    private String ProductID, ProductName, Status;
    private int UnitPrice, Quantity;

    public Product() {
    }

    public Product(String productID, String productName, int unitPrice, int quantity, String status) {
        ProductID = productID;
        ProductName = productName;
        Status = status;
        UnitPrice = unitPrice;
        Quantity = quantity;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void print() {
        System.out.printf("%-7s|%-20s|%-15s|%-12s|%-6s\n", ProductID, ProductName, UnitPrice, Quantity, Status);
    }

    public String toString() {
        return ProductID + "," + ProductName + "," + UnitPrice + "," + Quantity + "," + Status;
    }

//    @Override
//    public int compareTo(Product a) {
//        int quantity1 = a.getQuantity();
//            int quantity2 = b.getQuantity();
//            int price1 = a.getUnitPrice();
//            int price2 = b.getUnitPrice();
//            if (Integer.compare(quantity1, quantity2) == 0) {
//                return Integer.compare(price1, price2);
//            }
//            return Integer.compare(quantity1, quantity2);
//    }


//        public int compare(Product a, Product b) {
//            int quantity1 = a.getQuantity();
//            int quantity2 = b.getQuantity();
//            int price1 = a.getUnitPrice();
//            int price2 = b.getUnitPrice();
//            if (Integer.compare(quantity1, quantity2) == 0) {
//                return Integer.compare(price1, price2);
//            }
//            return Integer.compare(quantity1, quantity2);
//        }


    @Override
    public int compareTo(Product p) {
        int a;
        a = p.getQuantity() - this.getQuantity();
        if (a != 0) {
            return a;
        }
        return p.getUnitPrice() - this.getUnitPrice();
    }
}


