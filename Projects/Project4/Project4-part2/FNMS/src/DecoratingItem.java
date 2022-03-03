import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public abstract class DecoratingItem {
    HashMap<Integer, List<Item>> listItemsSold;
    Inventory inventoryObj;
    CashRegister cashRegisterObj;
    int day;
    boolean isItemSoldFromInventory = false;
    Item soldItem;

    DecoratingItem(Inventory inventory, HashMap<Integer, List<Item>> listItemsSold, CashRegister cashRegister, int day) {
        this.listItemsSold = listItemsSold;
        this.inventoryObj = inventory;
        this.cashRegisterObj = cashRegister;
        this.day = day;
    }

    public boolean getIsItemSoldFromInventory(){
        return isItemSoldFromInventory;
    }

    //set true if sold
    public void setIsItemSoldFromInventory(boolean value){
        this.isItemSoldFromInventory = value;
    }

    public Item getSoldItem(){
        return soldItem;
    }

    //set sold item
    public void setSoldItem(Item item){
        soldItem = item;
    }

    //Sell additional from inventory if present.
    public void SellItemFromInventory(String itemType) {
        List<Item> items = inventoryObj.getItemsList();
        for(Item item : items) {
            if (Objects.equals(item.getClass().getName(), itemType)) {
                cashRegisterObj.addMoney(item.getListPrice());
                item.setSalePrice(item.getListPrice());
                item.setDaySold(day);
                inventoryObj.deleteInventory(item);
                // code auto generated from intelliJ suggestion
                listItemsSold.computeIfAbsent(day, k -> new ArrayList<>());
                listItemsSold.get(day).add(item);
                setSoldItem(item);
                setIsItemSoldFromInventory(true);
                return;
            }
        }
    }

}

class AddGigBag extends DecoratingItem {
    AddGigBag(Inventory inventory, HashMap<Integer, List<Item>> listItemsSold, CashRegister cashRegisterObj, int day) {
        super(inventory, listItemsSold, cashRegisterObj, day);
        SellItemFromInventory("GigBag");
    }
}

class AddStrings extends DecoratingItem {
    AddStrings(Inventory inventory, HashMap<Integer, List<Item>> listItemsSold, CashRegister cashRegisterObj, int day) {
        super(inventory, listItemsSold, cashRegisterObj, day);
        SellItemFromInventory("Strings");
    }
}

class AddCables extends DecoratingItem {
    AddCables(Inventory inventory, HashMap<Integer, List<Item>> listItemsSold, CashRegister cashRegisterObj, int day) {
        super(inventory, listItemsSold, cashRegisterObj, day);
        SellItemFromInventory("Cables");
    }
}

class AddPracticeAmps extends DecoratingItem {
    AddPracticeAmps(Inventory inventory, HashMap<Integer, List<Item>> listItemsSold, CashRegister cashRegisterObj, int day) {
        super(inventory, listItemsSold, cashRegisterObj, day);
        SellItemFromInventory("PracticeAmps");
    }
}




