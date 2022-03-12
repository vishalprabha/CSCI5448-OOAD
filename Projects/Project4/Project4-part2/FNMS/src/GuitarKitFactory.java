import java.util.List;

public interface GuitarKitFactory {
    public List<Bridge> createBridge();
    public List<Covers> createCovers();
    public List<KnobSet> createKnobSet();
    public List<Neck> createNeck();
    public List<PickGuard> createPickGuard();
    public List<PickUps> createPickUps();
}
