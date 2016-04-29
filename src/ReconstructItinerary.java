import java.util.*;

/**
 * Created by adamli on 4/28/16.
 */
public class ReconstructItinerary {
    static HashMap<String, PriorityQueue<String>> map = new HashMap();

    public static List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets) {
            addTicket(ticket);
        }

        List<String> list = new ArrayList<>();

        helper(list, "JFK");

        return list;
    }

    static void helper(List<String> list, String from) {
        PriorityQueue<String> to = map.get(from);

        /**
         *  1. to may be null if this from city has no to city
         *  2. poll nodes through and while loop
         */
        while(to != null && !to.isEmpty()) {
            helper(list, to.poll());
        }

        // add current city before current queue
        list.add(0, from);

        /**
         * error example: use for loop to go through PriorityQueue while polling from it
         */
//        if (from != null) {
//            map.get(from).remove(to);
//        }
//
//        if (toList != null) {
//            for (String next : toList) {
//                list.add(next);
//                helper(list, to, next);
//            }
//        }
    }

    static void addTicket(String[] ticket) {
        String from = ticket[0];
        String to = ticket[1];

        if (map.containsKey(from)) {
            map.get(from).add(to);
        } else {
            PriorityQueue<String> toList = new PriorityQueue<>();
            toList.offer(to);
            map.put(from, toList);
        }
    }
}
