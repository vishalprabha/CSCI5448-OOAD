import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> ItemsList;


    Inventory(){
        this.ItemsList = new ArrayList<>();
        for (int index = 0; index < 3; index ++){
            double purchasePrice = OuterUtils.Utils.getRandomPrice(50);
            PaperScore paperScoreItem = new PaperScore(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent",OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());

        }



    }
    public List<Item> getItemsList() {
        return ItemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        ItemsList = itemsList;
    }

    public void addInventory(Item item){

    }

    public void updateInventory(Item item){

    }

    public void deleteInventory(Item item){

    }

    public List<Item> checkInventory(String s){
        return ItemsList;
    }

    public void announce(Item item){

    }

    public void announce(Item item, int i){

    }
}
