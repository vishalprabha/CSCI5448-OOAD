import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CleanTheStore {

    Random rand = new Random();

    public void announce(float damagePercentage, String itemType, double listPrice, String condition) {
        System.out.println(itemType + "is in " + condition + "and price dropped to " + listPrice + "after " + damagePercentage);
    }

    public int orchestrateCleaning(int damagePercentage, Inventory inventoryObj, Announcer announcer, String name, int day) {
        List<Item> items = inventoryObj.ItemsList;
        int i;
        boolean toDamage = OuterUtils.Utils.getRandomProbability(damagePercentage);
        int itemsDamaged = 0;
        if(toDamage) {
            if(items.size()== 0) {
                System.out.println("Store cleaned");
                return 0;
            }
            //Polymorphism concept
            Item damageItem = items.get(rand.nextInt(items.size()));
            String[] conditionOptions = damageItem.conditionOptions;
            damageItem.listPrice = (0.8) * (damageItem.listPrice);
            String currcondition = damageItem.condition;
            for(i=0; i< 5;i++ ) {
                if(Objects.equals(conditionOptions[i], currcondition))
                    break;
            }
            if(i==0) {
                inventoryObj.deleteInventory(damageItem);
            } else {
                damageItem.condition = conditionOptions[i - 1];
            }
            //Polymorphism
            itemsDamaged++;
            announce(damagePercentage, damageItem.getName(), damageItem.getListPrice(), damageItem.getCondition());
        }
        announcer.publishEvent("The number of items damaged during cleaning by " + name + " is " + itemsDamaged, day);
        System.out.println("Store cleaned");
        return itemsDamaged;
    }
}
