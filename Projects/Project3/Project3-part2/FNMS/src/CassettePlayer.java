public class CassettePlayer extends Players {
    CassettePlayer(String name, double purchasePrice, double listPrice, String newOrUsed, int dayArrived, String condition, Boolean equalized){
        setName(name);
        setPurchasePrice(purchasePrice);
        setListPrice(listPrice);
        setNewOrUsed(newOrUsed);
        setDayArrived(dayArrived);
        setCondition(condition);
        setEqualized(equalized);
    }
}