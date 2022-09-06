package practice.Sept6.hMap;

import java.util.HashMap;
import java.util.Iterator;

public class Driver {
    
    public static void main(String[] args) {
        
        HashMap<String,Integer> hmap = new HashMap<>();
        hmap.put("Saurav", 38);
        hmap.put("Santosh",37);

        hmap.put("Abhay", 1);


        Iterator itr = hmap.keySet().iterator();

        while(itr.hasNext()){
            System.out.println(hmap.get(itr.next()));
        }


        Iterator itr2 = hmap.entrySet().iterator();

        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }

        Iterator itr3 = hmap.values().iterator();

        while(itr3.hasNext()){
            System.out.println(itr3.next());
        }

    }


}
