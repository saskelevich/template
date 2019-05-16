package by.template.xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class DOMParser {

    public void parse() throws ParserConfigurationException, SAXException, IOException {

        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//include XML validation
//        factory.setValidating(true);//for DTD validation
//        factory.setSchema(schema);// for XSD validation
        final DocumentBuilder builder = factory.newDocumentBuilder();
        final File file = new File("./resource/sample_xml/sample.xml");
        final Document doc = builder.parse(file);
        // Something action with the document here.

//for example
        printAllEllements(doc.getDocumentElement().getChildNodes());
    }

    private static void printAllEllements(final NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {
                final Element element = (Element) nodeList.item(i);
                System.out.println("<" + element.getTagName() + ">");
                if (element.hasAttributes()) {
                    printAllNodes(element.getAttributes());
                }
                if (nodeList.item(i).hasChildNodes()) {
                    printAllEllements(nodeList.item(i).getChildNodes());
                }
                printContent(nodeList.item(i), "\"", "\"");
            }
        }
    }

    private static void printContent(final Node node, final String start, final String end) {
        if (!node.getTextContent().trim().isEmpty()
                && !((Text) node.getFirstChild()).getData().trim().isEmpty()
                && !((Text) node.getFirstChild()).getData().trim().equals("\n")) {
            final Text text = ((Text) node.getFirstChild());
            System.out.println(start + "(value)" + text.getData().trim() + end);
        }
    }

    private static void printAllNodes(final NamedNodeMap map) {
        for (int i = 0; i < map.getLength(); i++) {
            if (map.item(i) instanceof Node) {
                final Node node = map.item(i);
                System.out.print("(att)" + node.getNodeName());
                printContent(node, "=\"", "\"");
            }
        }
    }
}
