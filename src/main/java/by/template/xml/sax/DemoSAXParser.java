package by.template.xml.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DemoSAXParser {
    public void parse() throws ParserConfigurationException, SAXException, IOException {
        final SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);

        final SAXParser saxParser = factory.newSAXParser();
        final File file = new File("./resource/sample_xml/sample.xml");
        saxParser.parse(file, specificHandler());
    }

    private DefaultHandler specificHandler() {
        return new DefaultHandler() {

            @Override
            public void startElement(final String uri, final String localName, final String qName,
                    final Attributes attributes) throws SAXException {
                System.out.println(qName);
            }

//            @Override
//            public void characters(final char[] ch, final int start, final int length)
//                    throws SAXException {
//                final StringBuilder builder = new StringBuilder();
//                for (int i = 0; i < length; i++) {
//                    builder.append(ch[i + start]);
//                }
//                System.out.println("-" + builder);
//            }
            @Override
            public void characters(final char[] ch, final int start, final int length) {
                System.out.print(new String(ch, start, length));
            }
        };

    }
}