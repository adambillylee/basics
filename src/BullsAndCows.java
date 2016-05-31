import java.util.HashMap;
import java.util.Map;

/**
 * Created by adamli on 5/30/16.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : secret.toCharArray()) {
            addToMap(map, c);
        }

        int rst[] = new int[2];
        StringBuilder guessSB = new StringBuilder();
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);

            if (c == secret.charAt(i)) {
                rst[0]++;
                delFromMap(map, c);
            }else{
                guessSB.append(c);
            }
        }

        guess = guessSB.toString();
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);

            if (map.containsKey(c)) {
                rst[1]++;
                delFromMap(map, c);
            }

        }

        return rst[0] + "A" + rst[1] + "B";
    }

    private void addToMap(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }

    private void delFromMap(Map<Character, Integer> map, char c) {
        if (!map.containsKey(c))
            return;

        map.put(c, map.get(c) - 1);

        if (map.get(c) == 0)
            map.remove(c);
    }
}
