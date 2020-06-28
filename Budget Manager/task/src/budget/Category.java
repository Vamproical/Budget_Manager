package budget;

public enum Category {
    FOOD("Food"),
    CLOTHES("Clothes"),
    ENTERTAINMENT("Entertainment"),
    OTHER("Other");

    private String type;

    Category(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

