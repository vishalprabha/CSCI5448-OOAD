import java.util.*;
//Encapsulation
public class MusicStore {
    private Delivery deliveryObj;
    private Inventory inventoryObj;
    private List<Clerk> clerkObjList;
    private CashRegister cashRegisterObj;
    private List<Customer> listCustomerObj;
    private HashMap<Integer, List<Item>> listItemsSold; //Example of identity

    public Announcer announcer;
    public Logger logger;
    public Tracker tracker;

    public HashMap<Integer, List<Item>> getListItemsSold() {
        return listItemsSold;
    }

    public void setListItemsSold(HashMap<Integer, List<Item>> listItemsSold) {
        this.listItemsSold = listItemsSold;
    }

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
        // Initializing clerkObject list
        clerkObjList = new ArrayList<>();
        // Initializing Delivery object
        deliveryObj = new Delivery();
        // Initializing soldItem list
        listItemsSold = new HashMap<>();
        // initializing cash resgister money with 0 at the start
        cashRegisterObj = new CashRegister(0, 0);
        // Initializing inventory with 51 Item objects
        inventoryObj = new Inventory();
        // Creating an array list of TuneAlgorithm objects
        List<TuneAlgorithm> tuneAlgos = new ArrayList<>();
        tuneAlgos.add(new HaphazardTune());
        tuneAlgos.add(new ManualTune());
        tuneAlgos.add(new ElectronicTune());
        // Getting a random tune to be assigned
        int choice = OuterUtils.Utils.getRandomInt(0, 2);
        // Creating Shaggy clerk object
        clerkObjList.add(new Clerk(inventoryObj, deliveryObj, cashRegisterObj, 20, "Shaggy", tuneAlgos.get(choice)));
        tuneAlgos.remove(choice);
        // Creating Velma clerk object
        choice = OuterUtils.Utils.getRandomInt(0, 1);
        clerkObjList.add(new Clerk(inventoryObj, deliveryObj, cashRegisterObj, 5, "Velma", tuneAlgos.get(choice)));
        tuneAlgos.remove(choice);
        // Creating Daphne clerk object with damage chance 10%
        clerkObjList.add(new Clerk(inventoryObj, deliveryObj, cashRegisterObj, 10, "Daphne", tuneAlgos.get(0)));
        // Creating Customer list for holding customers arriving in a day
        listCustomerObj =  new ArrayList<>();



    }

    public void simulate(int days){

        announcer= new Announcer();
        logger= new Logger();
        tracker= new Tracker(clerkObjList);
        announcer.addListener(logger);
        announcer.addListener(tracker);

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
            // Generate buying customers using poisson distribution
            randomNumberCustomers = OuterUtils.Utils.getRandomBuyCustomers();
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
                else if(Objects.equals(itemType, "Cassette")){
                    itemObj = new Cassette(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
                }
                else if(Objects.equals(itemType, "PlayersCD")){
                    itemObj = new PlayersCD(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), false);
                }
                else if(Objects.equals(itemType, "RecordPlayer")){
                    itemObj = new RecordPlayer(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), false);
                }
                else if(Objects.equals(itemType, "MP3")){
                    itemObj = new MP3(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), false);
                }
                else if(Objects.equals(itemType, "CassettePlayer")){
                    itemObj = new CassettePlayer(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), false);
                }
                else if(Objects.equals(itemType, "Guitar")){
                    itemObj = new Guitar(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomBoolean(), false);
                }
                else if(Objects.equals(itemType, "Bass")){
                    itemObj = new Bass(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomBoolean(), false);
                }
                else if(Objects.equals(itemType, "Mandolin")){
                    itemObj = new Mandolin(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomBoolean(), false);
                }
                else if(Objects.equals(itemType, "Flute")){
                    itemObj = new Flute(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName(), false);
                }
                else if(Objects.equals(itemType, "Harmonica")){
                    itemObj = new Harmonica(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName(), false);
                }
                else if(Objects.equals(itemType, "Saxaphone")){
                    itemObj = new Saxaphone(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName());
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
                else if(Objects.equals(itemType, "Strings")){
                    itemObj = new Strings(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName());
                }
                else{
                    itemObj = new GigBag(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition());
                }
                count +=1;
                Customer sellCustomer = new Customer(count, "Seller", itemType, itemObj);
                listCustomerObj.add(sellCustomer);
            }
            // Shuffling the customer list to get randomness
            Collections.shuffle(listCustomerObj);
            // initialize that every clerk as not sick at the beginning of each day
            for(Clerk staffMember: clerkObjList){
                staffMember.isSick = false;
            }
            // Flag to keep track that only one clerk falls sick
            boolean isSickAlreadySet = false;
            // Getting a random clerk and checking if they have worked continuously and is not sick
            do{

                clerkObj = OuterUtils.Utils.getRandomClerkObj(clerkObjList);
                if(! isSickAlreadySet) {
                    if (OuterUtils.Utils.getRandomProbability(10)) {
                        clerkObj.isSick = true;
                        isSickAlreadySet = true;
                        System.out.println("Clerk " +clerkObj.name+ " has fallen sick and another clerk is going to replace him/her today");
                    }
                }
            }while(clerkObj.checkConsecutive(day) || clerkObj.isSick);

            // Announce store arrival
            clerkObj.arriveAtStoreObj.announce(day, clerkObj.name, announcer);

            // Check the deliveries
            clerkObj.arriveAtStoreObj.checkDelivery(day, deliveryObj, inventoryObj, announcer, clerkObj.name);

            // Check the register
            clerkObj.checkRegisterObj.checkBalance(day, cashRegisterObj, announcer, clerkObj.name);

            // Check inventory and place and order
            int damagedWhileTuning = clerkObj.doInventoryObj.checkInventory(deliveryObj, cashRegisterObj, clerkObj.checkRegisterObj, inventoryObj, clerkObj.placeAnOrderObj, day, announcer, clerkObj.name, clerkObj.tuneObj);
            clerkObj.itemsDamaged = clerkObj.itemsDamaged + damagedWhileTuning;
            // Open the store
            int beforeSell = inventoryObj.ItemsList.size();
            int beforeBuy = inventoryObj.ItemsList.size();
            int sold = 0;
            int bought = 0;
            for(Customer customer : listCustomerObj){
                if(customer.getCustomerType().equals("Buyer")){
                    if(clerkObj.openTheStoreObj.orchestrateSell(day, clerkObj.name, inventoryObj, cashRegisterObj, customer, listItemsSold))
                        sold++;
                }
                else{
                    if(clerkObj.openTheStoreObj.orchestrateBuy(day, inventoryObj, cashRegisterObj, customer, clerkObj.getName(), clerkObj.checkRegisterObj))
                        bought++;
                }
            }
            clerkObj.itemsSold = clerkObj.itemsSold + sold;
            clerkObj.itemsPurchased = clerkObj.itemsPurchased + bought;
            announcer.publishEvent(clerkObj.name + " sold " + sold + " Items", day);
            announcer.publishEvent(clerkObj.name + " bought " + bought + " Items", day);
            // Clean the store
            int damaged = clerkObj.cleanTheStoreObj.orchestrateCleaning(clerkObj.damagePercentage, inventoryObj, announcer, clerkObj.name, day);
            clerkObj.itemsDamaged = clerkObj.itemsDamaged + damaged;
            // Leave the store
            clerkObj.leaveTheStoreObj.announce(clerkObj.name, day, announcer);
            //announcer.publishEvent("final", day);

        }//end of days loop

        finish(days);
    }//end of simlate function

    //Final output of values
    public void finish(int days){
        System.out.println("\n" +days+" days simulation ended");
        inventoryObj.getItemsList().size();
        double totalPurchasePrice = 0.0;
        for(Item item: inventoryObj.getItemsList()){
            totalPurchasePrice += item.getPurchasePrice();
        }
        System.out.println("\nThere are "+ inventoryObj.getItemsList().size() + " items remaining with total purchase price of $"+totalPurchasePrice);
        double totalItemsSoldPrice = 0.0;
        System.out.println("List of items sold:");
        for(Map.Entry<Integer, List<Item>> e : getListItemsSold().entrySet()){
            for(Item item: e.getValue()){
                System.out.println("Item "+item.getClass().getName()+" sold on day "+e.getKey()+" for price $"+item.getSalePrice());
                totalItemsSoldPrice += item.getSalePrice();
            }
        }
        System.out.println("\nTotal amount of sold prices is $"+totalItemsSoldPrice);
        System.out.println("The total amount of money drawn from bank is $" + cashRegisterObj.getWithdrawal());
        System.out.println("Total amount of money in cash register is $" + cashRegisterObj.getMoney());
    }

}
