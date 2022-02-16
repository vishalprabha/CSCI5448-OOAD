import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Delivery {
    // Hold delivery itemList objects along with the day they arrive
    HashMap<Integer, ArrayList<Item>> itemsList;

    // Constructor initializing itemsList
    Delivery() {
        this.itemsList = new HashMap<>();
    }

    // Function to get delivery items for a particular day
    public ArrayList<Item> getItemsList(int day) {
        return itemsList.get(day);
    }

    // Function to add delivery items to be delivered on a particular day
    public void setItemsList(int day, ArrayList<Item> deliverItems) {
        if (itemsList.get(day) == null) {
            this.itemsList.put(day, new ArrayList<>()); }

        for (Item deliverItem : deliverItems) {
            this.itemsList.get(day).add(deliverItem);
        }
    }
}
