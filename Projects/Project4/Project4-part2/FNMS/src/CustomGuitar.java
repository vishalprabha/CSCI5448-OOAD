public abstract class CustomGuitar {
    double price;
    // Getter
    public double getPrice() {
        return price;
    }
    // Setter
    public void setPrice(float price) {
        this.price = price;
    }
}

abstract class Bridge extends CustomGuitar{ }
class NorthSideBridge1 extends Bridge{
    NorthSideBridge1(double price){
        this.price = price;
    }
}
class NorthSideBridge2 extends Bridge{
    NorthSideBridge2(double price){
        this.price = price;
    }
}
class NorthSideBridge3 extends Bridge{
    NorthSideBridge3(double price){
        this.price = price;
    }
}
class SouthSideBridge1 extends Bridge{
    SouthSideBridge1(double price){
        this.price = price;
    }
}
class SouthSideBridge2 extends Bridge{
    SouthSideBridge2(double price){
        this.price = price;
    }
}
class SouthSideBridge3 extends Bridge{
    SouthSideBridge3(double price){
        this.price = price;
    }
}

abstract class KnobSet extends CustomGuitar{ }
class NorthSideKnobSet1 extends KnobSet{
    NorthSideKnobSet1(double price){
        this.price = price;
    }
}
class NorthSideKnobSet2 extends KnobSet{
    NorthSideKnobSet2(double price){
        this.price = price;
    }
}
class NorthSideKnobSet3 extends KnobSet{
    NorthSideKnobSet3(double price){
        this.price = price;
    }
}
class SouthSideKnobSet1 extends KnobSet{
    SouthSideKnobSet1(double price){
        this.price = price;
    }
}
class SouthSideKnobSet2 extends KnobSet{
    SouthSideKnobSet2(double price){
        this.price = price;
    }
}
class SouthSideKnobSet3 extends KnobSet{
    SouthSideKnobSet3(double price){
        this.price = price;
    }
}

abstract class Covers extends CustomGuitar{ }
class NorthSideCovers1 extends Covers{
    NorthSideCovers1(double price){
        this.price = price;
    }
}
class NorthSideCovers2 extends Covers{
    NorthSideCovers2(double price){
        this.price = price;
    }
}
class NorthSideCovers3 extends Covers{
    NorthSideCovers3(double price){
        this.price = price;
    }
}
class SouthSideCovers1 extends Covers{
    SouthSideCovers1(double price){
        this.price = price;
    }
}
class SouthSideCovers2 extends Covers{
    SouthSideCovers2(double price){
        this.price = price;
    }
}
class SouthSideCovers3 extends Covers{
    SouthSideCovers3(double price){
        this.price = price;
    }
}

abstract class Neck extends CustomGuitar{ }
class NorthSideNeck1 extends Neck{
    NorthSideNeck1(double price){
        this.price = price;
    }
}
class NorthSideNeck2 extends Neck{
    NorthSideNeck2(double price){
        this.price = price;
    }
}
class NorthSideNeck3 extends Neck{
    NorthSideNeck3(double price){
        this.price = price;
    }
}
class SouthSideNeck1 extends Neck{
    SouthSideNeck1(double price){
        this.price = price;
    }
}
class SouthSideNeck2 extends Neck{
    SouthSideNeck2(double price){
        this.price = price;
    }
}
class SouthSideNeck3 extends Neck{
    SouthSideNeck3(double price){
        this.price = price;
    }
}

abstract class PickGuard extends CustomGuitar{ }
class NorthSidePickGuard1 extends PickGuard{
    NorthSidePickGuard1(double price){
        this.price = price;
    }
}
class NorthSidePickGuard2 extends PickGuard{
    NorthSidePickGuard2(double price){
        this.price = price;
    }
}
class NorthSidePickGuard3 extends PickGuard{
    NorthSidePickGuard3(double price){
        this.price = price;
    }
}
class SouthSidePickGuard1 extends PickGuard{
    SouthSidePickGuard1(double price){
        this.price = price;
    }
}
class SouthSidePickGuard2 extends PickGuard{
    SouthSidePickGuard2(double price){
        this.price = price;
    }
}
class SouthSidePickGuard3 extends PickGuard{
    SouthSidePickGuard3(double price){
        this.price = price;
    }
}

abstract class PickUps extends CustomGuitar{ }
class NorthSidePickUps1 extends PickUps{
    NorthSidePickUps1(double price){
        this.price = price;
    }
}
class NorthSidePickUps2 extends PickUps{
    NorthSidePickUps2(double price){
        this.price = price;
    }
}
class NorthSidePickUps3 extends PickUps{
    NorthSidePickUps3(double price){
        this.price = price;
    }
}
class SouthSidePickUps1 extends PickUps{
    SouthSidePickUps1(double price){
        this.price = price;
    }
}
class SouthSidePickUps2 extends PickUps{
    SouthSidePickUps2(double price){
        this.price = price;
    }
}
class SouthSidePickUps3 extends PickUps{
    SouthSidePickUps3(double price){
        this.price = price;
    }
}
