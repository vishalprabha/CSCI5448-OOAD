public class LeaveTheStore {

    public void announce(String name, int day, Announcer announcer, String storeName){
        System.out.println(storeName+": "+name + " closed the store for day " + day +"\n");
        announcer.publishEvent(storeName+": "+name+" leaves the store ", day, storeName);
    }
}
