package dom;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
public class QueryXmlFileDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("company.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.print("Root element: ");
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("employee");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :");
                System.out.print(nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.print("empId: ");
                    System.out.println(eElement.getAttribute("empId"));
                    System.out.println("first Name : "+ eElement.getElementsByTagName("firstName").item(0).getTextContent());
                            System.out.println("Last Name : "+ eElement.getElementsByTagName("lastName").item(0).getTextContent());
                            System.out.println(" birthDate: " + eElement.getElementsByTagName("birthDate").item(0).getTextContent());
                            System.out.println("position: " + eElement.getElementsByTagName("position").item(0).getTextContent());
                            System.out.println("Skills: " + eElement.getElementsByTagName("skills").item(0).getTextContent());
                            NodeList skillList = eElement.getElementsByTagName("skills");

                    for (int count = 0; count < skillList.getLength(); count++) {
                        Node node1 = skillList.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element skill = (Element) node1;
                            System.out.println("Skill: " + skill.getElementsByTagName("skill").item(0).getTextContent());*/
                        }
                    }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

