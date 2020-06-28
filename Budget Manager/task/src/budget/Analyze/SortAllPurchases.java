package budget.Analyze;

import budget.Account;
import budget.Category;
import budget.Purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SortAllPurchases implements SortingType {
    @Override
    public void init(Account account) {
        System.out.println();
        System.out.println("All:");
        List<Purchase> allPurchases = new ArrayList<>();
        for (Map.Entry<Category, List<Purchase>> entry : account.getPurchases().entrySet()) {
            allPurchases.addAll(entry.getValue());
        }
        List<Purchase> result = sort(allPurchases);
        double total = 0.0d;
        for (Purchase p : result) {
            System.out.format("%s $%.2f\n", p.getNameProduct(), p.getPrice());
            total += p.getPrice();
        }
        System.out.format("Total: $%.2f\n\n", total);
    }

    @Override
    public void sort(Map<Category, List<Purchase>> purchases) {

    }

    @Override
    public List<Purchase> sort(List<Purchase> purchases) {
        for (int i = 0; i < purchases.size() - 1; i++) {
            for (int j = 0; j < purchases.size() - i - 1; j++) {
                double priceJ = purchases.get(j).getPrice();
                double priceJPlusOne = purchases.get(j + 1).getPrice();
                if (priceJ < priceJPlusOne) {
                    Purchase temp = purchases.get(j);
                    purchases.set(j, purchases.get(j + 1));
                    purchases.set(j + 1, temp);
                }
            }
        }
        return purchases;
    }
}
