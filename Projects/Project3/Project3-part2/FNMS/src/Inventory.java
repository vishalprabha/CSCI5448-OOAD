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
            ItemsList.add(paperScoreItem);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            CD cdItem = new CD(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent",OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
            ItemsList.add(cdItem);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Vinyl vinylItem = new Vinyl(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent",OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
            ItemsList.add(vinylItem);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Cassette cassette = new Cassette(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent",OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
            ItemsList.add(cassette);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            PlayersCD playersCD = new PlayersCD(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            ItemsList.add(playersCD);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            RecordPlayer recordPlayer = new RecordPlayer(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            ItemsList.add(recordPlayer);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            MP3 mp3Player = new MP3(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            ItemsList.add(mp3Player);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            CassettePlayer cassettePlayer = new CassettePlayer(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            ItemsList.add(cassettePlayer);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Guitar guitar = new Guitar(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            ItemsList.add(guitar);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Bass bass = new Bass(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            ItemsList.add(bass);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Mandolin mandolin = new Mandolin(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            ItemsList.add(mandolin);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Flute flute = new Flute(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomName());
            ItemsList.add(flute);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Harmonica harmonica = new Harmonica(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomName());
            ItemsList.add(harmonica);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Saxaphone saxaphone = new Saxaphone(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomName());
            ItemsList.add(saxaphone);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Hats hat = new Hats(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomSize());
            ItemsList.add(hat);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Shirts shirt = new Shirts(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomSize());
            ItemsList.add(shirt);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Bandanas bandana = new Bandanas(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            ItemsList.add(bandana);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            PracticeAmps practiceAmp = new PracticeAmps(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomInt(1,10));
            ItemsList.add(practiceAmp);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Cables cable = new Cables(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomInt(1,10));
            ItemsList.add(cable);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Strings string = new Strings(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomName());
            ItemsList.add(string);
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            GigBag gigBag = new GigBag(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            ItemsList.add(gigBag);
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
    // Announcing Items added
    public void announce(Item item){
        System.out.println("Item: " + item.name + " of type " + item.getClass().getName() + " has been added the store's inventory" );
    }

}
