public class Customer {
    int id;
    String customerType;
    String buyItemName;
    Item sellItemObj;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getBuyItemName() {
        return buyItemName;
    }

    public void setBuyItemName(String buyItemName) {
        this.buyItemName = buyItemName;
    }

    public Item getSellItemObj() {
        return sellItemObj;
    }

    public void setSellItemObj(Item sellItemObj) {
        this.sellItemObj = sellItemObj;
    }

    Customer(int id, String customerType, String buyItemName, Item sellItemObj){
        setId(id);
        setCustomerType(customerType);
        setBuyItemName(buyItemName);
        setSellItemObj(sellItemObj);
    }

}
