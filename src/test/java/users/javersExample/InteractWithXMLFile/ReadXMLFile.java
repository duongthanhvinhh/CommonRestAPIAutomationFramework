package users.javersExample.InteractWithXMLFile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ReadXMLFile {

    //DocumentBuilderFactory
    //DocumentBuilder
    //Document
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src/test/java/users/javersExample/InteractWithXMLFile/data.xml");

        //extract root node from xml doc
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType()==Node.ELEMENT_NODE){
                Element ele = (Element) node;
                System.out.println(ele.getTagName());
                System.out.println(ele.getTextContent());
            }
        }
    }
}
