import java.util.ArrayList;
import java.util.Objects;

public class Inventory {
    public static ArrayList<Product> products = new ArrayList<>();

    public static ArrayList<Product> getList(){
        return products;
    }

    public static void addProduct(String name, String category, Integer price, Integer quantity) {
        Product p = new Product(name, category, price, quantity);
        products.add(p);
    }

    public static int getProductId(String name) {
        for (int i = 0; i < products.size(); i++) {
            if(Objects.equals(products.get(i).getName(), name)) {
                return i;
            }
        }
        return -1;
    }

    public static void updateProduct(String name, Product newProduct) {
        products.set(getProductId(name), newProduct);
    }

    public Object[] getProductData(String name) {
        int id = getProductId(name);
        return products.get(id).getProductData();
    }

    public static void removeProduct(String name) {
        int id = getProductId(name);
        products.remove(id);
    }

    public void printAllProducts() {
        for (int i = 0; i < products.size(); i++) {

        }
    }


}
