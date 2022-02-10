import java.util.ArrayList;
import java.util.List;

public class Clerk extends Staff{

    ArrayList<Integer> daysWorked = new ArrayList<>();
    Inventory inventoryObj;
    ArriveAtStore arriveAtStoreObj;
    Delivery deliveryObj;
    CashRegister cashRegisterObj;
    float damagePercentage;
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

    public void setDamagePercentage(float damagePercentage) {
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

    Clerk(Inventory inventoryObj, Delivery deliveryObj, CashRegister cashRegisterObj, float damagePercentage, String name)
    {
        setInventoryObj(inventoryObj);
        setDeliveryObj(deliveryObj);
        setCashRegisterObj(cashRegisterObj);
        setDamagePercentage(damagePercentage);
        setName(name);
        setArriveAtStoreObj(new ArriveAtStore());
        setCheckRegisterObj(new CheckRegister());
        setDoInventoryObj(new DoInventory());
        setPlaceAnOrderObj(new PlaceAnOrder());
        setOpenTheStoreObj(new OpenTheStore());
        setCleanTheStoreObj(new CleanTheStore());
        setLeaveTheStoreObj(new LeaveTheStore());
    }

    public boolean checkConsecutive(int day){
        return true;
    }

    public void arriveAtStoreOperation(){

    }

    public void checkRegisterOperation(){

    }

    public void doInventoryOperation(){

    }

    public void doOpenTheStoreOperation(List<Customer> customers){

    }

    public void doCleanTheStore(float damagePercentage, Inventory inventoryObj){

    }

    public void doLeaveTheStore(int day){

    }


}
