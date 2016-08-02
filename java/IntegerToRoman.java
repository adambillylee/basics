import java.util.*;

/**
 * Created by adamli on 5/26/16.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String units[] = {"M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"};

        Map<String, Integer> unitToNumber = new HashMap<>();
        unitToNumber.put("M", 1000);
        unitToNumber.put("CM", 900);
        unitToNumber.put("D", 500);
        unitToNumber.put("CD", 400);
        unitToNumber.put("C", 100);
        unitToNumber.put("XC", 90);
        unitToNumber.put("L", 50);
        unitToNumber.put("XL", 40);
        unitToNumber.put("X", 10);
        unitToNumber.put("IX", 9);
        unitToNumber.put("V", 5);
        unitToNumber.put("IV", 4);
        unitToNumber.put("I", 1);
        StringBuilder sb = new StringBuilder();

        List<Character> a = new ArrayList<>();
        a.add('3');
        a.indexOf('3');

        int value = 0;
        while (num > 0) {
            int i = 0;
            for (; i < units.length; i++) {
                value = unitToNumber.get(units[i]);

                if (num < value)
                    continue;
                else
                    break;
            }

            num = num - value;
            sb.append(units[i]);
        }

        return sb.toString();
    }
}
