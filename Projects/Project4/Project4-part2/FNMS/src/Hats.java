public class Hats extends Clothing {
    char hatSize;

    public char getHatSize() {
        return hatSize;
    }

    public void setHatSize(char hatSize) {
        this.hatSize = hatSize;
    }

    public Hats(String name, double purchasePrice, double listPrice, String newOrUsed, int dayArrived, String condition, char hatSize){
        setName(name);
        setPurchasePrice(purchasePrice);
        setListPrice(listPrice);
        setNewOrUsed(newOrUsed);
        setDayArrived(dayArrived);
        setCondition(condition);
        setHatSize(hatSize);
    }


}