public interface SimulationCommandInterface {
    void selectStore(String s, int day);
    void getClerkName();
    void getCurrentTime();
    void sellItem(int day);
    void buyItem(int day);
    void closeUpStore(int day);
}
