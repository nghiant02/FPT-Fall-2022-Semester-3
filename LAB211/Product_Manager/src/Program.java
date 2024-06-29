import java.util.Collections;

public class Program {
    public static void main(String[] args) throws Exception {
        ProductList list = new ProductList();
        list.readFormFile("Product.dat");
        String[] options = {"Create a product", "Check exits Product", "Search Product", "Update product", "Delete Product", "Save product to file", "Print list Products from the file", "Quit"};
        int choice;
        do {
            System.out.println("------------Product manager------------");
            choice = menu.getChoice(options);
            switch (choice) {
                case 1:
                    list.addProduct();
                    break;
                case 2:
                    list.checkExist();
                    break;
                case 3:
                    list.searchProductByName();
                    break;
                case 4:
                    list.updateProductByID();
                    break;
                case 5:
                    list.removeProductByID();
                    break;
                case 6:
                    list.saveFormFile("Product.dat");
                    System.out.println("Save successfully!");
                    break;
                case 7:
                    list.printProduct();
                    break;
            }
        } while (choice > 0 && choice < 8);
    }
}
