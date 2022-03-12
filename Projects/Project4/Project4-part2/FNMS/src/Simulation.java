import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Simulation {
    MusicStore northMusicStoreObj;
    MusicStore southMusicStoreObj;
    private List<Clerk> clerkObjList;
    public Announcer announcer;
    public Logger logger;
    public Tracker tracker;
    MusicStore commandLineMusicStore;
    Clerk referenceClerkObj;
    Clerk specialClerk1;
    Clerk specialClerk2;


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

        for(int day = 1; day <= days; day ++){

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
    }

    void finish(int days){
        northMusicStoreObj.finish(days);
        southMusicStoreObj.finish(days);
    }

    void selectStore(String s, int days){
        if (s.equals("south")) {
            commandLineMusicStore = southMusicStoreObj;
            referenceClerkObj = specialClerk1;
            System.out.println("South music store is selected");
            //initializeStore(commandLineMusicStore, days);
        }
        else if(s.equals("north")){
            commandLineMusicStore = northMusicStoreObj;
            referenceClerkObj = specialClerk2;
            System.out.println("North music store is selected");
            //initializeStore(commandLineMusicStore, days);
        }
        else{
            System.out.println("Ineligible entry");
        }
    }

    void initializeStores(int day){
        // initialize that every clerk as not sick at the beginning of each day
        for(Clerk staffMember: clerkObjList){
            staffMember.isSick = false;
        }
        // Flag to keep track that only one clerk falls sick
        boolean isSickAlreadySet = false;
        // Getting a random clerk and checking if they have worked continuously and is not sick
        do{

            specialClerk1 = OuterUtils.Utils.getRandomClerkObj(clerkObjList);
            if(! isSickAlreadySet) {
                if (OuterUtils.Utils.getRandomProbability(10)) {
                    specialClerk1.isSick = true;
                    isSickAlreadySet = true;
                    System.out.println("Clerk " +specialClerk1.name+ " has fallen sick when tending to northside store and another clerk is going to replace him/her today");
                }
            }
        }while(specialClerk1.checkConsecutive(day) || specialClerk1.isSick);
        // Flag to keep track that only one clerk falls sick
        isSickAlreadySet = false;
        // Getting a random clerk and checking if they have worked continuously and is not sick
        do{

            specialClerk2 = OuterUtils.Utils.getRandomClerkObj(clerkObjList);
            if(! isSickAlreadySet) {
                if (OuterUtils.Utils.getRandomProbability(10)) {
                    specialClerk2.isSick = true;
                    isSickAlreadySet = true;
                    System.out.println("Clerk " + specialClerk2.name + " has fallen sick when tending to Southside store and another clerk is going to replace him/her today");
                }
            }
        }while(specialClerk2.checkConsecutive(day) || specialClerk2.isSick);

        southMusicStoreObj.InitializeStoreSim(day, specialClerk1,announcer);
        northMusicStoreObj.InitializeStoreSim(day, specialClerk2,announcer);
    }

    void getClerkName(){
        if(commandLineMusicStore != null) {
            if (referenceClerkObj != null) {
                System.out.println("Selected clerk name is :" + referenceClerkObj.getName());
            }
        }
    }

    void getCurrentTime(){
        if(commandLineMusicStore != null) {
            if (referenceClerkObj != null) {
                //https://stackabuse.com/how-to-get-current-date-and-time-in-java/
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                System.out.println("Clerk " + referenceClerkObj.getName() + " reports time: " + dtf.format(now));
            }
        }
    }

    void sellItem(int day) {
        if (commandLineMusicStore != null) {
            if (referenceClerkObj != null) {
                commandLineMusicStore.sellItem(day, referenceClerkObj, announcer);
            }
        }
    }

    void buyItem(int day) {
        if (commandLineMusicStore != null) {
            if (referenceClerkObj != null) {
                commandLineMusicStore.buyItem(day, referenceClerkObj, announcer);
            }
        }
    }

    void closeUpStore(int day) {
        southMusicStoreObj.closeUpStore(day, specialClerk1, announcer);
        northMusicStoreObj.closeUpStore(day, specialClerk2, announcer);
    }

    void sellCustomerGuitarItem(Item item, int day, double totalValue){
        if (commandLineMusicStore != null) {
            if (referenceClerkObj != null) {
                commandLineMusicStore.sellCustomerGuitarItem(item, totalValue, day, referenceClerkObj);
            }
        }
    }

    void commandLineInterface(SimulationInvoker invoker, int day){
        String inputString;
        Boolean isEnd;
        System.out.println("a. Select a store to issue commands to \nb. Ask the clerk their name (should reply with clerk’s name)\nc. Ask the clerk what time it is\nd. Sell a normal inventory item to the clerk\ne. Buy a normal inventory item from the clerk \nf. Buy a custom guitar kit from the clerk\ng. End Interactions \n ");
        Scanner input = new Scanner(System.in);
        String selectedStore = null;
        NorthSideFactory northSideFactory = new NorthSideFactory();
        SouthSideFactory southSideFactory = new SouthSideFactory();
        // Accepting input until empty or word matches random word
        do{
            // Setting isEnd flag to false
            isEnd = false;
            System.out.println("Enter a command: ");
            // Try catch for handling inputs other than numbers

            inputString = input.nextLine();
            // Checking for empty input
            if (inputString.isBlank() || inputString.isEmpty()){
                isEnd = true;
            }
            // Check if words are alphabets only
            // Reference - https://www.tutorialkart.com/java/how-to-check-if-string-contains-only-alphabets-in-java/
            if(inputString.toLowerCase().equals("a")){
                System.out.println("Enter store name: ");
                inputString = input.nextLine();
                if(inputString.toLowerCase().equals("north") || (inputString.toLowerCase().equals("south"))){
                    selectedStore = inputString.toLowerCase();
                    invoker.selectStore(inputString.toLowerCase(), day);
                }
            }
            if(inputString.toLowerCase().equals("b")){
                invoker.getClerkName();
            }
            if(inputString.toLowerCase().equals("c")){
                invoker.getCurrentTime();
            }
            if(inputString.toLowerCase().equals("d")){
                invoker.sellItem(day);
            }
            if(inputString.toLowerCase().equals("e")){
                invoker.buyItem(day);
            }
            if(inputString.toLowerCase().equals("f")){
                if(selectedStore != null && selectedStore.equals("north")){
                    Bridge bridge;
                    KnobSet knob;
                    Covers cover;
                    Neck neck;
                    PickUps pickUp;
                    PickGuard pickGuard;
                    List<Bridge> bridges = northSideFactory.createBridge();
                    System.out.println("Select a bridge from 1 to 3");
                    int inputNum = input.nextInt();
                    if(inputNum > 0 && inputNum <= 3){
                        bridge = bridges.get(inputNum - 1);
                    }
                    else{
                        System.out.println("Invalid entry");
                        input.nextLine();
                        continue;
                    }
                    List<KnobSet> knobs = northSideFactory.createKnobSet();
                    System.out.println("Select a knob from 1 to 3");
                    inputNum = input.nextInt();
                    if(inputNum > 0 && inputNum <= 3){
                        knob = knobs.get(inputNum - 1);
                    }
                    else{
                        System.out.println("Invalid entry");
                        input.nextLine();
                        continue;
                    }

                    List<Covers> covers = northSideFactory.createCovers();
                    System.out.println("Select a cover from 1 to 3");
                    inputNum = input.nextInt();
                    if(inputNum > 0 && inputNum <= 3){
                        cover = covers.get(inputNum - 1);
                    }
                    else{
                        System.out.println("Invalid entry");
                        input.nextLine();
                        continue;
                    }
                    List<Neck> necks = northSideFactory.createNeck();
                    System.out.println("Select a neck from 1 to 3");
                    inputNum = input.nextInt();
                    if(inputNum > 0 && inputNum <= 3){
                        neck = necks.get(inputNum - 1);
                    }
                    else{
                        System.out.println("Invalid entry");
                        input.nextLine();
                        continue;
                    }
                    List<PickGuard> pickGuards = northSideFactory.createPickGuard();
                    System.out.println("Select a pick guard from 1 to 3");
                    inputNum = input.nextInt();
                    if(inputNum > 0 && inputNum <= 3){
                        pickGuard = pickGuards.get(inputNum - 1);
                    }
                    else{
                        System.out.println("Invalid entry");
                        input.nextLine();
                        continue;
                    }
                    List<PickUps> pickUps = northSideFactory.createPickUps();
                    System.out.println("Select a pick up from 1 to 3");
                    inputNum = input.nextInt();
                    if(inputNum > 0 && inputNum <= 3){
                        pickUp = pickUps.get(inputNum - 1);
                    }
                    else{
                        System.out.println("Invalid entry");
                        input.nextLine();
                        continue;
                    }

                    double totalValue = bridge.getPrice() + knob.getPrice() + cover.getPrice() + neck.getPrice() + pickGuard.getPrice() + pickUp.getPrice();
                    System.out.println("Customer guitar kit components: " + bridge.getClass().getName() + ", " + knob.getClass().getName() + ", " + cover.getClass().getName() + ", " + neck.getClass().getName() + ", " + pickGuard.getClass().getName() + ", " + pickUp.getClass().getName());
                    Item itemObj = new CustomGuitarItem("customGuitar");
                    invoker.sellCustomerGuitarItem(itemObj, day, totalValue);
                    input.nextLine();
                }
                else if(selectedStore != null && selectedStore.equals("south")){
                    Bridge bridge;
                    KnobSet knob;
                    Covers cover;
                    Neck neck;
                    PickUps pickUp;
                    PickGuard pickGuard;
                    List<Bridge> bridges = southSideFactory.createBridge();
                    System.out.println("Select a bridge from 1 to 3");
                    int inputNum = input.nextInt();
                    if(inputNum > 0 && inputNum <= 3){
                        bridge = bridges.get(inputNum - 1);
                    }
                    else{
                        System.out.println("Invalid entry");
                        input.nextLine();
                        continue;
                    }
                    List<KnobSet> knobs = southSideFactory.createKnobSet();
                    System.out.println("Select a knob from 1 to 3");
                    inputNum = input.nextInt();
                    if(inputNum > 0 && inputNum <= 3){
                        knob = knobs.get(inputNum - 1);
                    }
                    else{
                        System.out.println("Invalid entry");
                        input.nextLine();
                        continue;
                    }

                    List<Covers> covers = southSideFactory.createCovers();
                    System.out.println("Select a cover from 1 to 3");
                    inputNum = input.nextInt();
                    if(inputNum > 0 && inputNum <= 3){
                        cover = covers.get(inputNum - 1);
                    }
                    else{
                        System.out.println("Invalid entry");
                        input.nextLine();
                        continue;
                    }
                    List<Neck> necks = southSideFactory.createNeck();
                    System.out.println("Select a neck from 1 to 3");
                    inputNum = input.nextInt();
                    if(inputNum > 0 && inputNum <= 3){
                        neck = necks.get(inputNum - 1);
                    }
                    else{
                        System.out.println("Invalid entry");
                        input.nextLine();
                        continue;
                    }
                    List<PickGuard> pickGuards = southSideFactory.createPickGuard();
                    System.out.println("Select a pick guard from 1 to 3");
                    inputNum = input.nextInt();
                    if(inputNum > 0 && inputNum <= 3){
                        pickGuard = pickGuards.get(inputNum - 1);
                    }
                    else{
                        System.out.println("Invalid entry");
                        input.nextLine();
                        continue;
                    }
                    List<PickUps> pickUps = southSideFactory.createPickUps();
                    System.out.println("Select a pick up from 1 to 3");
                    inputNum = input.nextInt();
                    if(inputNum > 0 && inputNum <= 3){
                        pickUp = pickUps.get(inputNum - 1);
                    }
                    else{
                        System.out.println("Invalid entry");
                        input.nextLine();
                        continue;
                    }

                    double totalValue = bridge.getPrice() + knob.getPrice() + cover.getPrice() + neck.getPrice() + pickGuard.getPrice() + pickUp.getPrice();
                    System.out.println("Customer guitar kit components: " + bridge.getClass().getName() + ", " + knob.getClass().getName() + ", " + cover.getClass().getName() + ", " + neck.getClass().getName() + ", " + pickGuard.getClass().getName() + ", " + pickUp.getClass().getName());
                    Item itemObj = new CustomGuitarItem("customGuitar");
                    invoker.sellCustomerGuitarItem(itemObj, day, totalValue);
                    input.nextLine();
                }
            }
            if(inputString.toLowerCase().equals("g")){
                invoker.closeUpStore(day);
                isEnd = true;
            }

        }while(!isEnd);
    }
}
