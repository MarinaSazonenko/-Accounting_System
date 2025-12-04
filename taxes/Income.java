package taxes;

public class Income extends TaxSystem {

    @Override
    public int calcTaxFor(int debit, int credit) {
super.calcTaxFor(debit, credit);
        int result = debit * 6 / 100;
        if (result >= 0) {
            return result;
        } else {
            return 0;
        }
    }
}
