import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DoInventory {


    public void checkInventory(Delivery deliveryObj, CashRegister cashRegisterObj, CheckRegister checkRegisterObj, Inventory inventoryObj, PlaceAnOrder placeAnOrderObj, int currentDay){
        List<Item> items = inventoryObj.getItemsList();
        double totalPurchasePrice = 0.0;
        HashMap<String, Integer> countItems = new HashMap<>();
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
        //For subclass items with zero count, place an order except for clothing class
        for(Map.Entry<String, Integer> element : countItems.entrySet()){
            if(element.getValue() == 0 && (!element.getKey().equals("Hats") && !element.getKey().equals("Shirts") && !element.getKey().equals("Bandanas"))){
                placeAnOrderObj.orderItems(element.getKey(),deliveryObj, cashRegisterObj,checkRegisterObj ,currentDay);
            }
        }
    }

    public void announce(double totalValue){
        System.out.println("Value of all the items in the store:" + totalValue);
    }


}
