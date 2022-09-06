package collections.maps;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHMap {
    public static void main(String[] args) {
        Map<Order, Integer> orders = new WeakHashMap<>();
        
        orders.put(new Order(1, "detail of order1"), 100);
        orders.put(new Order(2, "detail of order2"), 200);

        //these two objects order1 and order2 does not have any strong reference here 

        //lets create one strong reference

        Order order3 = new Order(3, "detail of order3");

        orders.put(order3, 300);
         

        //so the garbage collector is free to collect them 

        System.out.println(orders.size());

        System.gc();

        System.out.println(orders.size());

        //first run:
        //2
        //2
        //no gc ran 

        //3
        //1 
        //--> this should be the expected behaviour
    }
}


class Order {
    int orderId;
    String details;

    public Order(int anId, String theDetails){
        orderId = anId;
        details = theDetails;
    }
}
