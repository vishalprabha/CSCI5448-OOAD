import java.util.*;

public class OpenTheStore {

    // Function to sell an item to customer
    public boolean orchestrateSell(int day, String clerkName, Inventory inventoryObj, CashRegister cashRegisterObj, Customer customerObj, HashMap<Integer, List<Item>> listItemsSold, String storeName){
        String buyItemName = customerObj.getBuyItemName();
        List<Item> items = inventoryObj.getItemsList();
        for(Item item : items) {
            if(Objects.equals(item.getClass().getName(), buyItemName)) {
                double initialProb = 50; //First probability of selling
                double secondProb = 75; //Second probability of selling if customer doesn't buy first time.
                if(Objects.equals(item.getClass().getSuperclass().getName(), "Players")){
                    //Typecasting to access item
                    Players p = (Players) item;
                    if(p.isEqualized()){
                        //Adjusted sale probabilities accordingly
                        initialProb = 50*1.10;
                        secondProb = 75*1.10;
                    }
                }

                if(Objects.equals(item.getClass().getSuperclass().getName(), "Stringed")){
                    //Typecasting to access item
                    Stringed s = (Stringed) item;
                    if(s.isTuned()){
                        //Adjusted sale probabilities accordingly
                        initialProb = 50*1.15;
                        secondProb = 75*1.15;
                    }
                }

                if(Objects.equals(item.getClass().getSuperclass().getName(), "Wind")){
                    //Typecasting to access item
                    Wind w = (Wind) item;
                    if(w.isAdjusted()){
                        //Adjusted sale probabilities accordingly
                        initialProb = 50*1.20;
                        secondProb = 75*1.20;
                    }
                }
                if(OuterUtils.Utils.getRandomProbability(initialProb)) {
                    cashRegisterObj.addMoney(item.getListPrice());
                    item.setSalePrice(item.getListPrice());
                    item.setDaySold(day);
                    inventoryObj.deleteInventory(item);
                    // code auto generated from intelliJ suggestion
                    listItemsSold.computeIfAbsent(day, k -> new ArrayList<>());
                    listItemsSold.get(day).add(item);
                    announceSelling(clerkName,item.getClass().getName(), customerObj.getId(),item.getSalePrice(), 0 , storeName);
                    if(Objects.equals(item.getClass().getSuperclass().getName(), "Stringed")){
                        //Chance of additional items to be sold if stringed instrument is sold.
                        Stringed stringed = (Stringed) item;
                        boolean isElectric = stringed.isElectric();
                        double multiplier = 1.0;
                        if(!isElectric){
                            multiplier = 0.9; //Sale percentage decreases by 10% if stringed instrument is not electric.
                        }
                        if(OuterUtils.Utils.getRandomProbability(20 * multiplier)) {
                            DecoratingItem gigBag = new AddGigBag(inventoryObj, listItemsSold, cashRegisterObj, day);
                            //Get the additional item sold(if any)
                            if(gigBag.getIsItemSoldFromInventory()){
                                announceSellingAdditionalItem(clerkName, gigBag.getSoldItem().getClass().getName(), customerObj.getId(), gigBag.getSoldItem().getSalePrice(), 0, storeName);
                            }
                        }
                        if(OuterUtils.Utils.getRandomProbability(40 * multiplier)) {
                            int numberOfStrings = OuterUtils.Utils.getRandomInt(1,4);
                            for(int i =0; i<= numberOfStrings; i++) {
                                DecoratingItem string = new AddStrings(inventoryObj, listItemsSold, cashRegisterObj, day);
                                //Get the additional item sold(if any)
                                if (string.getIsItemSoldFromInventory()) {
                                    announceSellingAdditionalItem(clerkName, string.getSoldItem().getClass().getName(), customerObj.getId(), string.getSoldItem().getSalePrice(), 0, storeName);
                                }
                            }
                        }
                        if(OuterUtils.Utils.getRandomProbability(30 * multiplier)) {
                            int numberOfCables = OuterUtils.Utils.getRandomInt(1,3);
                            for(int i =0; i<= numberOfCables; i++) {
                                DecoratingItem cable = new AddCables(inventoryObj, listItemsSold, cashRegisterObj, day);
                                //Get the additional item sold(if any)
                                if (cable.getIsItemSoldFromInventory()) {
                                    announceSellingAdditionalItem(clerkName, cable.getSoldItem().getClass().getName(), customerObj.getId(), cable.getSoldItem().getSalePrice(), 0, storeName);
                                }
                            }
                        }
                        if(OuterUtils.Utils.getRandomProbability(25 * multiplier)) {
                            DecoratingItem practiceAmp = new AddPracticeAmps(inventoryObj, listItemsSold, cashRegisterObj, day);
                            //Get the additional item sold(if any)
                            if (practiceAmp.getIsItemSoldFromInventory()) {
                                announceSellingAdditionalItem(clerkName, practiceAmp.getSoldItem().getClass().getName(), customerObj.getId(), practiceAmp.getSoldItem().getSalePrice(), 0, storeName);
                            }
                        }
                    }
                    return true;
                }
                else if(OuterUtils.Utils.getRandomProbability(secondProb)){
                        cashRegisterObj.addMoney((0.9)*item.getListPrice());
                        item.setSalePrice((0.9)*item.getListPrice());
                        item.setDaySold(day);
                        inventoryObj.deleteInventory(item);
                        listItemsSold.computeIfAbsent(day, k -> new ArrayList<>());
                        listItemsSold.get(day).add(item);
                        announceSelling(clerkName,item.getClass().getName(), customerObj.getId(),item.getSalePrice(), 10, storeName);
                        if(Objects.equals(item.getClass().getSuperclass().getName(), "Stringed")){
                            //Chance of additional items to be sold if stringed instrument is sold.
                            Stringed stringed = (Stringed) item;
                            boolean isElectric = stringed.isElectric();
                            double multiplier = 1.0;
                            if(isElectric){
                                multiplier = 0.9;//Sale percentage decreases by 10% if stringed instrument is not electric.
                            }
                            if(OuterUtils.Utils.getRandomProbability(20 * multiplier)) {
                                DecoratingItem gigBag = new AddGigBag(inventoryObj, listItemsSold, cashRegisterObj, day);
                                //Get the additional item sold(if any)
                                if(gigBag.getIsItemSoldFromInventory()){
                                    announceSellingAdditionalItem(clerkName, gigBag.getSoldItem().getClass().getName(), customerObj.getId(), gigBag.getSoldItem().getSalePrice(), 0, storeName);
                                }
                            }
                            if(OuterUtils.Utils.getRandomProbability(40 * multiplier)) {
                                int numberOfStrings = OuterUtils.Utils.getRandomInt(1,4);
                                for(int i =0; i<= numberOfStrings; i++) {
                                    DecoratingItem string = new AddGigBag(inventoryObj, listItemsSold, cashRegisterObj, day);
                                    //Get the additional item sold(if any)
                                    if (string.getIsItemSoldFromInventory()) {
                                        announceSellingAdditionalItem(clerkName, string.getSoldItem().getClass().getName(), customerObj.getId(), string.getSoldItem().getSalePrice(), 0, storeName);
                                    }
                                }
                            }
                            if(OuterUtils.Utils.getRandomProbability(30 * multiplier)) {
                                int numberOfCables = OuterUtils.Utils.getRandomInt(1,3);
                                for(int i =0; i<= numberOfCables; i++) {
                                    DecoratingItem cable = new AddCables(inventoryObj, listItemsSold, cashRegisterObj, day);
                                    //Get the additional item sold(if any)
                                    if (cable.getIsItemSoldFromInventory()) {
                                        announceSellingAdditionalItem(clerkName, cable.getSoldItem().getClass().getName(), customerObj.getId(), cable.getSoldItem().getSalePrice(), 0, storeName);
                                    }
                                }
                            }
                            if(OuterUtils.Utils.getRandomProbability(25 * multiplier)) {
                                DecoratingItem practiceAmp = new AddPracticeAmps(inventoryObj, listItemsSold, cashRegisterObj, day);
                                //Get the additional item sold(if any)
                                if (practiceAmp.getIsItemSoldFromInventory()) {
                                    announceSellingAdditionalItem(clerkName, practiceAmp.getSoldItem().getClass().getName(), customerObj.getId(), practiceAmp.getSoldItem().getSalePrice(), 0, storeName);
                                }
                            }
                        }
                        return true;
                    }
                else{
                    System.out.println(storeName+": Customer "+customerObj.getId()+ " left without buying "+item.getClass().getName()+" even though it was present");
                    return false;
                }
            }
        }
        System.out.println(storeName+": Customer "+customerObj.getId()+ " wanted to buy a "+buyItemName+"  but none were in inventory, so they left.");
        return false;
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
    public boolean orchestrateBuy(int day, Inventory inventoryObj, CashRegister cashRegisterObj, Customer customerObj, String clerkName, CheckRegister checkRegisterObj, String storeName){
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
                System.out.println(storeName+": Store received a  "+addItem.getClass().getName()+ " from customer "+customerObj.getId()+ ", but store will no longer buy clothes from customer");
                return true;
            }}
        // Executing normal buy operation
        if(OuterUtils.Utils.getRandomProbability(50)) {
            addItem.setPurchasePrice(purchasePrice);
            addItem.setListPrice(2*purchasePrice);
            // Checking if the register has enough money, else withdrawing from bank
            if(cashRegisterObj.getMoney() < purchasePrice) {
                checkRegisterObj.checkBalanceInRegister(day, cashRegisterObj, storeName);
            }
                inventoryObj.addInventory(addItem);
                cashRegisterObj.removeMoney(purchasePrice);
                announceBuying(clerkName, addItem.getClass().getName(), customerObj.getId(), purchasePrice, currCondition, addItem.getNewOrUsed(), storeName);
                return true;
        }
        else if(OuterUtils.Utils.getRandomProbability(75)) {
            purchasePrice = (1.1) * purchasePrice;
            addItem.setPurchasePrice(purchasePrice);
            addItem.setListPrice(2 * purchasePrice);
            // Checking if the register has enough money, else withdrawing from bank
            if(cashRegisterObj.getMoney() > purchasePrice) {
                checkRegisterObj.checkBalanceInRegister(day, cashRegisterObj, storeName);
            }
                inventoryObj.addInventory(addItem);
                cashRegisterObj.removeMoney(purchasePrice);
                announceBuying(clerkName, addItem.getClass().getName(), customerObj.getId(), purchasePrice, currCondition, addItem.getNewOrUsed(), storeName);
                return true;
        }
        else{
            System.out.println(storeName+": Customer "+customerObj.getId()+ " wanted to sell a "+addItem.getClass().getName()+"  but did not sell even after providing discount");
            return false;
        }
    }

    public void announceSelling(String clerkName, String itemName, int customerNumber, double itemCost, int discountPercentage, String storeName){
        System.out.println(storeName+": " +clerkName + " sold a " + itemName + " to Customer " + customerNumber + " for $" + itemCost + " after a "+discountPercentage+"% discount");
    }

    //Announcement for selling additional item after stringed instrument is sold.
    public void announceSellingAdditionalItem(String clerkName, String itemName, int customerNumber, double itemCost, int discountPercentage, String storeName){
        System.out.println(storeName+": " +clerkName + " sold an additional item " + itemName + " to Customer " + customerNumber + " for $" + itemCost + " after a "+discountPercentage+"% discount");
    }

    public void announceBuying(String clerkName, String itemName, int customerNumber, double itemCost, String condition, String age, String storeName){
        System.out.println(storeName+": " +clerkName + " bought a " + condition +" condition "+  age + " " + itemName + " from Customer " + customerNumber + " for " + itemCost);
    }

}
