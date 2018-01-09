import java.util.*;

/**
 * Created by alexandraqin on 4/14/15.
 */
public class DataStructures {
    private static Map <String, Integer> pod;

    public static void main(String args[]) {

        // #1
        List <Cat> catsList = new ArrayList <>();
        catsList.add(new Cat("Smokey"));
        catsList.add(new Cat("Misty"));
        catsList.add(new Cat("Tigger"));
        catsList.add(new Cat("Kitty"));
        catsList.add(new Cat("Oscar"));
        Iterator itr = catsList.iterator();
        while (itr.hasNext()) {
            Cat cat = (Cat) itr.next();
            System.out.println(cat.getName());
        }

        // #2
        List <Integer> intList = new ArrayList <>();
        Integer[] intArray = new Integer[]{200, 100, 200, 300, 20, 3, 18, 90, 200, 100, 300};
        intList.addAll(Arrays.asList(intArray));
        mostFrequentElement(intList);

        // #3
        printAccessCodeFellows();

        // #4
        System.out.println(canRentACar(pod));

        //###Exercises++
        // #5
        System.out.println(wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 3));

        // #6
        System.out.println(countClumps(new int[]{1, 2, 2, 2, 3, 4, 4}));

        // #7
        String test = "Keep your eyes on the stars and your feet on the ground.";
        printStringAndInAlphaOrder(test);


    }

    private static void mostFrequentElement(List <Integer> intList) {
        HashMap <Integer, Integer> hashMap = new HashMap();
        for (Integer listValue : intList) {
            int count = 1;
            if (hashMap.containsKey(listValue)) {
                count += hashMap.get(listValue);
            }
            hashMap.put(listValue, count);
        }
        int max = 0;
        int keyNumber = 0;
        for (Integer key : hashMap.keySet()) {
            if (max < hashMap.get(key)) {
                max = hashMap.get(key);
                keyNumber = key;
            }
        }
        System.out.println("The most frequently occurring element is " + keyNumber + " appears for " + max + " times.");
    }

    private static void printAccessCodeFellows() {
        pod = new HashMap <String, Integer>() {{
            put("Yoki", 19);
            put("Murad", 26);
            put("Victoria", 18);
            put("Darnell", 23);
            put("naz", 24);
            put("angel", 21);
            put("joanne", 22);
            put("Muaadh", 30);
        }};
        for (String key : pod.keySet()) {
            System.out.println("Name is " + key.substring(0, 1).toUpperCase() + key.substring(1) + " and Age is " + pod.get(key) + ".");
        }
    }

    private static boolean canRentACar(Map <String, Integer> pod) {
        for (Map.Entry <String, Integer> entry : pod.entrySet()) {
            Integer value = entry.getValue();
            if (value >= 25) {
                return true;
            }
        }
        return false;
    }

    private static List <String> wordsWithoutList(String[] strings, int len) {
        List <String> list = new ArrayList <>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() != len) {
                list.add(strings[i]);
            }
        }
        return list;
    }

    private static int countClumps(int[] intArray) {
        int count = 0;
        Boolean gate = false;
        for (int i = 0; i < intArray.length - 1; i++) {
            if (intArray[i] == intArray[i + 1] && !gate) {
                count++;
                gate = true;
            } else if (intArray[i] != intArray[i + 1]) {
                gate = false;
            }
        }
        return count;
    }

    private static void printStringAndInAlphaOrder(String s) {
        String[] arrayString = s.toLowerCase().split(" ");
        List <String> stringList = Arrays.asList(arrayString);
        Collections.sort(stringList);
        for (String str : stringList) {
            System.out.println(str);
        }
    }
}


