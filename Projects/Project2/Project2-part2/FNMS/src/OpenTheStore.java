import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class OpenTheStore {

     HashMap listItemsSold;
    Random rand = new Random();
    public HashMap getListItemsSold() {
        return listItemsSold;
    }

    public void setListItemsSold(HashMap listItemsSold) {
        this.listItemsSold = listItemsSold;
    }

    public void announce(int day){

    }

    public void orchestrateBuy(Inventory inventoryObj, CashRegister cashRegisterObj, Customer customerObj){

    }

    public void orchestrateSell(Inventory inventoryObj, CashRegister cashRegisterObj, Customer customerObj, String clerkName){

        Item addItem = customerObj.getSellItemObj();
        String currCondition = addItem.getCondition();
        double purchasePrice = 0.0;
        if(currCondition == "poor") {
            purchasePrice = OuterUtils.Utils.getRandomPrice(0,20);
        } else if(currCondition == "fair") {
            purchasePrice = OuterUtils.Utils.getRandomPrice(21,40);
        } else if(currCondition == "good") {
            purchasePrice = OuterUtils.Utils.getRandomPrice(41,60);
        } else if(currCondition == "very good") {
            purchasePrice = OuterUtils.Utils.getRandomPrice(61,80);
        } else if(currCondition == "excellent") {
            purchasePrice = OuterUtils.Utils.getRandomPrice(81,100);
        }
        boolean accept = OuterUtils.Utils.getRandomBuy(50);
        if(accept) {
            addItem.setPurchasePrice(purchasePrice);
            addItem.setListPrice(2*purchasePrice);
            inventoryObj.addInventory(addItem);
            cashRegisterObj.removeMoney(purchasePrice);
            announceSelling(clerkName, addItem.getName(), customerObj.getId(), purchasePrice, currCondition);
        } else {
            accept = OuterUtils.Utils.getRandomBuy(75);
            if(accept) {
                purchasePrice = (1.1) * purchasePrice;
                addItem.setPurchasePrice(purchasePrice);
                addItem.setListPrice(2 * purchasePrice);
                cashRegisterObj.removeMoney(purchasePrice);
            }
            announceSelling(clerkName, addItem.getName(), customerObj.getId(), purchasePrice, currCondition);
        }
    }

    public void announce(String clerkName, String itemName, int customerNumber, double itemCost, int discountPercentage){

    }

    public void announceSelling(String clerkName, String itemName, int customerNumber, double itemCost, String condition){
        System.out.println(clerkName + "bought a" + condition + itemName + "from" + customerNumber + "at" + itemCost);
    }

    public void CheckRegisterBalance(CheckRegister checkRegisterObj){

    }
}
