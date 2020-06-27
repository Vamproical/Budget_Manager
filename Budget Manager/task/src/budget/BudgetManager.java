package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BudgetManager {
    private final Scanner scanner = new Scanner(System.in);
    private double totalCost = 0;
    private double balance = 0;
    private final List<String> purchasesFood = new ArrayList<>();
    private final List<String> purchasesClothes = new ArrayList<>();
    private final List<String> purchasesEntertainment = new ArrayList<>();
    private final List<String> purchasesOther = new ArrayList<>();

    private void printMenu() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("0) Exit");
    }

    private void printMenuPurchases() {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back");
    }

    private void printMenuPrintPurchases() {
        System.out.println("Choose the type of purchases");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) All");
        System.out.println("6) Back");
    }

    private void addPurchase() {
        boolean flag = false;
        while (!flag) {
            printMenuPurchases();
            System.out.println();
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    System.out.println();
                    System.out.println("Enter purchase name:");
                    String purchase = scanner.nextLine();
                    System.out.println("Enter its price:");
                    double price = Double.parseDouble(scanner.nextLine());
                    balance -= price;
                    System.out.println("Purchase was added!");
                    purchasesFood.add(purchase + " $" + price);
                    System.out.println();
                    break;
                case "2":
                    System.out.println();
                    System.out.println("Enter purchase name:");
                    purchase = scanner.nextLine();
                    System.out.println("Enter its price:");
                    price = Double.parseDouble(scanner.nextLine());
                    balance -= price;
                    System.out.println("Purchase was added!");
                    purchasesClothes.add(purchase + " $" + price);
                    System.out.println();
                    break;
                case "3":
                    System.out.println();
                    System.out.println("Enter purchase name:");
                    purchase = scanner.nextLine();
                    System.out.println("Enter its price:");
                    price = Double.parseDouble(scanner.nextLine());
                    balance -= price;
                    System.out.println("Purchase was added!");
                    purchasesEntertainment.add(purchase + " $" + price);
                    System.out.println();
                    break;
                case "4":
                    System.out.println();
                    System.out.println("Enter purchase name:");
                    purchase = scanner.nextLine();
                    System.out.println("Enter its price:");
                    price = Double.parseDouble(scanner.nextLine());
                    balance -= price;
                    System.out.println("Purchase was added!");
                    purchasesOther.add(purchase + " $" + price);
                    System.out.println();
                    break;
                case "5":
                    flag = true;
                    break;
                default:
                    System.out.println("Incorrect option! Please try again!");
                    break;
            }
        }
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
                    addPurchase();
                    System.out.println();
                    break;
                case "3":
                    System.out.println();
                    if (purchasesFood.isEmpty() && purchasesClothes.isEmpty() && purchasesEntertainment.isEmpty() && purchasesOther.isEmpty()) {
                        System.out.println("Purchase list is empty");
                    } else {
                        printPurchases();
                    }
                    System.out.println();
                    break;
                case "4":
                    System.out.println();
                    System.out.printf("Balance: $%.2f\n", balance);
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

    private void printFood() {
        for (String str : purchasesFood) {
            System.out.println(str);
            totalCost += Double.parseDouble(str.substring(str.lastIndexOf("$") + 1));
        }
    }

    private void printClothes() {
        for (String str : purchasesClothes) {
            System.out.println(str);
            totalCost += Double.parseDouble(str.substring(str.lastIndexOf("$") + 1));
        }
    }

    private void printEntertainment() {
        for (String str : purchasesEntertainment) {
            System.out.println(str);
            totalCost += Double.parseDouble(str.substring(str.lastIndexOf("$") + 1));
        }
    }


    private void printOther() {
        for (String str : purchasesEntertainment) {
            System.out.println(str);
            totalCost += Double.parseDouble(str.substring(str.lastIndexOf("$") + 1));
        }
    }

    private void printPurchases() {
        boolean flag = false;
        while (!flag) {
            printMenuPrintPurchases();
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    System.out.println();
                    System.out.println("Food:");
                    if (purchasesFood.isEmpty()) {
                        System.out.println("Purchase list is empty!");
                    } else {
                        printFood();
                        System.out.println("Total sum: $" + totalCost);
                        totalCost = 0;
                    }
                    System.out.println();
                    break;
                case "2":
                    System.out.println();
                    System.out.println("Clothes:");
                    if (purchasesClothes.isEmpty()) {
                        System.out.println("Purchase list is empty!");
                    } else {
                        printClothes();
                        System.out.println("Total sum: $" + totalCost);
                        totalCost = 0;
                    }
                    System.out.println();
                    break;
                case "3":
                    System.out.println();
                    System.out.println("Entertainment:");
                    if (purchasesEntertainment.isEmpty()) {
                        System.out.println("Purchase list is empty!");
                    } else {
                        printEntertainment();
                        System.out.println("Total sum: $" + totalCost);
                        totalCost = 0;
                    }
                    System.out.println();
                    break;
                case "4":
                    System.out.println();
                    System.out.println("Other:");
                    if (purchasesOther.isEmpty()) {
                        System.out.println("Purchase list is empty!");
                    } else {
                        printOther();
                        System.out.println("Total sum: $" + totalCost);
                        totalCost = 0;
                    }
                    System.out.println();
                    break;
                case "5":
                    System.out.println();
                    System.out.println("All:");
                    if (!purchasesFood.isEmpty()) {
                        printFood();
                    }
                    if (!purchasesClothes.isEmpty()) {
                        printClothes();
                    }
                    if (!purchasesEntertainment.isEmpty()) {
                        printEntertainment();
                    }
                    if (!purchasesOther.isEmpty()) {
                        printOther();
                    }
                    System.out.println("Total sum: $" + totalCost);
                    System.out.println();
                    totalCost = 0;
                    break;
                case "6":
                    flag = true;
                    break;
                default:
                    System.out.println("Incorrect option! Please try again!");
            }
        }
    }
}
