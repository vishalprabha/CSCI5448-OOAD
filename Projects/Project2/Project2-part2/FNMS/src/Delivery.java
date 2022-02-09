import java.util.HashMap;
import java.util.List;

public class Delivery {

    HashMap<Integer, List<Item>> itemsList;

    Delivery(){
        itemsList = new HashMap<>();
    }

    public HashMap<Integer, List<Item>> getItemsList() {
        return itemsList;
    }

    public void setItemsList(HashMap<Integer, List<Item>> itemsList) {
        this.itemsList = itemsList;
    }

}
