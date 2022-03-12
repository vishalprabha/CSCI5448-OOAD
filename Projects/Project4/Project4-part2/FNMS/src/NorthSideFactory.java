import java.util.ArrayList;
import java.util.List;

public class NorthSideFactory implements GuitarKitFactory{
    public List<Bridge> createBridge() {
        ArrayList<Bridge> bridgeList = new ArrayList<>();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        bridgeList.add(new NorthSideBridge1(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        bridgeList.add(new NorthSideBridge2(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        bridgeList.add(new NorthSideBridge3(purchasePrice));
        return bridgeList;
    }
    public List<KnobSet> createKnobSet() {
        ArrayList<KnobSet> knobList = new ArrayList<>();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        knobList.add(new NorthSideKnobSet1(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        knobList.add(new NorthSideKnobSet2(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        knobList.add(new NorthSideKnobSet3(purchasePrice));
        return knobList;
    }
    public List<Covers> createCovers() {
        ArrayList<Covers> coverList = new ArrayList<>();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        coverList.add(new NorthSideCovers1(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        coverList.add(new NorthSideCovers2(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        coverList.add(new NorthSideCovers3(purchasePrice));
        return coverList;
    }
    public List<Neck> createNeck() {
        ArrayList<Neck> neckList = new ArrayList<>();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        neckList.add(new NorthSideNeck1(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        neckList.add(new NorthSideNeck2(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        neckList.add(new NorthSideNeck3(purchasePrice));
        return neckList;
    }
    public List<PickGuard> createPickGuard() {
        ArrayList<PickGuard> pickGuardList = new ArrayList<>();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        pickGuardList.add(new NorthSidePickGuard1(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        pickGuardList.add(new NorthSidePickGuard2(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        pickGuardList.add(new NorthSidePickGuard3(purchasePrice));
        return pickGuardList;
    }
    public List<PickUps> createPickUps() {
        ArrayList<PickUps> pickUpsList = new ArrayList<>();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        pickUpsList.add(new NorthSidePickUps1(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        pickUpsList.add(new NorthSidePickUps2(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        pickUpsList.add(new NorthSidePickUps3(purchasePrice));
        return pickUpsList;
    }
}
