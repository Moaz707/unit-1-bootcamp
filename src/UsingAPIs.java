import com.sun.deploy.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Muaadh Melhi .
 */
public class UsingAPIs {
    private static Set <String> setATaleOfTwoCities, setMobyDick;
    private static File taleFile, mobyFile;


    public static void main(String args[]) {
        File[] taleFile = getFile();
        countUniqueWordsATaleOfTwoCities(taleFile[0]);
        countUniqueWordsMobyDick(taleFile[1]);
        intersectionBetweenBothBooks(setATaleOfTwoCities, setMobyDick);
        unionBetweenBothBooks(setATaleOfTwoCities, setMobyDick);
    }


    private static File[] getFile() {
        taleFile = new File("/Users/c4q/Desktop/C4q_work/HomeWork/BootCamp1/unit-1-bootcamp/resources/A _TALE OF_TWO_CITIES.txt");
        mobyFile = new File("/Users/c4q/Desktop/C4q_work/HomeWork/BootCamp1/unit-1-bootcamp/resources/Moby_Dick.txt");
        File[] files = {taleFile, mobyFile};
        return files;
    }

    private static void countUniqueWordsATaleOfTwoCities(File file) {
        setATaleOfTwoCities = new HashSet <>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.equals("the") || word.equals("The") || word.equals("the.")) {
                    setATaleOfTwoCities.add(word.toLowerCase());
                } else {
                    setATaleOfTwoCities.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("The unique words in A Tale of Two Cities are " + setATaleOfTwoCities.size() + " words.");
    }

    private static void countUniqueWordsMobyDick(File file) {
        setMobyDick = new HashSet <>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.equals("the") || word.equals("The") || word.equals("the.")) {
                    setMobyDick.add(word.toLowerCase());
                } else {
                    setMobyDick.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("The unique words in Moby Dick are " + setMobyDick.size() + " words.");
    }

    private static void intersectionBetweenBothBooks(Set <String> setATaleOfTwoCities, Set <String> setMobyDick) {
        Set <String> interesectionSet = new HashSet <>(setATaleOfTwoCities);
        interesectionSet.retainAll(setMobyDick);
        int setSize = interesectionSet.size();
        System.out.println("The cardinality (size) of this set: " + setSize);
    }

    private static void unionBetweenBothBooks(Set <String> setATaleOfTwoCities, Set <String> setMobyDick) {
        Set <String> unionSet = new HashSet <>(setATaleOfTwoCities);
        unionSet.addAll(setMobyDick);
        int setSize = unionSet.size();
        System.out.println("The union (size) of this set(Both Books): " + setSize);
        Iterator itr = unionSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());

        }
    }
}
