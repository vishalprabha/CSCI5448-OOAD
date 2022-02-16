import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DoInventory {


    public void checkInventory(Delivery deliveryObj, CashRegister cashRegisterObj, CheckRegister checkRegisterObj, Inventory inventoryObj, PlaceAnOrder placeAnOrderObj, int currentDay){
        List<Item> items = inventoryObj.getItemsList();
        double totalPurchasePrice = 0.0;
        HashMap<String, Integer> countItems = new HashMap<String, Integer>();
        List<String> itemTypes = OuterUtils.Utils.getItemTypes();
        for(String itemType: itemTypes){
            countItems.put(itemType, 0);
        }
        //Keep hashmap count of items
        for(Item item: items){
            totalPurchasePrice += item.getPurchasePrice();
            int updatedCount = countItems.get(item.getClass().getName()) + 1;
            countItems.put(item.getClass().getName(), updatedCount);
        }
        announce(totalPurchasePrice);
        //For subclass items with zero count, place an order
        for(Map.Entry<String, Integer> e : countItems.entrySet()){
            if(e.getValue() == 0){
                placeAnOrderObj.orderItems(e.getKey(),deliveryObj, cashRegisterObj,checkRegisterObj ,currentDay);
            }
        }
    }

    public void announce(double totalValue){
        System.out.println("Value of all the items in the store:" + totalValue);
    }


}
