import java.util.Objects;
// Manual tune changes equalized, tuned and adjusted property false to true 80% of the time and 20% vice versa
public class ManualTune implements TuneAlgorithm {
    public boolean tune(Item itemObj) {
        if (Objects.equals(itemObj.getClass().getSuperclass().getName(), "Players")) {
            Players playerObj = (Players) itemObj;
            // Checking if tune is already true and then performing respective operations
            if (playerObj.equalized) {
                if (OuterUtils.Utils.getRandomProbability(20)) {
                    playerObj.equalized = !playerObj.equalized;
                    System.out.println("The item " + itemObj.getClass().getName() + "'s equalized property changed from " + !playerObj.equalized + " to " + playerObj.equalized+ " during Manual tuning");
                    // Return true of equalized value changed from true to false
                    return !playerObj.equalized;
                }
            } else {
                // Checking if tune is already false and then performing respective operations
                if (OuterUtils.Utils.getRandomProbability(80)) {
                    playerObj.equalized = !playerObj.equalized;
                    System.out.println("The item " + itemObj.getClass().getName() + "'s equalized property changed from " + !playerObj.equalized + " to " + playerObj.equalized+ " during manual tuning");
                    return !playerObj.equalized;
                }
                System.out.println("The item " + itemObj.getClass().getName() + "'s equalized property was not changed");
                return false;
            }
        } else if (Objects.equals(itemObj.getClass().getSuperclass().getName(), "Stringed")) {
            Stringed stringObj = (Stringed) itemObj;
            // Checking if tune is already true and then performing respective operations
            if (stringObj.tuned) {
                if (OuterUtils.Utils.getRandomProbability(20)) {
                    stringObj.tuned = !stringObj.tuned;
                    System.out.println("The item " + itemObj.getClass().getName() + "'s tuned property changed from " + !stringObj.tuned + " to " + stringObj.tuned+ " during Manual tuning");
                    // Return true of equalized value changed from true to false
                    return !stringObj.tuned;
                }
            } else {
                // Checking if tune is already false and then performing respective operations
                if (OuterUtils.Utils.getRandomProbability(80)) {
                    stringObj.tuned = !stringObj.tuned;
                    System.out.println("The item " + itemObj.getClass().getName() + "'s tuned property changed from " + !stringObj.tuned + " to " + stringObj.tuned+ " during Manual tuning");
                    return !stringObj.tuned;
                }
                System.out.println("The item " + itemObj.getClass().getName() + "'s tuned property was not changed");
                return false;
            }
        } else {
            Wind windObj = (Wind) itemObj;
            // Checking if tune is already true and then performing respective operations
            if (windObj.adjusted) {
                if (OuterUtils.Utils.getRandomProbability(20)) {
                    windObj.adjusted = !windObj.adjusted;
                    System.out.println("The item " + itemObj.getClass().getName() + "'s adjusted property changed from " + !windObj.adjusted + " to " + windObj.adjusted+ " during Manual tuning");
                    // Return true of equalized value changed from true to false
                    return !windObj.adjusted;
                }
            } else {
                // Checking if tune is already false and then performing respective operations
                if (OuterUtils.Utils.getRandomProbability(80)) {
                    windObj.adjusted = !windObj.adjusted;
                    System.out.println("The item " + itemObj.getClass().getName() + "'s adjusted property changed from " + !windObj.adjusted + " to " + windObj.adjusted+ " during Manual tuning");
                    return !windObj.adjusted;
                }
                System.out.println("The item " + itemObj.getClass().getName() + "'s adjusted property was not changed");
                return false;
            }

        }
        return false;
    }
}
