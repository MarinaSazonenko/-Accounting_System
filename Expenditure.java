public class Expenditure extends Deal {
    public Expenditure(String nameProduct, int priceProduct) {
        super("Покупка " + nameProduct + " на " + priceProduct + " руб.", priceProduct, 0);
    }
}