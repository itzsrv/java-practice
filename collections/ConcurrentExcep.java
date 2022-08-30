package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class ConcurrentExcep{

    public static void main(String[] args){
        Map<String, Integer> scores = new HashMap<>();

        scores.put("user1", 6);
        scores.put("user2", 6);
        scores.put("user3", 6);
        scores.put("user4", 6);
        scores.put("user5", 6);
        scores.put("user6", 6);
        scores.put("user7", 6);
        scores.put("user8", 6);

        Iterator<String> userItr = scores.keySet().iterator();

        while(userItr.hasNext()){
            System.out.println(scores.get(userItr.next())); 
            scores.put("user9", 6);
        }

    }
}