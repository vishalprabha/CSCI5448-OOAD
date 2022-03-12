import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FirstTest {
    @Test
    public void firstTest() {
        assertTrue(true);
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
    public void TestRemoveObserver() {
        Simulation s = new Simulation();
        s.announcer.removeListener(s.tracker);
        assertEquals(s.announcer.getObserversCount(), 0);
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

    @Test
    public void TestClerks() {
        Simulation s = new Simulation();
        s.initializeStores(1);
        assertNotEquals(s.specialClerk1, s.specialClerk2);
    }

    @Test
    public void TestInit() {
        MusicStore musicStoreObj = new MusicStore("North");
        Assert.assertNotNull(musicStoreObj);
    }

    @Test
    public void TestClerkSize() {
        MusicStore musicStoreObj = new MusicStore("");
        int size = musicStoreObj.getClerkObjList().size();
        assertTrue("", size <= 6);
    }

    @Test
    public void TestTuning0() {
        ElectronicTune electronicTune = new ElectronicTune();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
        Players cassettePlayer = new CassettePlayer(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", false);
        electronicTune.tune(cassettePlayer, "SouthStore");
        assertTrue(cassettePlayer.equalized);
    }

    @Test
    public void TestTuning1() {
        HaphazardTune haphazardTune = new HaphazardTune();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1,50);
        Players cassettePlayer = new CassettePlayer(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", 0, "excellent", false);
        assertFalse(cassettePlayer.equalized);
    }

    @Test
    public void TestFactory() {
        NorthSideFactory northSideFactory = new NorthSideFactory();
        List<Bridge> bridges=  northSideFactory.createBridge();
        assertEquals(bridges.size(),3);
    }

    @Test
    public void TestSize() {
        int r = OuterUtils.Utils.getRandomInt(10,20);
        assertTrue("", r < 20);
    }

    @Test
    public void TestItemTypes() {
        MusicStore musicStoreObj = new MusicStore("North");
        assertEquals(musicStoreObj.getInventoryObj().ItemsList.size(), 63);
    }

    @Test
    public void TestMoney() {
        Simulation s = new Simulation();
        Clerk clerkObj = new Clerk( 20, "Shaggy", new ManualTune());
        CashRegister cashRegisterObj = new CashRegister(0, 0);
        clerkObj.checkRegisterObj.checkBalance(1, cashRegisterObj, s.announcer, clerkObj.name, "storeName");
        assertTrue("Not equals", cashRegisterObj.money -  1000.0 == 0);
    }

    @Test
    public void TestCovers() {
        SouthSideFactory southSideFactory = new SouthSideFactory();
        List<Covers> covers=  southSideFactory.createCovers();
        assertEquals(covers.size(),3);
    }

}
