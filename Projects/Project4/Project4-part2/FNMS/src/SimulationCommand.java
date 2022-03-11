public class SimulationCommand {
    Simulation receiver;
    public SimulationCommand(Simulation receiver){
        this.receiver = receiver;
    }

    void selectStore(String s, int day){
        receiver.selectStore(s, day);
    }

    void getClerkName(){
        receiver.getClerkName();
    }

    void getCurrentTime(){
        receiver.getCurrentTime();
    }

    void sellItem(int day){
        receiver.sellItem(day);
    }
    void buyItem(int day){
        receiver.buyItem(day);
    }
    void closeUpStore(int day){
        receiver.closeUpStore(day);
    }
}
