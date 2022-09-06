package practice.Sept6.tMap;

import java.util.Iterator;
import java.util.TreeMap;

public class Driver {
    
    public static void main(String[] args) {
        
        TreeMap<String, Integer> tmap = new TreeMap();
        tmap.put("Zaheer", 2);
        tmap.put("Saurav",38);
        tmap.put("Abhay",1);
        tmap.put("Santosh",37);
        tmap.put("Dhwani",17);
        tmap.put("Bhuvan", 45);

        Iterator itr1 = tmap.keySet().iterator();

        while(itr1.hasNext()){
            System.out.println(itr1.next());
        }


    }
}
