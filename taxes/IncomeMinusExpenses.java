package taxes;

public class IncomeMinusExpenses extends TaxSystem {

    @Override

    public int calcTaxFor(int debit, int credit) {
        super.calcTaxFor(debit, credit);
        int result = (debit - credit) * 15 / 100;
        if (result >= 0) {
            return result;
        } else {
            return 0;
        }
    }
}


