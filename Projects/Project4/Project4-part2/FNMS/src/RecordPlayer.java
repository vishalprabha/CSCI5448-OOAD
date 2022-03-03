public class RecordPlayer extends Players {
    RecordPlayer(String name, double purchasePrice, double listPrice, String newOrUsed, int dayArrived, String condition, boolean equalized){
        setName(name);
        setPurchasePrice(purchasePrice);
        setListPrice(listPrice);
        setNewOrUsed(newOrUsed);
        setDayArrived(dayArrived);
        setCondition(condition);
        setEqualized(equalized);
    }
}