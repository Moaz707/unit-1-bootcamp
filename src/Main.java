

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * // <<<for me for testing some code....not include in the Homework>>
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
//
//        List<String> list1 = new ArrayList<String>(Arrays.asList("A", "B", "C"));
//        List<String> list2 = new ArrayList<String>(Arrays.asList("B", "C", "D", "E", "F"));
//        list2.retainAll(list1);
//        list2.size();
//        System.out.println(list2.size());
////       Iterator<String> itr= list2.iterator();
////       while (itr.hasNext()){
////           System.out.println(itr.next());
////       }
//
//       // System.out.println(new Main().intersection(list1, list2));
//       // System.out.println(new Main().union(list1, list2));
//    }
//
//    public <T> List<T> union(List<T> list1, List<T> list2) {
//        Set<T> set = new HashSet<T>();
//
//        set.addAll(list1);
//        set.addAll(list2);
//
//        return new ArrayList<T>(set);
//    }
//
//    public <T> List<T> intersection(List<T> list1, List<T> list2) {
//        List<T> list = new ArrayList<T>();
//
//        for (T t : list1) {
//            if(list2.contains(t)) {
//                list.add(t);
//            }
//        }
//        return list;


        //find words inside text
        String text = "I will come and meet you at the woods) 123woods and all the woods.";
        List <String> tokens = new ArrayList <String>();
        tokens.add("123woods");
        tokens.add("woods");

        String patternString = "\\b(" + StringUtils.join(tokens, "|") + ")\\b";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

    }
}
