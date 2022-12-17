package workingWithAbstraction.greedyTimes;

public class Item {
    private String itemName;
    private ItemType itemType;
    private long amount;

    public Item(String itemName, ItemType itemType, long amount) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.amount = amount;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
