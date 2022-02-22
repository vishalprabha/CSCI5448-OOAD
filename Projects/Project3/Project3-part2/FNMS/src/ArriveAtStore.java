import java.util.ArrayList;
import java.util.List;
// Clerk ArriveAtStore functionality
public class ArriveAtStore {
    // Store arrival announcement
    public void announce(int day, String name, Announcer announcer){
        announcer.publishEvent("",day);
        System.out.println(name + " arrives at the store on Day "+ day);
    }
    // Checking for any deliveries and adding to inventory
    public void checkDelivery(int day, Delivery deliveryObj, Inventory inventoryObj, Announcer announcer, String name){
        List<Item> deliveredItems;
        if(deliveryObj.itemsList.containsKey(day)){
            deliveredItems = deliveryObj.itemsList.get(day);
            for(Item itemObj:deliveredItems){
                inventoryObj.addInventory(itemObj);
                inventoryObj.announce(itemObj);
            }
            announcer.publishEvent(name + "number of items added on "+day+" is "+deliveredItems.size(), day);
        }
        else{
            System.out.println("No Items delivered on day "+ day);
        }
    }
}
