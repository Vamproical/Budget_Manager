package budget;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Account {
    private double balance;
    private final Map<Category, List<Purchase>> purchases;

    public Account() {
        purchases = new HashMap<>();
        for (var c : Category.values()) {
            purchases.put(c, new ArrayList<>());
        }
    }

    public Map<Category, List<Purchase>> getPurchases() {
        return purchases;
    }

    public List<Purchase> getPurchasesByCategory(Category category) {
        return purchases.getOrDefault(category, Collections.emptyList());
    }

    public boolean addPurchase(Purchase purchase) {
        if (Objects.isNull(purchase) || balance < purchase.getPrice()) {
            return false;
        }
        purchases.get(purchase.getCategory()).add(purchase);
        setBalance(balance - purchase.getPrice());
        return true;
    }

    public void addPurchaseFromFile(Purchase purchase) {
        purchases.get(purchase.getCategory()).add(purchase);
    }

    public void showAllPurchases() {
        double total = 0.0d;

        for (Map.Entry<Category, List<Purchase>> entry : purchases.entrySet()) {
            for (Purchase p : entry.getValue()) {
                System.out.format("%s $%.2f\n", p.getNameProduct(), p.getPrice());
                total += p.getPrice();
            }
        }
        System.out.format("Total sum: $%.2f\n\n", total);
    }

    public void showPurchaseByCategory(Category category) {
        List<Purchase> purchase = purchases.get(category);

        System.out.println("\n" + category.getType() + ":");
        if (purchase.isEmpty()) {
            System.out.println("Purchase list is empty!\n");
        } else {
            double total = 0.0d;
            for (Purchase p : purchase) {
                System.out.format("%s $%.2f\n", p.getNameProduct(), p.getPrice());
                total += p.getPrice();
            }
            System.out.format("Total sum: $%.2f\n\n", total);
        }
    }

    public void writeAllPurchase() {
        File file = new File("purchases.txt");
        try (PrintWriter printWriter = new PrintWriter(file)) {
            String toSave = String.format("Income %s", balance);
            printWriter.println(toSave);
            for (Map.Entry<Category, List<Purchase>> entry : purchases.entrySet()) {
                for (Purchase p : entry.getValue()) {
                    printWriter.printf("%s %s $%.2f\n", entry.getKey(), p.getNameProduct(), p.getPrice());
                }
            }
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean addIncome(double income) {
        balance += (income < 0.0) ? 0 : income;
        return true;
    }

    public void showBalance() {
        System.out.format("%s$%.2f\n", "Balance: ", balance);
    }
}
