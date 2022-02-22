import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DoInventory {


    public void checkInventory(Delivery deliveryObj, CashRegister cashRegisterObj, CheckRegister checkRegisterObj, Inventory inventoryObj, PlaceAnOrder placeAnOrderObj, int currentDay, Announcer announcer, String name){
        List<Item> items = inventoryObj.getItemsList();
        double totalPurchasePrice = 0.0;
        int numberOfItems = 0;
        HashMap<String, Integer> countItems = new HashMap<>();
        List<String> itemTypes = OuterUtils.Utils.getItemTypes();
        for(String itemType: itemTypes){
            countItems.put(itemType, 0);
        }
        //Keep hashmap count of items
        for(Item item: items){
            numberOfItems++;
            totalPurchasePrice += item.getPurchasePrice();
            int updatedCount = countItems.get(item.getClass().getName()) + 1;
            countItems.put(item.getClass().getName(), updatedCount);
        }
        announce(totalPurchasePrice);
        announcer.publishEvent(name + " finds " + numberOfItems + " items in store", currentDay);
        announcer.publishEvent(name + " finds  worth "+totalPurchasePrice, currentDay);
        //For subclass items with zero count, place an order except for clothing class
        int ordered =0;
        for(Map.Entry<String, Integer> element : countItems.entrySet()){
            if(element.getValue() == 0 && (!element.getKey().equals("Hats") && !element.getKey().equals("Shirts") && !element.getKey().equals("Bandanas"))){
                ordered++;
                placeAnOrderObj.orderItems(element.getKey(),deliveryObj, cashRegisterObj,checkRegisterObj ,currentDay);
            }
        }
        announcer.publishEvent(name +" ordered "+ordered+" items", currentDay);
    }

    public void announce(double totalValue){
        System.out.println("Value of all the items in the store:" + totalValue);
    }


}
