package users.javersExample;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.ListCompareAlgorithm;

import java.util.*;

public class JaversTest {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Foden");

        Address a1 = new Address();
        a1.setId(100);
        a1.setAddressLine("Address Line 1");

        Address a2 = new Address();
        a2.setId(200);
        a2.setAddressLine("Address Line 2");

        s1.setAddress(Arrays.asList(a1,a2));

        Student s2 = new Student();
        s2.setId(1);
        s2.setName("Foden");
        s2.setAddress(Arrays.asList(a2,a1));


//        Javers javers = JaversBuilder.javers().build();
        Javers javers = JaversBuilder.javers().withListCompareAlgorithm(ListCompareAlgorithm.AS_SET).build(); //use this algo to compare 2 object, mà k care tới thứ tự trong list
        Diff diff = javers.compare(s1,s2);
        System.out.println(diff.prettyPrint());
        System.out.println(diff.getChanges());


        String greeting = "Hello World";
        String lower = "";
        int lowerCount = 0;
        String upper = "";
        int upperCount = 0;
        for (int i = 0; i < greeting.length(); i++) {
            if (greeting.charAt(i) >= 65 && greeting.charAt(i)<= 90){
                upper+=greeting.charAt(i);
                upperCount++;
            } else {
                lower+=greeting.charAt(i);
                lowerCount++;
            }
        }
        System.out.println("Lower string is: " + lower + " with total " + lowerCount + " character(s)");
        System.out.println("UPPER string is: " + upper + " with total " + upperCount + " character(s)");

        String[] names = {"Foden","VinhD"};
        List<String> namesAsList = new ArrayList<>();
        namesAsList.add("Foden");
        for (String name : names){
            System.out.println(name);
        }

        Map<String,String> myInfos = new HashMap<>();
        myInfos.put("name","Foden");
        myInfos.put("age","25");
    }
}
