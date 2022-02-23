public class Harmonica extends Wind {

    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    Harmonica(String name, double purchasePrice, double listPrice, String newOrUsed, int dayArrived, String condition, String key, boolean adjusted){
        setName(name);
        setPurchasePrice(purchasePrice);
        setListPrice(listPrice);
        setNewOrUsed(newOrUsed);
        setDayArrived(dayArrived);
        setCondition(condition);
        setKey(key);
        setAdjusted(adjusted);
    }
}