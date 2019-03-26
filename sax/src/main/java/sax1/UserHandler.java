package sax1;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler {
    boolean bFirstName = false;
    boolean bLastName = false;
    boolean bBrithDate = false;
    boolean bPosition = false;
    boolean bSkill = false;
    boolean bManagerId = false;


    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("department")) {
            String depId = attributes.getValue("depId");
            String name= attributes.getValue("name");
            System.out.println("Department Id: " + depId);
            System.out.println("Department name: " + name);}
        else if (qName.equalsIgnoreCase("employee")) {
            String empId = attributes.getValue("empId");
            System.out.println("Employee Id= : " + empId);
        } else if (qName.equalsIgnoreCase("firstName")) {
            bFirstName = true;
        } else if (qName.equalsIgnoreCase("lastName")) {
            bLastName = true;
        } else if (qName.equalsIgnoreCase("brithDate")) {
            bBrithDate  = true;
        }
        else if (qName.equalsIgnoreCase("position")) {
            bPosition = true;
        }
        else if (qName.equalsIgnoreCase("skill")) {
            bSkill = true;
        }
        else if (qName.equalsIgnoreCase("managerId")) {
            bManagerId = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("department")) {
            System.out.println("End Element :" + qName);
        }
       else if (qName.equalsIgnoreCase("employee")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bFirstName) {
            System.out.println("First Name: "
                    + new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName) {
            System.out.println("Last Name: " + new String(ch, start, length));
            bLastName = false;
        } else if (bBrithDate) {
            System.out.println("Brith Date: " + new String(ch, start, length));
            bBrithDate = false;
        } else if (bPosition) {
            System.out.println("Position: " + new String(ch, start, length));
            bPosition= false;
        }
        else if (bSkill) {
            System.out.println("Skills: " + new String(ch, start, length));
            bSkill= false;
        }
        else if (bManagerId) {
            System.out.println("Manager Id: " + new String(ch, start, length));
            bManagerId= false;


        }
    }
}

