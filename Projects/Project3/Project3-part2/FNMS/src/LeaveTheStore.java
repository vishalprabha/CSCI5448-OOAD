public class LeaveTheStore {

    public void announce(String name, int day, Announcer announcer){
        System.out.println(name + " closed the store for day " + day +"\n");
        announcer.publishEvent(name+" leaves the store ", day);
    }
}
