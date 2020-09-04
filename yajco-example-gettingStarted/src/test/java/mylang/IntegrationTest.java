package mylang;

import mylang.parser.LALRSimpleIdentifierParser;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {

    @Test
    public void identifierTest() throws Exception {
        String input = "id superman";
        Assert.assertEquals("superman",     parseIdentifier(input).getIdentifier());
    }

    private SimpleIdentifier parseIdentifier(String input) throws Exception {
        LALRSimpleIdentifierParser parser = new LALRSimpleIdentifierParser();
        return parser.parse(input);
    }
}
