import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 8/27/16.
 */
public class CSVParserSlashEscaped {
    List<String> parseCSV(String S) {
        List<String> line = new ArrayList<>();

        int i=0;
        StringBuilder sb = new StringBuilder();
        boolean openQuote = false;
        boolean withQuote = false;

        while (i < S.length()) {
            char c = S.charAt(i);

            if (c == '\\') {
                i++;

                char next = S.charAt(i);
                sb.append(next);
                if (next == '"')
                    withQuote = true;
            }else if (c == ',' && !openQuote){
                if (withQuote) {
                    sb.insert(0, '"');
                    sb.append('"');
                }

                line.add(sb.toString());
                sb.setLength(0);
            }else if (c == '"') {
                openQuote = !openQuote;
            }else{
                if (c == '"')
                    withQuote = true;

                sb.append(c);
            }

            i++;
        }

        line.add(sb.toString());
        return line;
    }
}
