import java.io.*;
import java.util.*;

public class ProductList extends ArrayList<Product> {
    public void readFormFile(String fileName) throws Exception {
        String thisLine;
        BufferedReader myInput;
        File f = new File(fileName);
        String fullPath = f.getAbsolutePath();
        FileInputStream file = new FileInputStream(fullPath);
        myInput = new BufferedReader(new InputStreamReader(file));
        while ((thisLine = myInput.readLine()) != null) {
            if (!thisLine.isEmpty()) {
                String[] split = thisLine.split(",");
                String productId = split[0];
                String productName = split[1];
                int unitPrice = Integer.parseInt(split[2]);
                int quantity = Integer.parseInt(split[3]);
                String status = split[4];
                Product product = new Product(productId, productName, unitPrice, quantity, status);
                this.add(product);
            }
        }
        myInput.close();
    }

    public void saveFormFile(String fileName) throws Exception {
        File f = new File(fileName);
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        f = new File(fileName);
        String fullPath = f.getAbsolutePath();
        fileOutputStream = new FileOutputStream(fullPath);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        for (int i = 0; i < this.size(); i++) {
            if (i > 0) {
                bufferedWriter.newLine();
            }
            bufferedWriter.write(this.get(i).toString());
        }
        bufferedWriter.close();
    }

    public int searchProductID(String _ProductID) {
        for (int i = 0; i < this.size(); i++) {
            if ((this.get(i).getProductID()).equals(_ProductID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchProductName(String _ProductName) {
        for (int i = 0; i < this.size(); i++) {
            if ((this.get(i).getProductName()).equals(_ProductName)) {
                return i;
            }
        }
        return -1;
    }

    public void printProduct() {
        Collections.sort(this );
        do {
            if (this.isEmpty()) {
                System.out.print("Product list is empty!\n");
                return;
            }
            System.out.printf("%-7s|%-20s|%-15s|%-12s|%-6s\n", "ID", "Product Name", "Unit Price", "Quantity", "Status");
            for (Product product : this) {
                product.print();
            }
            boolean check = MyTools.CheckYesNo("Back to menu: ");
            if (!check) return;
        } while (true);
    }

    public void addProduct() {
        do {
            String ProductID, ProductName, Status;
            int UnitPrice, Quantity;
            ProductID = MyTools.CheckStringNotBlank("Product ID: ");
            while (true) {
                ProductName = MyTools.checkName("Product Name: ");
                int CheckName = searchProductName(ProductName);
                if (CheckName == -1) {
                    break;
                } else System.out.println("Duplicated name. Try again!!");
            }
            UnitPrice = MyTools.checkInt("Unit Price: ", "Price must form 0 to 10000", 0, 10000);
            Quantity = MyTools.checkInt("Quantity: ", "Quantity must form 0 to 1000", 0, 1000);
            Status = MyTools.CheckAvailable("Status(yes/no):");
            //Add in arrayList
            this.add(new Product(ProductID, ProductName, UnitPrice, Quantity, Status));
            System.out.println("The new product has been added successfully!!");
            boolean check = MyTools.CheckYesNo("Back to menu: ");
            if (!check) return;
        } while (true);
    }

    public void searchProductByName() {
        do {
            if (this.isEmpty()) {
                System.out.print("List is empty!");
                return;
            }
            String _productName = MyTools.checkName("Enter name to search: ");
            int pos = searchProductName(_productName);
            int count = 0;
            if (pos == -1) {
                System.out.println("Product not found!");
            } else {
                for (Product product : this) {
                    if (product.getProductName().equals(_productName)) {
                        System.out.printf("%-7s|%-20s|%-15s|%-12s|%-6s\n", "ID", "Product Name", "Unit Price", "Quantity", "Status");
                        product.print();
                    }
                }
            }
            boolean check = MyTools.CheckYesNo("Back to menu: ");
            if (!check) return;
        } while (true);
    }

    public void checkExist() {
        do {
            if (this.isEmpty()) {
                System.out.println("List is empty!!");
                return;
            }
            String _productName = MyTools.checkName("Enter Product name to check: ");
            int pos = searchProductName(_productName);
            if (pos == -1) {
                System.out.println("Not Found!");
            } else System.out.println("Product Exit!");
            boolean check = MyTools.CheckYesNo("Back to menu: ");
            if (!check) return;
        } while (true);
    }

    public void removeProductByID() {
        do {
            if (this.isEmpty()) {
                System.out.println("List is empty!");
                return;
            }
            String _productID = MyTools.CheckStringNotBlank("Enter Product ID want to remove: ");
            int pos = searchProductID(_productID);
            if (pos == -1) {
                System.out.println("Product name does not exist!");
            } else {
                this.remove(pos);
                System.out.println("\nRemove successful!");
            }
            boolean check = MyTools.CheckYesNo("Back to menu: ");
            if (!check) return;
        } while (true);
    }

    public void updateProductByID() {
        do {
            if (this.isEmpty()) {
                System.out.print("List is empty!");
            }
            String _productID = MyTools.CheckStringNotBlank("Enter productID want to update: ");
            int pos = searchProductID(_productID);
            if (pos == -1) {
                System.out.println("Product name does not exist!");
            } else {
                String _productName = MyTools.checkName("Enter product name: ");
                int _unitPrice = MyTools.checkInt("Unit Price: ", "Price must form 0 to 10000", 0, 10000);
                int _quantity = MyTools.checkInt("Quantity: ", "Quantity must form 0 to 1000", 0, 1000);
                String _status = MyTools.CheckAvailable("Status(yes/no): ");
                this.get(pos).setProductName(_productName);
                this.get(pos).setUnitPrice(_unitPrice);
                this.get(pos).setQuantity(_quantity);
                this.get(pos).setStatus(_status);
            }
            boolean check = MyTools.CheckYesNo("Back to menu: ");
            if (!check) return;
        } while (true);
    }
}
