package by.template.xml.xpath;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class DemoXPath {

    public static void main(final String[] args) throws Exception {
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        final Document xmlDocument = builder
                .parse(DemoXPath.class.getResourceAsStream("demo_xpath.xml"));
//        final XPath xPath = XPathFactory.newInstance().newXPath();
        final String expression = "/bookstore/book/title/text()";
//      System.out.println(xPath.compile(expression).evaluate(xmlDocument, XPathConstants.STRING));
        System.out.println(evaluateXPath(xmlDocument, expression));
//        System.out.println(xPath.evaluate(expression, xmlDocument));
//        System.out.println(xPath.evaluate(expression, xmlDocument, XPathConstants.NUMBER));
//        System.out.println(xPath.evaluate(expression, xmlDocument, XPathConstants.NODE));
//        System.out.println(xPath.evaluate(expression, xmlDocument, XPathConstants.NODESET));
//        System.out.println(xPath.evaluate(expression, xmlDocument, XPathConstants.STRING));
    }

    private static Document getDocument(final String fileName) throws Exception {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        final DocumentBuilder builder = factory.newDocumentBuilder();
        final Document doc = builder.parse(fileName);
        return doc;
    }

    private static List<String> evaluateXPath(final Document document, final String xpathExpression)
            throws Exception {
        // Create XPathFactory object
        final XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        final XPath xpath = xpathFactory.newXPath();

        final List<String> values = new ArrayList<>();
        try {
            // Create XPathExpression object
            final XPathExpression expr = xpath.compile(xpathExpression);

            // Evaluate expression result on XML document
            final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            for (int i = 0; i < nodes.getLength(); i++) {
                values.add(nodes.item(i).getNodeValue());
            }

        } catch (final XPathExpressionException e) {
            e.printStackTrace();
        }
        return values;
    }
}
