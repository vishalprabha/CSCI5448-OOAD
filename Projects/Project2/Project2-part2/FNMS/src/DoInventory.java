import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DoInventory {

    Delivery deliveryObj;

    CashRegister cashRegisterObj;

    CheckRegister checkRegisterObj;

    public void checkInventory(Inventory inventoryObj, PlaceAnOrder placeAnOrderObj, int currentDay){
        List<Item> items = inventoryObj.getItemsList();
        double totalPurchasePrice = 0.0;
        HashMap<String, Integer> countItems = new HashMap<String, Integer>();
        List<String> itemTypes = OuterUtils.Utils.getItemTypes();
        for(String itemType: itemTypes){
            countItems.put(itemType, 0);
        }
        for(Item item: items){
            totalPurchasePrice += item.getPurchasePrice();
            int updatedCount = countItems.get(item.getClass().getName()) + 1;
            countItems.put(item.getClass().getName(), updatedCount);
        }
        for(Map.Entry<String, Integer> e : countItems.entrySet()){
            if(e.getValue() == 0){
                placeAnOrderObj.orderItems(e.getKey(),deliveryObj, cashRegisterObj,checkRegisterObj ,currentDay);
            }
        }
    }

    DoInventory(Delivery deliObj, CashRegister cashObj, CheckRegister checkRegObj){
        deliveryObj = deliObj;
        cashRegisterObj = cashObj;
        checkRegisterObj = checkRegObj;
    }

    public void announce(double totalValue){

    }


}
