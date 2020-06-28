package budget.Analyze;

import budget.Account;
import budget.Category;
import budget.Purchase;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortByType implements SortingType {
    @Override
    public void sort(Map<Category, List<Purchase>> purchases) {
        Map<Category, Double> type = new LinkedHashMap<>();
        for (Category category : purchases.keySet()) {
            List<Purchase> purchase = purchases.get(category);
            if (!purchase.isEmpty()) {
                double total = 0.0d;
                for (Purchase p : purchase) {
                    total += p.getPrice();
                }
                type.put(category, total);
            }
        }
        printType(type);
    }

    @Override
    public List<Purchase> sort(List<Purchase> purchases) {
        return null;
    }

    private void printType(Map<Category, Double> type) {
        System.out.println();
        System.out.println("Types:");
        double total = 0.0d;
        List<Map.Entry<Category, Double>> list = new ArrayList<>(type.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (int i = list.size() - 1; i >= 0; i--) {
            String typeCategory = list.get(i).getKey().getType();
            double price = list.get(i).getValue();
            System.out.printf("%s - $%.2f\n", typeCategory, price);
            total += price;
        }
        System.out.println("Total sum: $" + total);
        System.out.println();
    }

    public void init(Account account) {
        sort(account.getPurchases());
    }
}
