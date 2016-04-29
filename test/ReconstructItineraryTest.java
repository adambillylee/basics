import org.junit.Test;

import java.util.List;

/**
 * Created by adamli on 4/28/16.
 */
public class ReconstructItineraryTest {
    ReconstructItinerary sol = new ReconstructItinerary();

    @Test
    public void findItinerary1() throws Exception {
        String tickets[][] = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        List<String> rst = sol.findItinerary(tickets);

        for (String city : rst) {
            System.out.println(city);
        }
        System.out.println();
    }

    @Test
    public void findItinerary2() throws Exception {
        String tickets[][] ={{"JFK","ATL"},{"ATL","JFK"}};
        List<String> rst = sol.findItinerary(tickets);

        for (String city : rst) {
            System.out.println(city);
        }
        System.out.println();
    }

    @Test
    public void findItinerary3() throws Exception {
        String tickets[][] ={{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        List<String> rst = sol.findItinerary(tickets);

        for (String city : rst) {
            System.out.println(city);
        }
        System.out.println();
    }

}