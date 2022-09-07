package programmingquestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicatesFromArrayList {
    
    public static void main(String[] args) {
        
        List alist = new ArrayList<String>();
        alist.add("Saurav");
        alist.add("Vasu");
        alist.add("Saurav"); 

        HashSet hset = new HashSet<String>(alist);

        List newalist = new ArrayList<String>(hset);

        System.out.println(alist);
        System.out.println(newalist);
    }
}
