import java.util.List;

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

    }

    public void simulate(int days){

        for( int index=0; index < days; index ++)
        {

        }


    }


}
