package dom;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParserDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("company.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("department");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Name department : "
                            + eElement.getAttribute("name"));
                    System.out.println("ID department : "
                            + eElement.getAttribute("depId"));
                    NodeList employeeList = eElement.getElementsByTagName("employee");
                    for (int count = 0; count < employeeList.getLength(); count++) {
                        Node node1 = employeeList.item(count);


                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element emp= (Element) node1;
                            System.out.print("employee id : ");
                              System.out.println(emp.getAttribute("empId"));

                    System.out.println("FirstName: " + emp.getElementsByTagName("firstName").item(0).getTextContent());
                    System.out.println("Last Name : "+ emp.getElementsByTagName("lastName").item(0).getTextContent());
                    System.out.println(" birthDate: " + emp.getElementsByTagName("birthDate").item(0).getTextContent());
                    System.out.println("position: " + emp.getElementsByTagName("position").item(0).getTextContent());
                    System.out.println("Skills: " + emp.getElementsByTagName("skills").item(0).getTextContent());
                    System.out.println("Manager Id: " + emp.getElementsByTagName("managerId").item(0).getTextContent());
                    System.out.println();

                            }}}}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
