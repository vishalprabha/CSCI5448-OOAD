import java.util.ArrayList;
import java.util.List;

public class Announcer {
    private List<MyListener> listeners = new ArrayList<MyListener>();

    public void addListener(MyListener toAdd) {
        listeners.add(toAdd);
    }

    public void publishEvent(String event,int day) {


        // Notify everybody that may be interested.
        for (MyListener hl : listeners)
            hl.notifyEvent(event, day);
    }
}
