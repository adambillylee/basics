import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0 || maxWidth < 0) {
            return result;
        }

        if (maxWidth == 0) {
            result.add("");
            return result;
        }

        fullJustifyHelper(0, words, result, maxWidth);

        return result;
    }

    private void fullJustifyHelper(int start, String[] words,
                                   List<String> result, int maxWidth) {
        if (start >= words.length) {
            return;
        }

        int total = 0;
        int len = 0;
        int next = -1;
        int i = start;

        while (i < words.length && total < maxWidth) {
            total += words[i].length();

            if (total > maxWidth) {
                next = i;
                break;
            }

            len += words[i].length();
            total++;
            i++;
        }

        if (next == -1) {
            next = i;
        }

        addLists(words, start, next, result, len, maxWidth);

        fullJustifyHelper(next, words, result, maxWidth);
    }

    private void addLists(String[] words, int start, int next,
                          List<String> result, int len, int maxWidth) {
        int spaces = next - start - 1;
        StringBuffer line = new StringBuffer();
        // Last line or only one word in a line
        if (spaces == 0 || next == words.length) {
            for (int i = start; i < next; i++) {
                line.append(words[i]);
                if (i == next - 1) {
                    break;
                }
                line.append(" ");
            }

            int trailingSpace = maxWidth - len - spaces;
            for (int i = 0; i < trailingSpace; i++) {
                line.append(" ");
            }

            result.add(line.toString());
        } else {
            int even = (maxWidth - len) / spaces;
            int notEven = (maxWidth - len) % spaces;
            for (int i = start; i < next; i++) {
                line.append(words[i]);
                if (i == next - 1) {
                    break;
                }
                for (int j = 0; j < even; j++) {
                    line.append(" ");
                }

                if (notEven > 0) {
                    line.append(" ");
                    notEven--;
                }
            }
            result.add(line.toString());
        }
    }
}