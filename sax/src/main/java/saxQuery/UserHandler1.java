package saxQuery;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class UserHandler1 extends DefaultHandler {
    boolean bFirstName = false;
    boolean bLastName = false;
    boolean bBirthDate = false;
    boolean bPosition = false;
    boolean bSkill = false;
    boolean bManagerId = false;
    String empId = null;


    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("employee"))
        {
            empId = attributes.getValue("empId");
        }
        if(("01").equals(empId) && qName.equalsIgnoreCase("employee")) {
               System.out.println("Start Element :" + qName);
        }
        if (qName.equalsIgnoreCase("firstName")) {
            bFirstName = true; }
        else if (qName.equalsIgnoreCase("lastName")) {
            bLastName = true; }
        else if (qName.equalsIgnoreCase("birthDate")) {
            bBirthDate = true; }
        else if (qName.equalsIgnoreCase("position")) {
            bPosition  = true;}

        else if (qName.equalsIgnoreCase("skill")) {
             bSkill = true; }
        else if (qName.equalsIgnoreCase("managerId")) {
            bManagerId = true; }
    }

    @Override
    public void endElement(
            String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            if(("01").equals(empId) && qName.equalsIgnoreCase("employee"))
                System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bFirstName && ("01").equals(empId)) {
            //age element, set Employee age
            System.out.println("First Name: " + new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName && ("01").equals(empId)) {
            System.out.println("Last Name: " + new String(ch, start, length));
            bLastName = false;
        } else if (bBirthDate && ("01").equals(empId)) {
            System.out.println("Birth Date " + new String(ch, start, length));
            bBirthDate = false;
        } else if (bPosition && ("01").equals(empId)) {
            System.out.println("Position: " + new String(ch, start, length));
            bPosition = false;
        } else if (bSkill && ("01").equals(empId)) {
            System.out.println("skill: " + new String(ch, start, length));
            bSkill = false;
        } else if (bManagerId && ("01").equals(empId)) {
            System.out.println("Manager Id: " + new String(ch, start, length));
            bManagerId= false;
}}}
