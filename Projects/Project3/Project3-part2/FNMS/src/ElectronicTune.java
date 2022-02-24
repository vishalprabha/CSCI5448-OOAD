import java.util.Objects;
// Electronic tune changes equalized, tuned and adjusted property from false to true only
public class ElectronicTune implements TuneAlgorithm{
    public boolean tune(Item itemObj){
        if(Objects.equals(itemObj.getClass().getSuperclass().getName(), "Players")){
            Players playerObj = (Players) itemObj;
            // Changing tune if false
            if(!playerObj.equalized){
                playerObj.equalized = true;
                System.out.println("The item "+itemObj.getClass().getName()+"'s equalized property changed from "+ false + " to "+ true + " during electronic tuning");
            }
            else{
                System.out.println("The item "+itemObj.getClass().getName()+"'s equalized property was not changed");
            }
            return false;
        }
        else if (Objects.equals(itemObj.getClass().getSuperclass().getName(), "Stringed")){
            Stringed stringObj = (Stringed) itemObj;
            // Changing tune if false
            if(!stringObj.tuned){
                stringObj.tuned = true;
                System.out.println("The item "+itemObj.getClass().getName()+"'s tuned property changed from "+false+ " to "+ true + " during electronic tuning");
            }
            else{
                System.out.println("The item "+itemObj.getClass().getName()+"'s tuned property was not changed");
            }
            return false;
        }
        else{
            Wind windObj = (Wind) itemObj;
            // Changing tune if false
            if(!windObj.adjusted){
                windObj.adjusted = true;
                System.out.println("The item "+itemObj.getClass().getName()+"'s adjusted property changed from "+false+ " to "+ true + " during electronic tuning");
            }
            else{
                System.out.println("The item "+itemObj.getClass().getName()+"'s adjusted property was not changed");
            }
            return false;
        }

    }
}
