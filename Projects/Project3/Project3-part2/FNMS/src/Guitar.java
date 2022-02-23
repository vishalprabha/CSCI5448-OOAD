public class Guitar extends Stringed {
    Guitar(String name, double purchasePrice, double listPrice, String newOrUsed, int dayArrived, String condition, boolean electric, boolean tuned){
        setName(name);
        setPurchasePrice(purchasePrice);
        setListPrice(listPrice);
        setNewOrUsed(newOrUsed);
        setDayArrived(dayArrived);
        setCondition(condition);
        setElectric(electric);
        setTuned(tuned);
    }
}