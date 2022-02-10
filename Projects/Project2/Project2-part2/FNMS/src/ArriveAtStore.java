import java.util.ArrayList;
import java.util.List;

public class ArriveAtStore {
    // Store arrival announcement
    public void announce(int day, String name){
        System.out.println(name + " arrives at the store on Day "+ day);
    }
    // Checking for any deliveries and adding to inventory
    public void checkDelivery(int day, Delivery deliveryObj, Inventory inventoryObj){
        List<Item> deliveredItems = new ArrayList<Item>();
        if(deliveryObj.itemsList.containsKey(day)){
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
