import java.util.*;

public class OpenTheStore {

    Random rand = new Random();
    public void announce(int day){

    }
    // Function to sell an item to customer
    public void orchestrateSell(Inventory inventoryObj, CashRegister cashRegisterObj, Customer customerObj, HashMap<Integer, List<Item>> listItemsSold){
        String buyItemName = customerObj.getBuyItemName();
        List<Item> items = inventoryObj.getItemsList();
        for(Item item : items) {
            if(Objects.equals(item.getName(), buyItemName)) {
                boolean buy = OuterUtils.Utils.getRandomBuy(50);
                if(buy) {
                    cashRegisterObj.addMoney(item.getListPrice());
                    inventoryObj.deleteInventory(item);
                   // this.getListItemsSold().put(item,  new ArrayList<> List.of(item.getListPrice(), it)));
                } else {
                     buy = OuterUtils.Utils.getRandomBuy(75);
                    if(buy) {
                        cashRegisterObj.addMoney((0.9)*item.getListPrice());
                        inventoryObj.deleteInventory(item);
                      //  this.getListItemsSold()
                    }
                }
                break;
            }
        }
    }
    // Function to buy an item from the customer
    public void orchestrateBuy(Inventory inventoryObj, CashRegister cashRegisterObj, Customer customerObj, String clerkName){
        Item addItem = customerObj.getSellItemObj();
        String currCondition = addItem.getCondition();
        double purchasePrice = 0.0;
        if(Objects.equals(currCondition, "poor")) {
            purchasePrice = OuterUtils.Utils.getRandomPrice(0,20);
        } else if(Objects.equals(currCondition, "fair")) {
            purchasePrice = OuterUtils.Utils.getRandomPrice(21,40);
        } else if(Objects.equals(currCondition, "good")) {
            purchasePrice = OuterUtils.Utils.getRandomPrice(41,60);
        } else if(Objects.equals(currCondition, "very good")) {
            purchasePrice = OuterUtils.Utils.getRandomPrice(61,80);
        } else if(Objects.equals(currCondition, "excellent")) {
            purchasePrice = OuterUtils.Utils.getRandomPrice(81,100);
        }
        boolean accept = OuterUtils.Utils.getRandomBuy(50);
        if(accept) {
            addItem.setPurchasePrice(purchasePrice);
            addItem.setListPrice(2*purchasePrice);
            if(cashRegisterObj.getMoney() > purchasePrice) {
                inventoryObj.addInventory(addItem);
                cashRegisterObj.removeMoney(purchasePrice);
                announceSelling(clerkName, addItem.getName(), customerObj.getId(), purchasePrice, currCondition);
            }
        } else {
            accept = OuterUtils.Utils.getRandomBuy(75);
            if(accept) {
                purchasePrice = (1.1) * purchasePrice;
                addItem.setPurchasePrice(purchasePrice);
                addItem.setListPrice(2 * purchasePrice);
                if(cashRegisterObj.getMoney() > purchasePrice) {
                    inventoryObj.addInventory(addItem);
                    cashRegisterObj.removeMoney(purchasePrice);
                    announceSelling(clerkName, addItem.getName(), customerObj.getId(), purchasePrice, currCondition);
                }
            }
        }
    }

    public void announceBuying(String clerkName, String itemName, int customerNumber, double itemCost, int discountPercentage){

    }

    public void announceSelling(String clerkName, String itemName, int customerNumber, double itemCost, String condition){
        System.out.println(clerkName + "bought a" + condition + itemName + "from" + customerNumber + "at" + itemCost);
    }

    public void CheckRegisterBalance(CheckRegister checkRegisterObj){

    }
}
