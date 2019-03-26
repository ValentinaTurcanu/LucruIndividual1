package dom;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
public class CreateXmlFileDemo {

    public static void main(String[] arg) {

        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("departments");
            doc.appendChild(rootElement);
            Attr attr = doc.createAttribute("depId");
            attr.setValue("001");
            rootElement.setAttributeNode(attr);

            // supercars element
            Element employee = doc.createElement("employee");
            //doc.appendChild(rootElement);
            rootElement.appendChild(employee);

            // setting attribute to element
            Attr attr1 = doc.createAttribute("empId");
            attr1.setValue("001");
            employee.setAttributeNode(attr1);

            Element firstName = doc.createElement("firstName");
            firstName.appendChild(doc.createTextNode("Tim"));
            employee.appendChild(firstName);

            Element lastName = doc.createElement("lastName");
            lastName.appendChild(doc.createTextNode("Ben"));
            employee.appendChild(lastName);
            Element birthDate = doc.createElement("birthDate");
            birthDate.appendChild(doc.createTextNode("20.02.1986"));
            employee.appendChild(birthDate);
            Element position = doc.createElement("position");
            position.appendChild(doc.createTextNode("engineer"));
            employee.appendChild(position);
            Element skills = doc.createElement("skills");
            employee.appendChild(skills);
            Element skill= doc.createElement("skill");
            skill.appendChild(doc.createTextNode("Works a lot"));
            skills.appendChild(skill);
            Element skill1= doc.createElement("skill");
            skill1.appendChild(doc.createTextNode("mathematical thinking"));
            skills.appendChild(skill1);
            Element managerId = doc.createElement("managerId");
            managerId.appendChild(doc.createTextNode("0"));
            employee.appendChild(managerId);



            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("company1.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
