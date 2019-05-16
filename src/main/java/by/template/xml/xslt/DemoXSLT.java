package by.template.xml.xslt;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class DemoXSLT {
    public static void main(final String[] args)
            throws TransformerException, FileNotFoundException {
        final StreamSource source = new StreamSource(
                DemoXSLT.class.getResourceAsStream("demo_xslt.xml"));
        final StreamSource stylesource = new StreamSource(
                DemoXSLT.class.getResourceAsStream("demo_xslt.xsl"));

        final TransformerFactory factory = TransformerFactory.newInstance();
        final Transformer transformer = factory.newTransformer(stylesource);

//        final StreamResult result = new StreamResult(System.out);
        final StreamResult result = new StreamResult(
                new File("./src/main/java/by/my/examples/xml/xslt/demo_xslt.html"));
        transformer.transform(source, result);
    }
}
