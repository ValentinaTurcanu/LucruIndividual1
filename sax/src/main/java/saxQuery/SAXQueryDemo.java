package saxQuery;
import saxQuery.UserHandler1;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXQueryDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("company.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler1 userhandler = new UserHandler1();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
