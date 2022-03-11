import java.util.Objects;
// Haphazard tune changes equalized, tuned and adjusted property 50% of the time
public class HaphazardTune implements TuneAlgorithm{
    public boolean tune(Item itemObj, String storeName){
        if(Objects.equals(itemObj.getClass().getSuperclass().getName(), "Players")){
            Players playerObj = (Players) itemObj;
            // Computing probability of tuning
            if(OuterUtils.Utils.getRandomProbability(50)){
                playerObj.equalized = !playerObj.equalized;
                System.out.println(storeName+": The item "+itemObj.getClass().getName()+"'s equalized property changed from "+!playerObj.equalized+ " to "+ playerObj.equalized+ " during haphazard tuning");
                // Return true if equalized value changed from true to false
                return !playerObj.equalized;
            }
            else{
                System.out.println(storeName+": The item "+itemObj.getClass().getName()+"'s equalized property was not changed");
            }

            return false;
        }
        else if (Objects.equals(itemObj.getClass().getSuperclass().getName(), "Stringed")){
            Stringed stringObj = (Stringed) itemObj;
            // Computing probability of tuning
            if(OuterUtils.Utils.getRandomProbability(50)){
                stringObj.tuned = !stringObj.tuned;
                System.out.println(storeName+": The item "+itemObj.getClass().getName()+"'s tuned property changed from "+!stringObj.tuned+ " to "+ stringObj.tuned+ " during haphazard tuning");
                // Return true if equalized value changed from true to false
                return !stringObj.tuned;
            }
            else{
                System.out.println(storeName+": The item "+itemObj.getClass().getName()+"'s tuned property was not changed");
            }

            return false;
        }
        else{
            Wind windObj = (Wind) itemObj;
            // Computing probability of tuning
            if(OuterUtils.Utils.getRandomProbability(50)){
                windObj.adjusted = !windObj.adjusted;
                System.out.println(storeName+": The item "+itemObj.getClass().getName()+"'s adjusted property changed from "+!windObj.adjusted+ " to "+ windObj.adjusted+ " during haphazard tuning");
                // Return true if equalized value changed from true to false
                return !windObj.adjusted;
            }
            else{
                System.out.println(storeName+": The item "+itemObj.getClass().getName()+"'s adjusted property was not changed");
            }

            return false;
        }

    }
}
