package collections.maps;

import java.util.HashMap;

public class DriverHM {
    
    public static void main(String[] args) {
        
        HashMap<String, String> hmap = new HashMap<>();

        hmap.put("saurav", "person");
        hmap.put("no", "decision");
        hmap.put(null, "element");

        hmap.put("saurav", "man");

        hmap.put("check", "decision");

        hmap.put(null, "key");

        System.out.println(hmap);


    }
}
