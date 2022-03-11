import java.util.ArrayList;
import java.util.List;

public class Simulation {
    MusicStore northMusicStoreObj;
    MusicStore southMusicStoreObj;
    private List<Clerk> clerkObjList;
    public Announcer announcer;
    public Logger logger;
    public Tracker tracker;


    Simulation(){
        clerkObjList = new ArrayList<>();
        northMusicStoreObj = new MusicStore("North");
        southMusicStoreObj = new MusicStore("South");
        // Creating an array list of TuneAlgorithm objects
        List<TuneAlgorithm> tuneAlgos = new ArrayList<>();
        tuneAlgos.add(new HaphazardTune());
        tuneAlgos.add(new ManualTune());
        tuneAlgos.add(new ElectronicTune());
        tuneAlgos.add(new HaphazardTune());
        tuneAlgos.add(new ManualTune());
        tuneAlgos.add(new ElectronicTune());
        int choice = OuterUtils.Utils.getRandomInt(0, 6);
       // Creating Shaggy clerk object
        clerkObjList.add(new Clerk( 20, "Shaggy", tuneAlgos.get(choice)));
        tuneAlgos.remove(choice);
        // Creating Velma clerk object
        choice = OuterUtils.Utils.getRandomInt(0, 5);
        clerkObjList.add(new Clerk(5, "Velma", tuneAlgos.get(choice)));
        tuneAlgos.remove(choice);
        // Creating Daphne clerk object with damage chance 10%
        choice = OuterUtils.Utils.getRandomInt(0, 4);
        clerkObjList.add(new Clerk(10, "Daphne", tuneAlgos.get(choice)));
        tuneAlgos.remove(choice);
        // Creating Scooby clerk object with damage chance 10%
        choice = OuterUtils.Utils.getRandomInt(0, 3);
        clerkObjList.add(new Clerk(10, "Scooby", tuneAlgos.get(choice)));
        tuneAlgos.remove(choice);
        // Creating Fred clerk object with damage chance 10%
        choice = OuterUtils.Utils.getRandomInt(0, 2);
        clerkObjList.add(new Clerk(10, "Fred", tuneAlgos.get(choice)));
        tuneAlgos.remove(choice);
        // Creating Scrappy clerk object with damage chance 10%
        choice = OuterUtils.Utils.getRandomInt(0, 1);
        clerkObjList.add(new Clerk(10, "Scrappy", tuneAlgos.get(choice)));
        tuneAlgos.remove(choice);
        announcer= new Announcer();
        logger= new Logger();
        tracker= new Tracker(clerkObjList);
        announcer.addListener(logger);
        announcer.addListener(tracker);


    }

    void runStores(int days){

        for(int day = 0; day <= days; day ++){

            Clerk clerkObj1;
            Clerk clerkObj2;
            // initialize that every clerk as not sick at the beginning of each day
            for(Clerk staffMember: clerkObjList){
                staffMember.isSick = false;
            }
            // Flag to keep track that only one clerk falls sick
            boolean isSickAlreadySet = false;
            // Getting a random clerk and checking if they have worked continuously and is not sick
            do{

                clerkObj1 = OuterUtils.Utils.getRandomClerkObj(clerkObjList);
                if(! isSickAlreadySet) {
                    if (OuterUtils.Utils.getRandomProbability(10)) {
                        clerkObj1.isSick = true;
                        isSickAlreadySet = true;
                        System.out.println("North: Clerk " +clerkObj1.name+ " has fallen sick and another clerk is going to replace him/her today");
                    }
                }
            }while(clerkObj1.checkConsecutive(day) || clerkObj1.isSick);
            // Flag to keep track that only one clerk falls sick
            isSickAlreadySet = false;
            // Getting a random clerk and checking if they have worked continuously and is not sick
            do{

                clerkObj2 = OuterUtils.Utils.getRandomClerkObj(clerkObjList);
                if(! isSickAlreadySet) {
                    if (OuterUtils.Utils.getRandomProbability(10)) {
                        clerkObj2.isSick = true;
                        isSickAlreadySet = true;
                        System.out.println("South: Clerk " +clerkObj2.name+ " has fallen sick and another clerk is going to replace him/her today");
                    }
                }
            }while(clerkObj2.checkConsecutive(day) || clerkObj2.isSick);
            northMusicStoreObj.simulate(day, clerkObj1, announcer);
            southMusicStoreObj.simulate(day, clerkObj2, announcer);


        }
        northMusicStoreObj.finish(days);
        southMusicStoreObj.finish(days);

    }
}
