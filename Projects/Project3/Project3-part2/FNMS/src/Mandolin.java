public class Mandolin extends Stringed {
    //Inheritance example
    Mandolin(String name, double purchasePrice, double listPrice, String newOrUsed, int dayArrived, String condition){
        setName(name);
        setPurchasePrice(purchasePrice);
        setListPrice(listPrice);
        setNewOrUsed(newOrUsed);
        setDayArrived(dayArrived);
        setCondition(condition);
    }
}