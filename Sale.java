public class Sale extends Deal {
    public Sale(String nameProduct, int priceProduct) {
        super("Продажа " + nameProduct + " на " + priceProduct + " руб.", 0, priceProduct);
    }
}
