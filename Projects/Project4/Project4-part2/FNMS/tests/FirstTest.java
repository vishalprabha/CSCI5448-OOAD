import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FirstTest {
    @Test
    public void firstTest() {
        Assert.assertTrue(true);
    }


    @Test
    public void TestStoreName() {
        String north = "North";
        MusicStore a = new MusicStore(north);
        assertEquals(a.getStoreName(), north);
    }

    @Test
    public void TestObserver() {
        Simulation s = new Simulation();
        assertEquals(s.announcer.getObserversCount(), 1);
    }


    @Test
    public void TestLogInstance() {
        Logger log1, log2;
        log1 = Logger.getInstance();
        log2 = Logger.getInstance();
        assertEquals(log1, log2);
    }

    @Test
    public void TestTrackerInstance() {
        Tracker tracker1, tracker2;
        List<Clerk>  clerkObjList = new ArrayList<>();
        tracker1 = Tracker.getInstance(clerkObjList);
        tracker2 = Tracker.getInstance(clerkObjList);
        assertEquals(tracker1, tracker2);
    }

}
