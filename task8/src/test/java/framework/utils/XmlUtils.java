package framework.utils;

import aquality.selenium.logger.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import project.models.Catalog;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class XmlUtils {

    private static final Logger logger = Logger.getInstance();

    public static Catalog getCatalog(String response) throws JAXBException {
        logger.info("Get catalog from response");
        JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Catalog) jaxbUnmarshaller.unmarshal(new StringReader(response));
    }

    public static boolean validateXmlResponse(String response) {
        try {
            Source xmlFile = new StreamSource(new ByteArrayInputStream(response.getBytes()));
            URL schemaFile = new URL("https://www.w3.org/2001/XMLSchema.xsd");
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            final List<SAXParseException> exceptions = new LinkedList<>();
            validator.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) {
                    exceptions.add(exception);
                }

                @Override
                public void fatalError(SAXParseException exception) {
                    exceptions.add(exception);
                }

                @Override
                public void error(SAXParseException exception) {
                    exceptions.add(exception);
                }
            });
            validator.validate(xmlFile);
        } catch (SAXException | IOException ex) {
            System.out.println(ex.getMessage());
            ex.getMessage();
        }
        return true;
    }
}
