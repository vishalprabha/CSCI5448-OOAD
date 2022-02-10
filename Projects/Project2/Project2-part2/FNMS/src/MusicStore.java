import java.util.*;

public class MusicStore {
    private Delivery deliveryObj;
    private Inventory inventoryObj;
    private List<Clerk> clerkObjList;
    private CashRegister cashRegisterObj;
    private List<Customer> listCustomerObj;

    public Delivery getDeliveryObj() {
        return deliveryObj;
    }

    public void setDeliveryObj(Delivery deliveryObj) {
        this.deliveryObj = deliveryObj;
    }

    public Inventory getInventoryObj() {
        return inventoryObj;
    }

    public void setInventoryObj(Inventory inventoryObj) {
        this.inventoryObj = inventoryObj;
    }

    public List<Clerk> getClerkObjList() {
        return clerkObjList;
    }

    public void setClerkObjList(List<Clerk> clerkObjList) {
        this.clerkObjList = clerkObjList;
    }

    public CashRegister getCashRegisterObj() {
        return cashRegisterObj;
    }

    public void setCashRegisterObj(CashRegister cashRegisterObj) {
        this.cashRegisterObj = cashRegisterObj;
    }

    public List<Customer> getListCustomerObj() {
        return listCustomerObj;
    }

    public void setListCustomerObj(List<Customer> listCustomerObj) {
        this.listCustomerObj = listCustomerObj;
    }

    MusicStore(){
        clerkObjList = new ArrayList<>();
        deliveryObj = new Delivery();
        // initializing cash resgister money with 0 at the start
        cashRegisterObj = new CashRegister(0, 0);
        // Initializing inventory with 51 Item objects
        inventoryObj = new Inventory();
        // Creating Shaggy clerk object
        clerkObjList.add(new Clerk(inventoryObj, deliveryObj, cashRegisterObj, 20, "Shaggy"));
        // Creating Velma clerk object
        clerkObjList.add(new Clerk(inventoryObj, deliveryObj, cashRegisterObj, 5, "Velma"));
        // Creating Customer list for holding customers arriving in a day
        listCustomerObj =  new ArrayList<>();

    }

    public void simulate(int days){

        int randomNumberCustomers;
        String itemType;
        Clerk clerkObj;
        for( int day=1; day <= days; day ++)
        {
            if(day%7 == 0){
                System.out.println("It's a sunday, the store is closed!");
                continue;
            }
            // Customer ID count
            int count = 0;
            // Generate random 4-10 customer for buying
            randomNumberCustomers = OuterUtils.Utils.getRandomInt(4, 10);
            // Creating customer objects and append to customer list
            for(int buyingCustomers=0; buyingCustomers < randomNumberCustomers; buyingCustomers++){
                // Generate random itemtype to buy
                itemType = OuterUtils.Utils.getRandomItemTypes();
                count += 1;
                Customer buyCustomer = new Customer(count, "Buyer", itemType, null);
                listCustomerObj.add(buyCustomer);
            }
            // Generate random 1-4 customer for selling
            randomNumberCustomers = OuterUtils.Utils.getRandomInt(1, 4);
            // Creating customer objects and appending to customer list
            for(int sellingCustomer=0; sellingCustomer < randomNumberCustomers; sellingCustomer++){
                // Item class object
                Item itemObj;
                // Generate random itemtype to sell
                itemType = OuterUtils.Utils.getRandomItemTypes();
                // Generate random amount
                double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                // Can approach it better but due to time constraints used an if else ladder to create item objects
                // The purchase prices are randomly assigned here, but the protocol followed by customer to sell is followed as per the question description
                if(Objects.equals(itemType, "PaperScore")){
                    itemObj = new PaperScore(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(),OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
                }
                else if(Objects.equals(itemType, "CD")){
                    itemObj = new CD(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
                }
                else if(Objects.equals(itemType, "Vinyl")){
                    itemObj = new Vinyl(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
                }
                else if(Objects.equals(itemType, "PlayersCD")){
                    itemObj = new PlayersCD(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition());
                }
                else if(Objects.equals(itemType, "RecordPlayer")){
                    itemObj = new RecordPlayer(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition());
                }
                else if(Objects.equals(itemType, "MP3")){
                    itemObj = new MP3(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition());
                }
                else if(Objects.equals(itemType, "Guitar")){
                    itemObj = new Guitar(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition());
                }
                else if(Objects.equals(itemType, "Bass")){
                    itemObj = new Bass(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition());
                }
                else if(Objects.equals(itemType, "Mandolin")){
                    itemObj = new Mandolin(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition());
                }
                else if(Objects.equals(itemType, "Flute")){
                    itemObj = new Flute(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName());
                }
                else if(Objects.equals(itemType, "Harmonica")){
                    itemObj = new Harmonica(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName());
                }
                else if(Objects.equals(itemType, "Hats")){
                    itemObj = new Hats(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomSize());
                }
                else if(Objects.equals(itemType, "Shirts")){
                    itemObj = new Shirts(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomSize());
                }
                else if(Objects.equals(itemType, "Bandanas")){
                    itemObj = new Bandanas(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition());
                }
                else if(Objects.equals(itemType, "PracticeAmps")){
                    itemObj = new PracticeAmps(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomInt(1,10));
                }
                else if(Objects.equals(itemType, "Cables")){
                    itemObj = new Cables(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomInt(1,10));
                }
                else{
                    itemObj = new Strings(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName());
                }
                count +=1;
                Customer sellCustomer = new Customer(count, "Seller", itemType, itemObj);
                listCustomerObj.add(sellCustomer);
            }
            // Shuffling the customer list to get randomness
            Collections.shuffle(listCustomerObj);

            // Getting a random clerk and checking if they have worked continuously
            do{
                clerkObj = OuterUtils.Utils.getRandomClerkObj(clerkObjList);
            }while(clerkObj.checkConsecutive(day));

            // Announce store arrival
            clerkObj.arriveAtStoreObj.announce(day, clerkObj.name);

            // Check the deliveries
            clerkObj.arriveAtStoreObj.checkDelivery(day, deliveryObj, inventoryObj);


            // Check the register
            clerkObj.checkRegisterObj.checkBalance(day, cashRegisterObj);

            clerkObj.doInventoryObj.checkInventory(inventoryObj, clerkObj.placeAnOrderObj, day);
            // Clean the store
            clerkObj.cleanTheStoreObj.orchestrateCleaning(clerkObj.damagePercentage, inventoryObj);
            // Leave the store
            clerkObj.leaveTheStoreObj.announce(clerkObj.name, day);

            

        }//end of days loop


    }//end of simlate function


}
