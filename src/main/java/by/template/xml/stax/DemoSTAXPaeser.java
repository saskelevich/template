package by.template.xml.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class DemoSTAXPaeser {

    public void parse() throws FileNotFoundException, IOException, XMLStreamException {
        try (FileInputStream fis = new FileInputStream("./resource/sample_xml/sample.xml")) {
            final XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
            final XMLStreamReader reader = xmlInFact.createXMLStreamReader(fis);
            while (reader.hasNext()) {
//                reader.next();
                // do something here
                final int event = reader.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    System.out.println(reader.getLocalName());
                }

                if (event == XMLStreamConstants.CHARACTERS) {
                    System.out.println(reader.getText());
                }
            }
        }
    }
}