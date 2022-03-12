import java.util.ArrayList;
import java.util.List;

public class SouthSideFactory implements GuitarKitFactory{
    public List<Bridge> createBridge() {
        ArrayList<Bridge> bridgeList = new ArrayList<>();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        bridgeList.add(new SouthSideBridge1(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        bridgeList.add(new SouthSideBridge2(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        bridgeList.add(new SouthSideBridge3(purchasePrice));
        return bridgeList;
    }
    public List<KnobSet> createKnobSet() {
        ArrayList<KnobSet> knobList = new ArrayList<>();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        knobList.add(new SouthSideKnobSet1(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        knobList.add(new SouthSideKnobSet2(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        knobList.add(new SouthSideKnobSet3(purchasePrice));
        return knobList;
    }
    public List<Covers> createCovers() {
        ArrayList<Covers> coverList = new ArrayList<>();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        coverList.add(new SouthSideCovers1(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        coverList.add(new SouthSideCovers2(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        coverList.add(new SouthSideCovers3(purchasePrice));
        return coverList;
    }
    public List<Neck> createNeck() {
        ArrayList<Neck> neckList = new ArrayList<>();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        neckList.add(new SouthSideNeck1(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        neckList.add(new SouthSideNeck2(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        neckList.add(new SouthSideNeck3(purchasePrice));
        return neckList;
    }
    public List<PickGuard> createPickGuard() {
        ArrayList<PickGuard> pickGuardList = new ArrayList<>();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        pickGuardList.add(new SouthSidePickGuard1(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        pickGuardList.add(new SouthSidePickGuard2(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        pickGuardList.add(new SouthSidePickGuard3(purchasePrice));
        return pickGuardList;
    }
    public List<PickUps> createPickUps() {
        ArrayList<PickUps> pickUpsList = new ArrayList<>();
        double purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        pickUpsList.add(new SouthSidePickUps1(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        pickUpsList.add(new SouthSidePickUps2(purchasePrice));
        purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
        pickUpsList.add(new SouthSidePickUps3(purchasePrice));
        return pickUpsList;
    }
}
