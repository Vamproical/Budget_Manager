package budget;

public class Purchase {
    private final Category category;
    private final String nameProduct;
    private final double price;

    public Purchase(Category category, String nameProduct, double price) {
        this.category = category;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPrice() {
        return price;
    }
}
