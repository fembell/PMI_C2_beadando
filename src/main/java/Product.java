public class Product {
    private String name;
    private String category;
    private Integer price;
    private Integer quantity;

    /**
     * Creation of a new product.
     * @param name
     * @param category
     * @param price
     * @param quantity
     */
    public Product(String name, String category, Integer price, Integer quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Overrides parameters of current product.
     * @param name
     * @param category
     * @param price
     * @param quantity
     */
    public void updateProduct(String name, String category, Integer price, Integer quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the parameters of current product.
     * @return Object[]
     */
    public Object[] getProductData() {
        return new Object[]{this.name, this.category, this.price, this.quantity};
    }

    /**
     * Returns the name of current product.
     * @return String
     */
    public String getName() {
        return this.name;
    }
}
