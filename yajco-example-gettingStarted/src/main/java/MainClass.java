import mylang.SimpleIdentifier;
import mylang.parser.*;

public class MainClass {

    public static void main(String[] args) throws ParseException{
        String input = "id superman";
        System.out.println("Going to parse: '"+input+"'");

        LALRSimpleIdentifierParser parser = new LALRSimpleIdentifierParser();
        SimpleIdentifier simpleIdentifier = parser.parse(input);

        System.out.println("Parsed identifier: "+simpleIdentifier.getIdentifier());
    }
}
