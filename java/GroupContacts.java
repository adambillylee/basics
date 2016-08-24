import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adamli on 8/23/16.
 */
public class GroupContacts {
    private int[] father;
    private int[] rank;

    List<List<Contact>> groupContacts(List<Contact> input) {
        Map<String, List<Integer>> emailMap = new HashMap<>();

        // inverse index map from emails to contact index
        int n = input.size();
        for (int i = 0; i < n; i++) {
            for (String email : input.get(i).emails) {
                if (!emailMap.containsKey(email)) {
                    emailMap.put(email, new ArrayList<>());
                }

                emailMap.get(email).add(i);
            }
        }

        // init for union-find
        InitUnionFind(n);

        // for each email in the inverse index map
        for (String email : emailMap.keySet()) {
            // take each 2 contact with that email as a pair, perform union-find
            for (int i = 0; i < emailMap.get(email).size() - 1; i++) {
                union(emailMap.get(email).get(i), emailMap.get(email).get(i + 1));
            }
        }

        // add contact with the same father
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!groupMap.containsKey(find(i))) {
                groupMap.put(find(i), new ArrayList<>());
            }

            groupMap.get(find(i)).add(i);
        }


        // the union-find result is in contact index, convert them from index into contact object
        List<List<Contact>> rst = new ArrayList<>();
        for (int index : groupMap.keySet()) {
            List<Integer> members = groupMap.get(index);
            List<Contact> group = new ArrayList<>();

            // take all contact index of a group, and add all contacts of that group
            for (int member : members) {
                group.add(input.get(member));
            }

            rst.add(group);
        }

        return rst;
    }

    private void InitUnionFind(int n) {
        father = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
            rank[i] = 0;
        }
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        // if father of the pair is the same, return
        if (x == y)
            return;

        // set the higher rank in the pair to be the father
        if (rank[x] < rank[y]) {
            father[x] = y;
        } else {
            father[y] = x;

            // if rank are the same, set rank of x higher by 1
            if (rank[x] == rank[y])
                rank[x]++;
        }
    }

    private int find(Integer x) {
        if (x == father[x])
            return x;

        return find(father[x]);
    }
}
