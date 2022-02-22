import java.util.ArrayList;
import java.util.List;

public class Tracker implements MyListener{
    List<Clerk> clerkObjList;

    Tracker(List<Clerk> clerkObjList){
       this.clerkObjList = clerkObjList;
    }

    @Override
    public void notifyEvent(String event, int day) {
        System.out.println("Tracker: Day "+day);
        System.out.println("Clerk          Items Sold            Items Purchased          Items Damagaed");
        System.out.println(clerkObjList.get(0).name+"                    "+clerkObjList.get(0).itemsSold+"                   "+clerkObjList.get(0).itemsPurchased+"                   "+clerkObjList.get(0).itemsDamaged);
        System.out.println(clerkObjList.get(1).name+"                    "+clerkObjList.get(1).itemsSold+"                   "+clerkObjList.get(1).itemsPurchased+"                   "+clerkObjList.get(1).itemsDamaged);
        System.out.println(clerkObjList.get(2).name+"                    "+clerkObjList.get(2).itemsSold+"                   "+clerkObjList.get(2).itemsPurchased+"                   "+clerkObjList.get(2).itemsDamaged);
    }
}
