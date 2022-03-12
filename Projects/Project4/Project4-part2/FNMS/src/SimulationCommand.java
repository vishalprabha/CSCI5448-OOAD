public class SimulationCommand implements SimulationCommandInterface {
    Simulation receiver;
    public SimulationCommand(Simulation receiver){
        this.receiver = receiver;
    }
    public void selectStore(String s, int day){
        receiver.selectStore(s, day);
    }
    public void getClerkName(){
        receiver.getClerkName();
    }
    public void getCurrentTime(){
        receiver.getCurrentTime();
    }
    public void sellItem(int day){
        receiver.sellItem(day);
    }
    public void buyItem(int day){
        receiver.buyItem(day);
    }
    public void closeUpStore(int day){
        receiver.closeUpStore(day);
    }
    public void sellCustomerGuitarItem(Item item, int day, double totalValue){
        receiver.sellCustomerGuitarItem(item, day, totalValue);
    }
}
