public class Saxaphone extends Wind {

    String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    Saxaphone(String name, double purchasePrice, double listPrice, String newOrUsed, int dayArrived, String condition, String type){
        setName(name);
        setPurchasePrice(purchasePrice);
        setListPrice(listPrice);
        setNewOrUsed(newOrUsed);
        setDayArrived(dayArrived);
        setCondition(condition);
        setType(type);
    }


}