import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class OuterUtils {
    public static class Utils {

        static Random rand = new Random();

        public static String getRandomName() {
            Random rand = new Random();
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

            return String.valueOf(name.charAt(0)) + String.valueOf(lowers);
        }

        boolean getRandomDamage(int x) {
            //works for velma- need to add code based on x
            int p =  rand.nextInt(100);
            if( p<5 )
                return true;
            else
                return false;
        }

        boolean getRandomBuy() {
            int p =  rand.nextInt(50);
            if( p<25 )
                return true;
            else
                return false;
        }

        String getRandomClerkObj() {
            if (rand.nextBoolean()) {
                return "Shaggy";
            } else {
                return "Velma";
            }
        }

        String getRandomItem() {
            //assigning random item name
            return getRandomName();
        }

        List<String> getItemTypes() {
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
            itemTypes.add("PaperScore");
            itemTypes.add("Cables");
            itemTypes.add("PracticeAmps");
            itemTypes.add("Strings");
            return itemTypes;
        }

        double getRandomPrice(int x) {
            return rand.nextDouble();
        }

        int getRandomDay(int d) {
            //delivery day after ordering
            return d + (rand.nextInt(3) + 1);
        }

        double getRandomPrice(String a, String b) {
            return 0.0;
        }
    }
}
