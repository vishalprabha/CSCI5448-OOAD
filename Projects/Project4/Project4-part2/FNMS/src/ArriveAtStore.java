import java.util.ArrayList;
import java.util.List;
// Clerk ArriveAtStore functionality
public class ArriveAtStore {
    // Store arrival announcement
    public void announce(int day, String name, Announcer announcer, String storeName){
        announcer.publishEvent(storeName+": " +name +" arrives at store",day, storeName);
        System.out.println(storeName+": " +name + " arrives at the store on Day "+ day);
    }
    // Checking for any deliveries and adding to inventory
    public void checkDelivery(int day, Delivery deliveryObj, Inventory inventoryObj, Announcer announcer, String name, String storeName){
        List<Item> deliveredItems;
        if(deliveryObj.itemsList.containsKey(day)){
            deliveredItems = deliveryObj.itemsList.get(day);
            for(Item itemObj:deliveredItems){
                inventoryObj.addInventory(itemObj);
                inventoryObj.announce(itemObj, storeName);
            }
            announcer.publishEvent(storeName+": " +name + " added "+ deliveredItems.size() + " items to inventory", day, storeName);
        }
        else{
            System.out.println(storeName+": No Items delivered on day "+ day);
        }
    }
}
