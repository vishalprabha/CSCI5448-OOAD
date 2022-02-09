import java.util.ArrayList;

abstract class Item {
    String name;
    double purchasePrice;
    double listPrice;
    String newOrUsed;
    int dayArrived;
    String condition;
    double salePrice;
    int daySold;
    String[] conditionOptions = { "poor", "fair", "good", "very good", "excellent"};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public String getNewOrUsed() {
        return newOrUsed;
    }

    public void setNewOrUsed(String newOrUsed) {
        this.newOrUsed = newOrUsed;
    }

    public int getDayArrived() {
        return dayArrived;
    }

    public void setDayArrived(int dayArrived) {
        this.dayArrived = dayArrived;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getDaySold() {
        return daySold;
    }

    public void setDaySold(int daySold) {
        this.daySold = daySold;
    }

    public String[] getConditionOptions() {
        return conditionOptions;
    }

    public void setConditionOptions(String[] conditionOptions) {
        this.conditionOptions = conditionOptions;
    }
}









