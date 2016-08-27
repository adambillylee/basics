
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 8/25/16.
 */
public class CSVParserQuotesOnly {
    List<String> parseCSV(String S) {
        List<String> line = new ArrayList();
        boolean quoteOpen = false;
        boolean hasQuote = false;
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < S.length()) {
            String s = S.substring(i, i + 1);

            if (s.equals("\"")) {
                // count quotes
                int count = countQuotes(i, S);
                i += count;

                // if quote is not opened, consume first quote to open it
                if (sb.length() == 0) {
                    quoteOpen = true;
                    count--;
                }

                // use 2 quote to make an "escaped" quote
                while (count >= 2) {
                    sb.append('\"');
                    count -= 2;
                    hasQuote = true;
                }

                // if there are still quotes left, use it to close quote
                if (quoteOpen && count == 1) {
                    quoteOpen = false;
                }
            } else if (s.equals(",") && !quoteOpen) {
                // if string builder has quotes, make a "quoted" string into result
                if (hasQuote) {
                    sb.insert(0, "\"");
                    sb.append("\"");
                }
                line.add(sb.toString());
                sb.setLength(0);
                i++;
            } else {
                sb.append(s);
                i++;
            }
        }


        line.add(sb.toString());
        return line;
    }

    // count number of consecutive quotes
    private int countQuotes(int i, String S) {
        int count = 0;
        while (i < S.length() && S.charAt(i) == '\"') {
            i++;
            count++;
        }

        return count;
    }
}
