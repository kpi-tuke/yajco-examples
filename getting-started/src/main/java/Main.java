import mylang.SimpleIdentifier;
import mylang.parser.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        String input = "id superman";
        System.out.println("Going to parse: '" + input + "'");

        SimpleIdentifier identifier = new LALRSimpleIdentifierParser().parse(input);
        System.out.println("Parsed identifier: " + identifier.getIdentifier());
    }
}
