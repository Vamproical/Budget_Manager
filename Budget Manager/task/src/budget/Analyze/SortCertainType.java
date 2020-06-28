package budget.Analyze;

import budget.Account;
import budget.Category;
import budget.Menu;
import budget.Purchase;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SortCertainType implements SortingType {
    private Category chooseType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        Menu.printMenuPurchasesCertain();
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                return Category.FOOD;
            case 2:
                return Category.CLOTHES;
            case 3:
                return Category.ENTERTAINMENT;
            default:
                return Category.OTHER;
        }
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

    public void init(Account account) {
        Category category = chooseType();
        List<Purchase> purchase = account.getPurchases().get(category);
        System.out.println("\n" + category.getType() + ":");
        if (purchase.isEmpty()) {
            System.out.println("Purchase list is empty!\n");
        } else {
            List<Purchase> result = sort(purchase);
            double total = 0.0d;
            for (Purchase p : result) {
                System.out.format("%s $%.2f\n", p.getNameProduct(), p.getPrice());
                total += p.getPrice();
            }
            System.out.format("Total sum: $%.2f\n\n", total);
        }
    }

    @Override
    public void sort(Map<Category, List<Purchase>> purchases) {
    }
}
