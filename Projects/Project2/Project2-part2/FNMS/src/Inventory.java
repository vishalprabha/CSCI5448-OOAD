import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> ItemsList;


    Inventory(){
        // Initializing inventory
        this.ItemsList = new ArrayList<>();
        // Creating the initial inventory list
        for (int index = 0; index < 3; index ++){
            double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
            PaperScore paperScoreItem = new PaperScore(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent",OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            CD cdItem = new CD(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent",OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Vinyl vinylItem = new Vinyl(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent",OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            PlayersCD playersCD = new PlayersCD(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            RecordPlayer recordPlayer = new RecordPlayer(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            MP3 mp3Player = new MP3(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Guitar guitar = new Guitar(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Bass bass = new Bass(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Mandolin mandolin = new Mandolin(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Flute flute = new Flute(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomName());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Harmonica harmonica = new Harmonica(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomName());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Hats hat = new Hats(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomSize());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Shirts shirt = new Shirts(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomSize());
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Bandanas bandana = new Bandanas(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent");
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            PracticeAmps PracticeAmp = new PracticeAmps(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomInt(1,10));
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Cables cable = new Cables(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomInt(1,10));
            purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
            Strings string = new Strings(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", OuterUtils.Utils.getRandomName());
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
