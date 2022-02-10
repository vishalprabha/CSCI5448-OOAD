import java.util.ArrayList;
import java.util.List;

public class Clerk extends Staff{

    ArrayList<Integer> daysWorked = new ArrayList<>();
    Inventory inventoryObj;
    ArriveAtStore arriveAtStoreObj;
    Delivery deliveryObj;
    CashRegister cashRegisterObj;
    int damagePercentage;
    CheckRegister checkRegisterObj;
    DoInventory doInventoryObj;
    PlaceAnOrder placeAnOrderObj;
    OpenTheStore openTheStoreObj;
    CleanTheStore cleanTheStoreObj;
    LeaveTheStore leaveTheStoreObj;


    public ArrayList<Integer> getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(ArrayList<Integer> daysWorked) {
        this.daysWorked = daysWorked;
    }

    public Inventory getInventoryObj() {
        return inventoryObj;
    }

    public void setInventoryObj(Inventory inventoryObj) {
        this.inventoryObj = inventoryObj;
    }

    public ArriveAtStore getArriveAtStoreObj() {
        return arriveAtStoreObj;
    }

    public void setArriveAtStoreObj(ArriveAtStore arriveAtStoreObj) {
        this.arriveAtStoreObj = arriveAtStoreObj;
    }

    public Delivery getDeliveryObj() {
        return deliveryObj;
    }

    public void setDeliveryObj(Delivery deliveryObj) {
        this.deliveryObj = deliveryObj;
    }

    public CashRegister getCashRegisterObj() {
        return cashRegisterObj;
    }

    public void setCashRegisterObj(CashRegister cashRegisterObj) {
        this.cashRegisterObj = cashRegisterObj;
    }

    public float getDamagePercentage() {
        return damagePercentage;
    }

    public void setDamagePercentage(int damagePercentage) {
        this.damagePercentage = damagePercentage;
    }

    public CheckRegister getCheckRegisterObj() {
        return checkRegisterObj;
    }

    public void setCheckRegisterObj(CheckRegister checkRegisterObj) {
        this.checkRegisterObj = checkRegisterObj;
    }

    public DoInventory getDoInventoryObj() {
        return doInventoryObj;
    }

    public void setDoInventoryObj(DoInventory doInventoryObj) {
        this.doInventoryObj = doInventoryObj;
    }

    public PlaceAnOrder getPlaceAnOrderObj() {
        return placeAnOrderObj;
    }

    public void setPlaceAnOrderObj(PlaceAnOrder placeAnOrderObj) {
        this.placeAnOrderObj = placeAnOrderObj;
    }

    public OpenTheStore getOpenTheStoreObj() {
        return openTheStoreObj;
    }

    public void setOpenTheStoreObj(OpenTheStore openTheStoreObj) {
        this.openTheStoreObj = openTheStoreObj;
    }

    public CleanTheStore getCleanTheStoreObj() {
        return cleanTheStoreObj;
    }

    public void setCleanTheStoreObj(CleanTheStore cleanTheStoreObj) {
        this.cleanTheStoreObj = cleanTheStoreObj;
    }

    public LeaveTheStore getLeaveTheStoreObj() {
        return leaveTheStoreObj;
    }

    public void setLeaveTheStoreObj(LeaveTheStore leaveTheStoreObj) {
        this.leaveTheStoreObj = leaveTheStoreObj;
    }

    Clerk(Inventory inventoryObj, Delivery deliveryObj, CashRegister cashRegisterObj, int damagePercentage, String name)
    {
        setInventoryObj(inventoryObj);
        setDeliveryObj(deliveryObj);
        setCashRegisterObj(cashRegisterObj);
        setDamagePercentage(damagePercentage);
        setName(name);
        setArriveAtStoreObj(new ArriveAtStore());
        setCheckRegisterObj(new CheckRegister());
        setDoInventoryObj(new DoInventory(deliveryObj, cashRegisterObj, checkRegisterObj));
        setPlaceAnOrderObj(new PlaceAnOrder());
        setOpenTheStoreObj(new OpenTheStore());
        setCleanTheStoreObj(new CleanTheStore());
        setLeaveTheStoreObj(new LeaveTheStore());
    }
    // Function to check if clerk has worked continuously
    // Return true if they have worked for 3 days consecutively
    public boolean checkConsecutive(int day){

        for(int index = day-1; index >= day-3; day--){
            if(day <= 0){
                return false;
            }
            else if(!daysWorked.contains(index)){
                return false;
            }

        }
        return true;
    }
}
