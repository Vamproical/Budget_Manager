package budget.Analyze;

import budget.Account;

public class SortContext {
    private SortingType type;

    public void setMethod(SortingType type) {
        this.type = type;
    }

    public void init(Account account) {
        this.type.init(account);
    }
}
