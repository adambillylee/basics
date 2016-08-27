import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by adamli on 8/25/16.
 */
public class CSVParserQuotesOnlyTest {
    CSVParserQuotesOnly sol = new CSVParserQuotesOnly();

    @Test
    public void testNoQuote() throws Exception {
        String input = "1,2,3";

        assertEquals("[1, 2, 3]", sol.parseCSV(input).toString());
    }

    @Test
    public void testQuotesOnly() throws Exception {
        String input = "1,\"2\",3";

        assertEquals("[1, 2, 3]", sol.parseCSV(input).toString());
    }

    @Test
    public void testEscape() throws Exception {
        String input = "1,2\"\",3";

        assertEquals("[1, \"2\"\", 3]", sol.parseCSV(input).toString());
    }

    @Test
    public void testEscapeWithQuote() throws Exception {
        String input = "1,\"2,\"\"\"\"\",3";

        assertEquals("[1, \"2,\"\"\", 3]", sol.parseCSV(input).toString());
    }

}