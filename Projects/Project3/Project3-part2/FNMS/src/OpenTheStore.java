import java.util.*;

public class OpenTheStore {

    // Function to sell an item to customer
    public void orchestrateSell(int day, String clerkName, Inventory inventoryObj, CashRegister cashRegisterObj, Customer customerObj, HashMap<Integer, List<Item>> listItemsSold){
        String buyItemName = customerObj.getBuyItemName();
        List<Item> items = inventoryObj.getItemsList();
        for(Item item : items) {
            if(Objects.equals(item.getClass().getName(), buyItemName)) {
                if(OuterUtils.Utils.getRandomProbability(50)) {
                    cashRegisterObj.addMoney(item.getListPrice());
                    item.setSalePrice(item.getListPrice());
                    item.setDaySold(day);
                    inventoryObj.deleteInventory(item);
                    // code auto generated from intelliJ suggestion
                    listItemsSold.computeIfAbsent(day, k -> new ArrayList<>());
                    listItemsSold.get(day).add(item);
                    announceSelling(clerkName,item.getClass().getName(), customerObj.getId(),item.getSalePrice(), 0 );
                    return;
                }
                else if(OuterUtils.Utils.getRandomProbability(75)){
                        cashRegisterObj.addMoney((0.9)*item.getListPrice());
                        item.setSalePrice((0.9)*item.getListPrice());
                        item.setDaySold(day);
                        inventoryObj.deleteInventory(item);
                        listItemsSold.computeIfAbsent(day, k -> new ArrayList<>());
                        listItemsSold.get(day).add(item);
                        announceSelling(clerkName,item.getClass().getName(), customerObj.getId(),item.getSalePrice(), 10 );
                        return;
                    }
                else{
                    System.out.println("Customer "+customerObj.getId()+ " left without buying "+item.getClass().getName()+" even though it was present");
                    return;
                }
            }
        }
        System.out.println("Customer "+customerObj.getId()+ " wanted to buy a "+buyItemName+"  but none were in inventory, so they left.");
    }
    // Function to check count of clothing items
    public int countClothing(Inventory inventoryObj){
        List<Item> items = inventoryObj.getItemsList();
        HashMap<String, Integer> countItems = new HashMap<>();
        List<String> itemTypes = OuterUtils.Utils.getItemTypes();
        for(String itemType: itemTypes){
            countItems.put(itemType, 0);
        }
        //Keep hashmap count of items
        for(Item item: items){
            int updatedCount = countItems.get(item.getClass().getName()) + 1;
            countItems.put(item.getClass().getName(), updatedCount);
        }
        int count = 0;
        count += countItems.get("Hats") + countItems.get("Shirts") + countItems.get("Bandanas");
        return count;
    }
    // Function to buy an item from the customer
    public void orchestrateBuy(int day, Inventory inventoryObj, CashRegister cashRegisterObj, Customer customerObj, String clerkName, CheckRegister checkRegisterObj){
        Item addItem = customerObj.getSellItemObj();
        String currCondition = addItem.getCondition();
        double purchasePrice;
        if(Objects.equals(currCondition, "poor")) {
            purchasePrice = OuterUtils.Utils.getRandomPrice(0,20);
        } else if(Objects.equals(currCondition, "fair")) {
            purchasePrice = OuterUtils.Utils.getRandomPrice(21,40);
        } else if(Objects.equals(currCondition, "good")) {
            purchasePrice = OuterUtils.Utils.getRandomPrice(41,60);
        } else if(Objects.equals(currCondition, "very good")) {
            purchasePrice = OuterUtils.Utils.getRandomPrice(61,80);
        } else {
            purchasePrice = OuterUtils.Utils.getRandomPrice(81,100);
        }
        // Checking if Item being sold is clothing
        if( addItem.getClass().getName().equals("Hats") || addItem.getClass().getName().equals("Shirts") || addItem.getClass().getName().equals("Bandanas")){
            // If clothing inventory empty, we don't buy any clothes
            if (countClothing(inventoryObj) == 0){
                System.out.println("Store received a  "+addItem.getClass().getName()+ " from customer "+customerObj.getId()+ ", but store will no longer buy clothes from customer");
                return;
            }}
        // Executing normal buy oepration
        if(OuterUtils.Utils.getRandomProbability(50)) {
            addItem.setPurchasePrice(purchasePrice);
            addItem.setListPrice(2*purchasePrice);
            // Checking if the register has enough money, else withdrawing from bank
            if(cashRegisterObj.getMoney() < purchasePrice) {
                checkRegisterObj.checkBalanceInRegister(day, cashRegisterObj);
            }
                inventoryObj.addInventory(addItem);
                cashRegisterObj.removeMoney(purchasePrice);
                announceBuying(clerkName, addItem.getClass().getName(), customerObj.getId(), purchasePrice, currCondition, addItem.getNewOrUsed());
        }
        else if(OuterUtils.Utils.getRandomProbability(75)) {
            purchasePrice = (1.1) * purchasePrice;
            addItem.setPurchasePrice(purchasePrice);
            addItem.setListPrice(2 * purchasePrice);
            // Checking if the register has enough money, else withdrawing from bank
            if(cashRegisterObj.getMoney() > purchasePrice) {
                checkRegisterObj.checkBalanceInRegister(day, cashRegisterObj);
            }
                inventoryObj.addInventory(addItem);
                cashRegisterObj.removeMoney(purchasePrice);
                announceBuying(clerkName, addItem.getClass().getName(), customerObj.getId(), purchasePrice, currCondition, addItem.getNewOrUsed());

        }
        else{
            System.out.println("Customer "+customerObj.getId()+ " wanted to sell a "+addItem.getClass().getName()+"  but did not sell even after providing discount");
        }

    }

    public void announceSelling(String clerkName, String itemName, int customerNumber, double itemCost, int discountPercentage){
        System.out.println(clerkName + " sold a " + itemName + " to Customer " + customerNumber + " for $" + itemCost + " after a "+discountPercentage+"% discount");
    }

    public void announceBuying(String clerkName, String itemName, int customerNumber, double itemCost, String condition, String age){
        System.out.println(clerkName + " bought a " + condition +" condition "+  age + " " + itemName + " from Customer " + customerNumber + " for " + itemCost);
    }

}
