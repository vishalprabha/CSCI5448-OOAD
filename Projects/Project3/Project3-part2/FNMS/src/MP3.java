public class MP3 extends Players {
    public MP3(String name, double purchasePrice, double listPrice, String newOrUsed, int dayArrived, String condition, boolean equalized){
        setName(name);
        setPurchasePrice(purchasePrice);
        setListPrice(listPrice);
        setNewOrUsed(newOrUsed);
        setDayArrived(dayArrived);
        setCondition(condition);
        setEqualized(equalized);
    }
}
