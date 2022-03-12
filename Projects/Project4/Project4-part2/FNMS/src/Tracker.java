import java.util.ArrayList;
import java.util.List;

public class Tracker implements MyListener{
    List<Clerk> clerkObjList;

    Tracker(List<Clerk> clerkObjList){
       this.clerkObjList = clerkObjList;
    }

    private static Tracker obj = null;
    private Tracker() {}
    public static Tracker getInstance(List<Clerk> clerkObjList) {
        if(obj == null)
            obj = new Tracker(clerkObjList);
        return obj;
    }

    @Override
    public void notifyEvent(String event, int day, String name) {
        String strarray[] = event.split(" ");
        if (strarray[2].equals("leaves")) {
            System.out.println("Tracker: Day " + day);
            System.out.println("Clerk          Items Sold            Items Purchased          Items Damaged");
            System.out.println(clerkObjList.get(0).name + "                    " + clerkObjList.get(0).itemsSold + "                   " + clerkObjList.get(0).itemsPurchased + "                   " + clerkObjList.get(0).itemsDamaged);
            System.out.println(clerkObjList.get(1).name + "                    " + clerkObjList.get(1).itemsSold + "                   " + clerkObjList.get(1).itemsPurchased + "                   " + clerkObjList.get(1).itemsDamaged);
            System.out.println(clerkObjList.get(2).name + "                    " + clerkObjList.get(2).itemsSold + "                   " + clerkObjList.get(2).itemsPurchased + "                   " + clerkObjList.get(2).itemsDamaged);
            System.out.println(clerkObjList.get(3).name + "                    " + clerkObjList.get(3).itemsSold + "                   " + clerkObjList.get(3).itemsPurchased + "                   " + clerkObjList.get(3).itemsDamaged);
            System.out.println(clerkObjList.get(4).name + "                    " + clerkObjList.get(4).itemsSold + "                   " + clerkObjList.get(4).itemsPurchased + "                   " + clerkObjList.get(4).itemsDamaged);
            System.out.println(clerkObjList.get(5).name + "                    " + clerkObjList.get(5).itemsSold + "                   " + clerkObjList.get(5).itemsPurchased + "                   " + clerkObjList.get(5).itemsDamaged);
        }
    }
}
