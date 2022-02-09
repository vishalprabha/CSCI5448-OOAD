import java.util.List;

public class MusicStore {
    private Delivery deliveryObj;
    private Inventory inventoryObj;
    private List<Clerk> clerkObjList;
    private CashRegister cashRegisterObj;

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

    List<Customer> listCustomerObj;

    void MusicStore(){

    }
    void initializeItems(){

    }

    public void simulate(int days){


    }


}
