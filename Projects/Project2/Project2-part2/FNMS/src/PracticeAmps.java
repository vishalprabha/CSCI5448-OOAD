public class PracticeAmps extends Accessories {
    int wattage;

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    public PracticeAmps(String name, double purchasePrice, double listPrice, String newOrUsed, int dayArrived, String condition, int wattage){
        setName(name);
        setPurchasePrice(purchasePrice);
        setListPrice(listPrice);
        setNewOrUsed(newOrUsed);
        setDayArrived(dayArrived);
        setCondition(condition);
        setWattage(wattage);
    }


}