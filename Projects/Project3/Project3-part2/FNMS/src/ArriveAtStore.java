import java.util.ArrayList;
import java.util.List;
// Clerk ArriveAtStore functionality
public class ArriveAtStore {
    // Store arrival announcement
    public void announce(int day, String name){
        System.out.println(name + " arrives at the store on Day "+ day);
    }
    // Checking for any deliveries and adding to inventory
    public void checkDelivery(int day, Delivery deliveryObj, Inventory inventoryObj){
        List<Item> deliveredItems;
        if(deliveryObj.itemsList.containsKey(day)){
            deliveredItems = deliveryObj.itemsList.get(day);
            for(Item itemObj:deliveredItems){
                inventoryObj.addInventory(itemObj);
                inventoryObj.announce(itemObj);
            }
        }
        else{
            System.out.println("No Items delivered on day "+ day);
        }
    }
}
