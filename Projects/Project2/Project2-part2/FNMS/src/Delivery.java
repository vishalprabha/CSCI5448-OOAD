import java.util.HashMap;
import java.util.List;

public class Delivery {
    HashMap<Integer, List<Item>> itemsList;

    Delivery(){
        itemsList = new HashMap<Integer, List<Item>>();
    }
}
