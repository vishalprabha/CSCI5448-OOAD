import java.util.*;
import java.util.function.Function;

public  class OuterUtils {
    public static class Utils {

        static Random rand = new Random();

        public static char getRandomSize(){
            char[] sizes = {'S','M','L'};
            int size = rand.nextInt(sizes.length);
            return sizes[size];
        }

        public static String getRandomName() {
            int nameLength = rand.nextInt(6) + 3;

            // References
            // https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java

            char[] charsCons = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
                    'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y',
                    'Z'};
            char[] charsVowel = {'A', 'E', 'I', 'O', 'U'};

            StringBuilder name = new StringBuilder();

            while (name.length() < nameLength) {
                int r = rand.nextInt(charsCons.length);
                int s = rand.nextInt(charsVowel.length);
                char cons = charsCons[r];
                char vow = charsVowel[s];

                if (name.length() % 2 == 0) {
                    name.append(cons);
                } else {
                    name.append(vow);
                }
            }

            StringBuilder lowers = new StringBuilder();
            String nameString = name.toString();
            char[] letters = nameString.toCharArray();

            for (int i = 2; i <= nameLength; i++) {
                lowers.append(Character.toLowerCase(letters[i - 1]));
            }

            return name.charAt(0) + String.valueOf(lowers);
        }
        // Get random damage based on percentage of x
        static boolean getRandomDamage(int x) {
            //works for velma- need to add code based on x
            int p =  rand.nextInt(100);
            return p < x;
        }
        // Get random buy based on percentage of x
        static boolean getRandomBuy(int x) {
            int p =  rand.nextInt(100);
            return p < x;
        }
        // Function to get random clerk
        static Clerk getRandomClerkObj(List<Clerk> clerkObjList) {
            return clerkObjList.get(rand.nextInt(clerkObjList.size()));
        }
//
//        String getRandomItem() {
//            //assigning random item name
//            return getRandomName();
//        }
        // Function to get random condition for Item
        static String getRandomCondition(){
            // Getting random condition - https://www.baeldung.com/java-random-list-element#:~:text=In%20order%20to%20get%20a,that%20exceeds%20your%20List's%20size.
            List<String> conditionList = Arrays.asList("poor", "fair", "good", "very good", "excellent");
            return conditionList.get(rand.nextInt(conditionList.size()));
        }
        static String getRandomItemTypes() {
            List<String> itemTypes = new ArrayList<>();
            //adding all sub classes
            itemTypes.add("PaperScore");
            itemTypes.add("CD");
            itemTypes.add("Vinyl");
            itemTypes.add("PlayersCD");
            itemTypes.add("RecordPlayer");
            itemTypes.add("MP3");
            itemTypes.add("Guitar");
            itemTypes.add("Bass");
            itemTypes.add("Mandolin");
            itemTypes.add("Flute");
            itemTypes.add("Harmonica");
            itemTypes.add("Hats");
            itemTypes.add("Shirts");
            itemTypes.add("Bandanas");
            itemTypes.add("Cables");
            itemTypes.add("PracticeAmps");
            itemTypes.add("Strings");
            return itemTypes.get(rand.nextInt(itemTypes.size()));
        }
        // Generate random value in given range
        static double getRandomPrice(int min, int max) {
            // https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
            return min + (rand.nextDouble() * (max - min));

        }

        static int getRandomInt(int min, int max){
            // https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
            return rand.nextInt(max- min) + min;
        }

//        static int getRandomDay(int d) {
//            //delivery day after ordering
//            return d + (rand.nextInt(3) + 1);
//        }

        static List<String> getItemTypes() {
            List<String> itemTypes = new ArrayList<>();
            //adding all sub classes
            itemTypes.add("PaperScore");
            itemTypes.add("CD");
            itemTypes.add("Vinyl");
            itemTypes.add("PlayersCD");
            itemTypes.add("RecordPlayer");
            itemTypes.add("MP3");
            itemTypes.add("Guitar");
            itemTypes.add("Bass");
            itemTypes.add("Mandolin");
            itemTypes.add("Flute");
            itemTypes.add("Harmonica");
            itemTypes.add("Hats");
            itemTypes.add("Shirts");
            itemTypes.add("Bandanas");
            itemTypes.add("Cables");
            itemTypes.add("PracticeAmps");
            itemTypes.add("Strings");
            return itemTypes;
        }
    }
}
