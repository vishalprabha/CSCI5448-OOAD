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
        static boolean getRandomProbability(int x) {
            //works for velma- need to add code based on x
            int p =  rand.nextInt(100);
            return p < x;
        }
        // Get random sale percentage based on percentage of x
        static boolean getRandomProbability(double x) {
            //works for velma- need to add code based on x
            double p =  0 + (rand.nextDouble() * (100));
            return p < x;
        }
        // Function to get random clerk
        static Clerk getRandomClerkObj(List<Clerk> clerkObjList) {
            return clerkObjList.get(rand.nextInt(clerkObjList.size()));
        }

        // Function to get random condition for Item
        static String getRandomCondition(){
            // Getting random condition - https://www.baeldung.com/java-random-list-element#:~:text=In%20order%20to%20get%20a,that%20exceeds%20your%20List's%20size.
            List<String> conditionList = Arrays.asList("poor", "fair", "good", "very good", "excellent");
            return conditionList.get(rand.nextInt(conditionList.size()));
        }

        // Function to get one random item
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
            itemTypes.add("Cassette");
            itemTypes.add("CassettePlayer");
            itemTypes.add("Saxaphone");
            itemTypes.add("GigBag");
            return itemTypes.get(rand.nextInt(itemTypes.size()));
        }
        // Generate random value in given range
        static double getRandomPrice(int min, int max) {
            // https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
            return min + (rand.nextDouble() * (max - min));

        }
        // Generate random int value in given range
        static int getRandomInt(int min, int max){
            // https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
            return rand.nextInt(max- min) + min;
        }

        // Function to get all Item types from inventory
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
            itemTypes.add("Cassette");
            itemTypes.add("CassettePlayer");
            itemTypes.add("Saxaphone");
            itemTypes.add("GigBag");
            return itemTypes;
        }

        // Function to generate poisson distribution for generating number of arriving customers
        // Refernce - https://stackoverflow.com/questions/9832919/generate-poisson-arrival-in-java
        static int getRandomBuyCustomers(){
            // Mean defaultly set as 3 as per question
            int mean = 3;
            double L = Math.exp(-mean);
            int k = 0;
            double p = 1.0;
            do {
                p = p * rand.nextDouble();
                k++;
            } while (p > L);
            // returning 2 + a random variate from a Poisson distribution
            return k - 1 + 2;
        }

        //Random boolean
        static boolean getRandomBoolean(){
            return rand.nextBoolean();
        }
    }
}
