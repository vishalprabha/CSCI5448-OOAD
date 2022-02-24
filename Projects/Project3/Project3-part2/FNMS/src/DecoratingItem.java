import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

// we can make our own custom decorator that takes the original item being sold
// and lets us add to it
// in decorator fashion, this should not impact the code for selling undecorated items
// note that this has no impact on the existing SellAnItem in Clerk
// or the way items work
// We will include an internal ArrayList of the items being purchased

public abstract class DecoratingItem {
    HashMap<Integer, List<Item>> listItemsSold;
    Inventory inventoryObj;
    CashRegister cashRegisterObj;
    int day;

    boolean isItemAddedToInventory;
    Item soldItem;

    DecoratingItem(Inventory inventory, HashMap<Integer, List<Item>> listItemsSold, CashRegister cashRegister, int day) {
        this.listItemsSold = listItemsSold;
        this.inventoryObj = inventory;
        this.cashRegisterObj = cashRegister;
        this.day = day;
    }

    public boolean getIsItemAddedToInventory(){
        return isItemAddedToInventory;
    }

    public void setIsItemAddedToInventory(boolean value){
        this.isItemAddedToInventory = value;
    }

    public Item getSoldItem(){
        return soldItem;
    }

    public void setSoldItem(Item item){
        soldItem = item;
    }
    public void AddItemTypeToInventory(String itemType) {
        for(Item item : inventoryObj.getItemsList()) {
            if (Objects.equals(item.getClass().getName(), itemType)) {
                cashRegisterObj.addMoney(item.getListPrice());
                item.setSalePrice(item.getListPrice());
                item.setDaySold(day);
                inventoryObj.deleteInventory(item);
                // code auto generated from intelliJ suggestion
                listItemsSold.computeIfAbsent(day, k -> new ArrayList<>());
                listItemsSold.get(day).add(item);
                soldItem = item;
                //announceSelling(clerkName,item.getClass().getName(), customerObj.getId(),item.getSalePrice(), 0 );
            }
        }
    }

}

// you could add special rules here for deciding whether you want to add an
// Item and how many, and make sure there's enough, etc.
// for simplicity if there is one, we add it to the sale and take it off inventory

class AddGigBag extends DecoratingItem {
    AddGigBag(Inventory inventory, HashMap<Integer, List<Item>> listItemsSold, CashRegister cashRegisterObj, int day) {
        super(inventory, listItemsSold, cashRegisterObj, day);
        AddItemTypeToInventory("GigBag");
    }
}

class AddStrings extends DecoratingItem {
    AddStrings(Inventory inventory, HashMap<Integer, List<Item>> listItemsSold, CashRegister cashRegisterObj, int day) {
        super(inventory, listItemsSold, cashRegisterObj, day);
        AddItemTypeToInventory("Strings");
    }

}



