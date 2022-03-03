public class Cables extends Accessories {
    int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Cables(String name, double purchasePrice, double listPrice, String newOrUsed, int dayArrived, String condition, int length){
        setName(name);
        setPurchasePrice(purchasePrice);
        setListPrice(listPrice);
        setNewOrUsed(newOrUsed);
        setDayArrived(dayArrived);
        setCondition(condition);
        setLength(length);
    }
}