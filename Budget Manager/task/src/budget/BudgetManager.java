package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class BudgetManager {
    private final Scanner scanner = new Scanner(System.in);
    private double totalCost = 0;
    private double balance = 0;
    private List<String> purchases = new ArrayList<>();

    private void printMenu() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("0) Exit");
    }

    public void menu() {
        boolean flag = false;
        while (!flag) {
            printMenu();
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    System.out.println();
                    System.out.println("Enter income:");
                    double income = Double.parseDouble(scanner.nextLine());
                    balance += income;
                    System.out.println("Income was added");
                    System.out.println();
                    break;
                case "2":
                    System.out.println();
                    System.out.println("Enter purchase name:");
                    String purchase = scanner.nextLine();
                    System.out.println("Enter its price:");
                    double price = Double.parseDouble(scanner.nextLine());
                    purchases.add(purchase + " $" + price);
                    balance -= price;
                    System.out.println("Purchase was added!");
                    System.out.println();
                    break;
                case "3":
                    System.out.println();
                    if (purchases.isEmpty()) {
                        System.out.println("Purchase list is empty");
                    }
                    else {
                        for (String str: purchases) {
                            System.out.println(str);
                            totalCost += Double.parseDouble(str.substring(str.lastIndexOf("$") + 1));
                        }
                        System.out.println("Total sum: $" + totalCost);
                    }
                    System.out.println();
                    break;
                case "4":
                    System.out.println();
                    System.out.printf("Balance: $%.2f\n",balance);
                    System.out.println();
                    break;
                case "0":
                    System.out.println();
                    System.out.println("Bye!");
                    flag = true;
                    break;
                default:
                    System.out.println("Incorrect option! Please try again!");
                    break;
            }
        }
    }
}
