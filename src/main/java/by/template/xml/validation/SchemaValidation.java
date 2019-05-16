package by.template.xml.validation;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class SchemaValidation {
    public static void main(final String[] args) {
//      final URL schemaFile = new URL("http://host:port/filename.xsd");
        // webapp example xsd:
        // URL schemaFile = new URL("http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd");
        // local file example:
        final File schemaFile = new File("./resource/sample_xml/xsd/shipto.xsd"); // etc.
        final Source xmlFile = new StreamSource(new File("./resource/sample_xml/xsd/shipto.xml"));
        final SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            final Schema schema = schemaFactory.newSchema(schemaFile);
            final Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (final SAXException e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
