package budget.Analyze;

import budget.Account;
import budget.Category;
import budget.Purchase;

import java.util.List;
import java.util.Map;

public interface SortingType {
    void init(Account account);

    void sort(Map<Category, List<Purchase>> purchases);

    List<Purchase> sort(List<Purchase> purchases);
}
