package budget;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CreateAccountFromFile {
    private final Account account = new Account();

    private int checkCategory(String check) {
        switch (check) {
            case "FOOD":
                return 0;
            case "CLOTHES":
                return 1;
            case "ENTERTAINMENT":
                return 2;
            case "OTHER":
                return 3;
            default:
                return -1;
        }
    }

    private String getPurchaseName(String[] get) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < get.length - 2; i++) {
            stringBuilder.append(get[i]).append(" ");
        }
        stringBuilder.append(get[get.length - 2]);
        return stringBuilder.toString();
    }

    private void readFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("purchases.txt"));
            String[] entryInfo;
            for (String entry : lines) {
                entryInfo = entry.split(" ");
                if (entryInfo[0].equals("Income")) {
                    account.setBalance(Double.parseDouble(entryInfo[1]));
                } else {
                    account.addPurchaseFromFile(new Purchase(
                            Category.values()[checkCategory(entryInfo[0])], getPurchaseName(entryInfo), Double.parseDouble(entryInfo[entryInfo.length - 1].substring(entryInfo[entryInfo.length - 1].lastIndexOf("$") + 1))));
                }
            }
        } catch (IOException e) {
            System.out.println("No file found: purchases.txt");
        }
    }

    public Account getAccount() {
        readFile();
        return account;
    }
}

