package budget;

import java.util.Scanner;

public class BudgetManager {
    private final Scanner scanner = new Scanner(System.in);
    private double totalCost = 0;

    public void countMoney() {
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(str);
            totalCost += Double.parseDouble(str.substring(str.lastIndexOf("$") + 1));
        }
        System.out.println();
        System.out.println("Total: $" + totalCost);
    }
}
