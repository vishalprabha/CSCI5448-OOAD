import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> ItemsList;


    Inventory(){
        // Initializing inventory
        ItemsList = new ArrayList<>();
        // Creating the initial inventory list
        for (int index = 0; index < 3; index ++){
            double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
            PaperScore paperScoreItem = new PaperScore(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent",OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(paperScoreItem);
            CD cdItem = new CD(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent",OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(cdItem);
            Vinyl vinylItem = new Vinyl(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent",OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(vinylItem);
            PlayersCD playersCD = new PlayersCD(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(playersCD);
            RecordPlayer recordPlayer = new RecordPlayer(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(recordPlayer);
            MP3 mp3Player = new MP3(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(mp3Player);
            Guitar guitar = new Guitar(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(guitar);
            Bass bass = new Bass(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(bass);
            Mandolin mandolin = new Mandolin(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(mandolin);
            Flute flute = new Flute(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomName());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(flute);
            Harmonica harmonica = new Harmonica(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomName());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(harmonica);
            Hats hat = new Hats(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomSize());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(hat);
            Shirts shirt = new Shirts(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomSize());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(shirt);
            Bandanas bandana = new Bandanas(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            ItemsList.add(bandana);
            PracticeAmps practiceAmp = new PracticeAmps(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomInt(1,10));
            ItemsList.add(practiceAmp);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Cables cable = new Cables(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomInt(1,10));
            ItemsList.add(cable);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Strings string = new Strings(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomName());
            ItemsList.add(string);
        }
    }
    // Getter for inventory list
    public List<Item> getItemsList() {
        return ItemsList;
    }
    // Setter for inventory list
    public void setItemsList(List<Item> itemsList) {
        ItemsList = itemsList;
    }
    // Add item to the inventory list
    public void addInventory(Item item){
        ItemsList.add(item);
    }
    // Delete item from inventory list
    public void deleteInventory(Item item){
        ItemsList.remove(item);
    }
    // Checking inventory for a particular item
    public List<Item> checkInventory(String itemName){
        List<Item> particularItemList = new ArrayList<>();
        for (Item item : ItemsList) {
            if (item.getClass().getName().equals(itemName)) {
                particularItemList.add(item);
            }
        }
        return particularItemList;
    }
    // Checking if an item is present in the inventory
    public boolean peekInventory(String s){
        for (Item item : ItemsList) {
            if (item.getClass().getName().equals(s)) {
                return true;
            }
        }
        return false;
    }
    // Announcing Items added
    public void announce(Item item){
        System.out.println("Item: " + item.name + " has been added the store's inventory" );
    }
    // Announcing Item sold with discount percentage
    public void announce(Item item, int i){
        System.out.println("Item Name: " + item + "Discount: " + i);
    }
}
