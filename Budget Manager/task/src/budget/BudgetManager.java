package budget;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class BudgetManager {
    private final Scanner scanner = new Scanner(System.in);
    private Account account = new Account();

    public void menu() {
        boolean flag = false;
        while (!flag) {
            Menu.printMenu();
            String action = scanner.nextLine();
            System.out.println();
            switch (action) {
                case "1":
                    System.out.println("Enter income:");
                    account.addIncome(scanner.nextDouble());
                    scanner.nextLine();
                    System.out.println("Income was added");
                    break;
                case "2":
                    addPurchase();
                    break;
                case "3":
                    int counter = 0;
                    Collection<List<Purchase>> allProducts = account.getPurchases().values();
                    for (List<Purchase> productList : allProducts) {
                        if (productList.size() == 0) {
                            counter++;
                        }
                    }
                    if (counter == allProducts.size()) {
                        System.out.println("Purchase list is empty");
                        break;
                    } else {
                        printPurchases();
                    }
                    break;
                case "4":
                    account.showBalance();
                    break;
                case "5":
                    account.writeAllPurchase();
                    System.out.println("Purchases were saved!");
                    break;
                case "6":
                    CreateAccountFromFile createAccountFromFile = new CreateAccountFromFile();
                    account = createAccountFromFile.getAccount();
                    System.out.println("Purchases were loaded!");
                    break;
                case "0":
                    System.out.println("Bye!");
                    flag = true;
                    break;
                default:
                    System.out.println("Incorrect option! Please try again!");
                    break;
            }
            System.out.println();
        }
    }

    private void addPurchase() {
        boolean flag = false;
        while (!flag) {
            Menu.printMenuPurchases();
            System.out.println();
            String action = scanner.nextLine();
            if (Integer.parseInt(action) == 5) {
                flag = true;
                continue;
            }
            System.out.println("Enter purchase name:");
            String purchaseName = scanner.nextLine();
            System.out.println("Enter its price:");
            double purchasePrice = Double.parseDouble(scanner.nextLine());
            if (account.addPurchase(new Purchase(
                    Category.values()[Integer.parseInt(action) - 1], purchaseName, purchasePrice))) {
                System.out.println("Purchase was added!");
                System.out.println();
            } else {
                System.out.println("Error! Cannot added the item!");
            }
        }
    }

    private void printPurchases() {
        boolean flag = false;
        while (!flag) {
            Menu.printMenuPrintPurchases();
            String action = scanner.nextLine();
            int category = Integer.parseInt(action);
            if (category == 6) {
                flag = true;
                continue;
            }
            if (category == 5) {
                System.out.println("\n" + "All: ");
                account.showAllPurchases();
            } else {
                account.showPurchaseByCategory(Category.values()[category - 1]);
            }
        }
    }
}
