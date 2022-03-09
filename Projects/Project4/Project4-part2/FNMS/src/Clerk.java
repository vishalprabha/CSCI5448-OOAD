import java.util.ArrayList;
//Example of abstraction
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
    TuneAlgorithm tuneObj;
    int itemsSold;
    int itemsPurchased;
    int itemsDamaged;

    public TuneAlgorithm getTuneObj() {
        return tuneObj;
    }

    public void setTuneObj(TuneAlgorithm tuneObj) {
        this.tuneObj = tuneObj;
    }

    public void setInventoryObj(Inventory inventoryObj) {
        this.inventoryObj = inventoryObj;
    }

    public void setArriveAtStoreObj(ArriveAtStore arriveAtStoreObj) {
        this.arriveAtStoreObj = arriveAtStoreObj;
    }

    public void setDeliveryObj(Delivery deliveryObj) {
        this.deliveryObj = deliveryObj;
    }

    public void setCashRegisterObj(CashRegister cashRegisterObj) {
        this.cashRegisterObj = cashRegisterObj;
    }

    public void setDamagePercentage(int damagePercentage) {
        this.damagePercentage = damagePercentage;
    }

    public void setCheckRegisterObj(CheckRegister checkRegisterObj) {
        this.checkRegisterObj = checkRegisterObj;
    }

    public void setDoInventoryObj(DoInventory doInventoryObj) {
        this.doInventoryObj = doInventoryObj;
    }

    public void setPlaceAnOrderObj(PlaceAnOrder placeAnOrderObj) {
        this.placeAnOrderObj = placeAnOrderObj;
    }

    public void setOpenTheStoreObj(OpenTheStore openTheStoreObj) {
        this.openTheStoreObj = openTheStoreObj;
    }

    public void setCleanTheStoreObj(CleanTheStore cleanTheStoreObj) {
        this.cleanTheStoreObj = cleanTheStoreObj;
    }

    public void setLeaveTheStoreObj(LeaveTheStore leaveTheStoreObj) {
        this.leaveTheStoreObj = leaveTheStoreObj;
    }

    Clerk(int damagePercentage, String name, TuneAlgorithm tuneObj)
    {

        setDamagePercentage(damagePercentage);
        setName(name);
        setArriveAtStoreObj(new ArriveAtStore());
        setCheckRegisterObj(new CheckRegister());
        setDoInventoryObj(new DoInventory());
        setPlaceAnOrderObj(new PlaceAnOrder());
        setOpenTheStoreObj(new OpenTheStore());
        setCleanTheStoreObj(new CleanTheStore());
        setLeaveTheStoreObj(new LeaveTheStore());
        setTuneObj(tuneObj);
    }
    // Function to check if clerk has worked continuously
    // Return true if they have worked for 3 days consecutively
    public boolean checkConsecutive(int day){

        if(daysWorked.contains(day)){
            return true;
        }
        for(int index = day-1; index >= day-3; day--){
            if(day <= 0){
                daysWorked.add(day);
                return false;
            }
            else if(!daysWorked.contains(index)){
                daysWorked.add(day);
                return false;
            }

        }
        return true;
    }
}
