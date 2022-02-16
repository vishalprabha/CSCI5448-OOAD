public class Shirts extends Clothing {
    char shirtSize;

    public char getShirtSize() {
        return shirtSize;
    }

    public void setShirtSize(char shirtSize) {
        this.shirtSize = shirtSize;
    }

    public Shirts(String name, double purchasePrice, double listPrice, String newOrUsed, int dayArrived, String condition, char shirtSize){
        setName(name);
        setPurchasePrice(purchasePrice);
        setListPrice(listPrice);
        setNewOrUsed(newOrUsed);
        setDayArrived(dayArrived);
        setCondition(condition);
        setShirtSize(shirtSize);
    }

}