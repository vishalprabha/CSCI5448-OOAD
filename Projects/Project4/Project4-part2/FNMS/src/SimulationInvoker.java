public class SimulationInvoker {
    SimulationCommand command;
    public void setCommand(SimulationCommand command){
        this.command = command;
    }
    void selectStore(String s, int day){
        command.selectStore(s, day);
    }
    void getClerkName(){
        command.getClerkName();
    }
    void getCurrentTime(){
        command.getCurrentTime();
    }
    void sellItem(int day){
        command.sellItem(day);
    }
    void buyItem(int day){
        command.buyItem(day);
    }
    void closeUpStore(int day){
        command.closeUpStore(day);
    }
    void sellCustomerGuitarItem(Item item, int day, double totalValue){
        command.sellCustomerGuitarItem(item, day, totalValue);
    }
}
