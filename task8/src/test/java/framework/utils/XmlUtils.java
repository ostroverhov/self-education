package framework.utils;

import aquality.selenium.logger.Logger;
import project.models.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlUtils {

    private static final Logger logger = Logger.getInstance();

    public static Catalog getCatalog(String response) throws JAXBException {
        logger.info("Get catalog from response");
        JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Catalog) jaxbUnmarshaller.unmarshal(new StringReader(response));
    }
}
