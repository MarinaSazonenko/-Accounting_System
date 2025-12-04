import taxes.TaxSystem;
import taxes.Income;
import taxes.IncomeMinusExpenses;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ СИСТЕМЫ НАЛОГООБЛОЖЕНИЯ ===\n");

        // 1. Тест базовой функциональности
        System.out.println("1. БАЗОВАЯ ФУНКЦИОНАЛЬНОСТЬ");
        Company company = new Company("ООО Тест", new TaxSystem());

        company.shiftMoney(100000);
        company.shiftMoney(-30000);
        company.payTaxes();

        // 2. Тест УСН Доходы
        System.out.println("\n2. УСН ДОХОДЫ (6%)");
        company.setTaxSystem(new Income());
        company.shiftMoney(50000);
        company.shiftMoney(-10000);
        company.payTaxes();

        // 3. Тест УСН Доходы-Расходы
        System.out.println("\n3. УСН ДОХОДЫ-РАСХОДЫ (15%)");
        company.setTaxSystem(new IncomeMinusExpenses());
        company.shiftMoney(80000);
        company.shiftMoney(-20000);
        company.payTaxes();

        // 4. Тест отрицательного налога
        System.out.println("\n4. ТЕСТ ОТРИЦАТЕЛЬНОГО НАЛОГА");
        company.shiftMoney(-50000);
        company.shiftMoney(-30000);
        company.payTaxes();

        // 5. Тест сделок
        System.out.println("\n5. ТЕСТ СДЕЛОК");
        Deal[] deals = {
                new Sale("Ноутбук", 50000),
                new Expenditure("Канцтовары", 10000),
                new Sale("Телефон", 30000),
                new Expenditure("Реклама", 15000)
        };

        company.shiftMoney(100000);
        company.shiftMoney(-30000);

        System.out.println("До применения сделок:");
        System.out.println("Доходы: " + company.getDebit() + " руб., Расходы: " + company.getCredit() + " руб.");

        int startDifference = company.applyDeals(deals);
        System.out.println("Разница на момент старта: " + startDifference + " руб.");
        System.out.println("После applyDeals - Доходы: " + company.getDebit() + " руб., Расходы: " + company.getCredit() + " руб.");

        // 6. Тест с разными системами налогообложения
        System.out.println("\n6. СРАВНЕНИЕ СИСТЕМ НА ОДИНАКОВЫХ ДАННЫХ");

        int testDebit = 1000000;
        int testCredit = 400000;

        TaxSystem usnIncome = new Income();
        TaxSystem usnIncomeExpenses = new IncomeMinusExpenses();

        System.out.println("Данные: доходы = " + testDebit + " руб., расходы = " + testCredit + " руб.");
        System.out.println("УСН Доходы: " + usnIncome.calcTaxFor(testDebit, testCredit) + " руб.");
        System.out.println("УСН Доходы-Расходы: " + usnIncomeExpenses.calcTaxFor(testDebit, testCredit) + " руб.");

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }
}