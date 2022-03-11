import java.util.*;

public class DoInventory {


    public int checkInventory(Delivery deliveryObj, CashRegister cashRegisterObj, CheckRegister checkRegisterObj, Inventory inventoryObj, PlaceAnOrder placeAnOrderObj, int currentDay, Announcer announcer, String name, TuneAlgorithm tuneObj, String storeName){
        List<Item> items = inventoryObj.getItemsList();
        double totalPurchasePrice = 0.0;
        int numberOfItems = 0;
        int index;
        // Variable to keep track of damaged objects during doInventory
        int damangedTuning = 0;
        HashMap<String, Integer> countItems = new HashMap<>();
        List<String> itemTypes = OuterUtils.Utils.getItemTypes();
        for(String itemType: itemTypes){
            countItems.put(itemType, 0);
        }
        // ArrayList to keep track of items removed after tuning damage
        ArrayList<Item> removeItems = new ArrayList<>();
        //Keep hashmap count of items
        for(Item item: items){
            numberOfItems++;
            totalPurchasePrice += item.getPurchasePrice();
            int updatedCount = countItems.get(item.getClass().getName()) + 1;
            countItems.put(item.getClass().getName(), updatedCount);
            // Tuning certain items
            if(Objects.equals(item.getClass().getSuperclass().getName(), "Players") || Objects.equals(item.getClass().getSuperclass().getName(), "Stringed") || Objects.equals(item.getClass().getSuperclass().getName(), "Wind")){
                if(tuneObj.tune(item, storeName)){
                    // Changing conditions and price if item is damaged during tuning
                    if(OuterUtils.Utils.getRandomProbability(10)){
                        damangedTuning +=1;
                        String[] conditionOptions = item.conditionOptions;
                        item.listPrice = (0.8) * (item.listPrice);
                        String currcondition = item.condition;
                        for(index=0; index< 5;index++ ) {
                            if(Objects.equals(conditionOptions[index], currcondition))
                                break;
                        }
                        if(index==0) {
                            removeItems.add(item);
                        } else {
                            item.condition = conditionOptions[index - 1];
                        }
                    }

                }
            }
        }
        // Remove items from inventory after tune damage and poor condition
        // Work around for bug while deleting
        for(Item element: removeItems){
            numberOfItems--;
            totalPurchasePrice += element.getPurchasePrice();
            int updatedCount = countItems.get(element.getClass().getName()) - 1;
            countItems.put(element.getClass().getName(), updatedCount);
            inventoryObj.deleteInventory(element);
        }
        announce(totalPurchasePrice, storeName);
        // Publishing the tracked components
        announcer.publishEvent(storeName+": "+name + " finds " + numberOfItems + " items in store", currentDay);
        announcer.publishEvent(storeName+": "+name + " finds  worth "+totalPurchasePrice, currentDay);
        announcer.publishEvent(storeName+": "+name + " damaged " + damangedTuning + " items while tuning during doinventory step", currentDay);
        announcer.publishEvent(storeName+": Items in inventory are worth "+totalPurchasePrice, currentDay);
        //For subclass items with zero count, place an order except for clothing class
        int ordered =0;
        for(Map.Entry<String, Integer> element : countItems.entrySet()){
            if(element.getValue() == 0 && (!element.getKey().equals("Hats") && !element.getKey().equals("Shirts") && !element.getKey().equals("Bandanas"))){
                ordered++;
                placeAnOrderObj.orderItems(element.getKey(),deliveryObj, cashRegisterObj,checkRegisterObj ,currentDay, storeName);
            }
        }
        announcer.publishEvent(storeName+": "+name +" ordered "+ordered+" items", currentDay);
        return damangedTuning;
    }

    public void announce(double totalValue, String storeName){
        System.out.println(storeName+": Value of all the items in the store:" + totalValue);
    }


}
