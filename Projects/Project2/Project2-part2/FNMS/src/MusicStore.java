import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

        deliveryObj = new Delivery();
        // initializing cash resgister money with 0 at the start
        cashRegisterObj = new CashRegister(0);
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
        for( int day=0; day < days; day ++)
        {
            // Customer ID count
            int count = 0;
            // Generate random 4-10 customer for buying
            randomNumberCustomers = OuterUtils.Utils.getRandomInt(4, 10);
            // Creating customer objects and append to customer list
            for(int buyingCustomers=0; buyingCustomers < randomNumberCustomers; buyingCustomers++){
                // Generate random itemtype to buy
                itemType = OuterUtils.Utils.getRandomItemTypes();
                Customer buyCustomer = new Customer(count, "Buyer", itemType, null);
                listCustomerObj.add(buyCustomer);
            }
            // Generate random 1-4 customer for selling
            randomNumberCustomers = OuterUtils.Utils.getRandomInt(1, 4);
            // Creating customer objects and appending to customer list
            for(int buyingCustomers=0; buyingCustomers < randomNumberCustomers; buyingCustomers++){
                // Item class object
                Item itemObj;
                // Generate random itemtype to sell
                itemType = OuterUtils.Utils.getRandomItemTypes();
                // Can approach it better but due to time constraints used an if else ladder to create item objects
                if(itemType == "PaperScore"){
                    double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                    itemObj = new PaperScore(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(),OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
                }
                else{
                    double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                    itemObj = new PaperScore(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "Used", day, OuterUtils.Utils.getRandomCondition(),OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName());
                }
                Customer buyCustomer = new Customer(count, "Seller", itemType, itemObj);
                listCustomerObj.add(buyCustomer);
            }

        }


    }


}
