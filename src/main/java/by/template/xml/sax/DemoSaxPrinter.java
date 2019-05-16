package by.template.xml.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class DemoSaxPrinter {

    private static final String EXAMPLE_XML = "./resource/sample_xml/sax_reader_example/xml.xml";

    public void read() throws IOException, SAXException, ParserConfigurationException {
        final SAXParserFactory factory = SAXParserFactory.newInstance();
        final SAXParser parser = factory.newSAXParser();
        final XMLReader reader = parser.getXMLReader();
        reader.parse(new InputSource(EXAMPLE_XML));
        final SimpleClass handler = new SimpleClass();
        reader.setContentHandler(handler);
        reader.parse(EXAMPLE_XML);
    }

    private static class SimpleClass extends DefaultHandler {

        @Override
        public void startElement(final String uri, final String localName, final String qName,
                final Attributes attributes) throws SAXException {
            System.out.print("<" + qName + ">");
        }

//            @Override
//            public void startElement(final String uri, final String localName, final String qName,
//                    final Attributes attrs) {
//                String s = localName;
//                for (int i = 0; i < attrs.getLength(); i++) {
        //
//                    s += " " + attrs.getLocalName(i) + "=" + attrs.getValue(i);
//                }
//                System.out.print(s.trim());
//            }

        @Override
        public void characters(final char[] ch, final int start, final int length) {
            System.out.print(new String(ch, start, length));
        }

        @Override
        public void endElement(final String uri, final String localName, final String qName) {
            System.out.print(localName);
            System.out.print("<" + qName + "/>");
        }

    }

}
