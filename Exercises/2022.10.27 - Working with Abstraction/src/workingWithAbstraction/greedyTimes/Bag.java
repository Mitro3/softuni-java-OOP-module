package workingWithAbstraction.greedyTimes;

import java.util.*;

public class Bag {
    private List<Item> items;
    private long capacity;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void put(Item item) {
        if (capacity < getTotalAmount() + item.getAmount() && items.size() != 0) {
            return;
        }

        if (weCanStore(item)) {
            Item oldItem = null;
            oldItem = items.stream().filter(i -> i.getItemName().equals(item.getItemName()))
                    .findAny()
                    .orElse(null);

            if (oldItem != null) {
                item.setAmount(item.getAmount() + oldItem.getAmount());
                items.remove(oldItem);
            }

            items.add(item);
        }

    }

    private boolean weCanStore(Item item) {
        switch (item.getItemType()) {
            case GEM:
                if (getAmount(ItemType.GEM) + item.getAmount() > getAmount(ItemType.GOLD)) {
                    return false;
                }
                break;

            case CASH:
                if (getAmount(ItemType.CASH) + item.getAmount() > getAmount(ItemType.GEM)) {
                    return false;
                }
                break;
        }
        return true;
    }

    public long getAmount(ItemType itemType) {
        return this.items.stream()
                .filter(e -> e.getItemType().equals(itemType))
                .mapToLong(Item::getAmount)
                .sum();
    }

    public long getTotalAmount() {
        return getAmount(ItemType.CASH) + getAmount(ItemType.GEM) + getAmount(ItemType.GOLD);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getAmount(ItemType.GOLD) != 0) {
            sb.append(String.format("<Gold> $%d%n##Gold - %d%n", getAmount(ItemType.GOLD), getAmount(ItemType.GOLD)));
        }

        if (getAmount(ItemType.GEM) != 0) {
            sb.append(String.format("<Gem> $%d%n", getAmount(ItemType.GEM)));
            items.stream().filter(i -> i.getItemType().equals(ItemType.GEM))
                    .sorted(Comparator.comparing(Item::getItemName).reversed())
                    .sorted(Comparator.comparing(Item::getAmount))
                    .forEach(i -> sb.append(String.format("##%s - %d%n", i.getItemName(), i.getAmount())));
        }

        if (getAmount(ItemType.CASH) != 0) {
            sb.append(String.format("<Cash> $%d%n", getAmount(ItemType.CASH)));
            items.stream().filter(i -> i.getItemType().equals(ItemType.CASH))
                    .sorted(Comparator.comparing(Item::getItemName).reversed())
//                    .sorted(Comparator.comparing(Item::getAmount).reversed())
                    .forEach(i -> sb.append(String.format("##%s - %d%n", i.getItemName(), i.getAmount())));
        }

        return sb.toString();
    }
}
