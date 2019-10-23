package project.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    @XmlAttribute(name = "id")
    private String id;
    private String author;
    private String title;
    private String genre;
    private String price;
    private String publish_date;
    private String description;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return Double.parseDouble(price);
    }

    public String getDescription() {
        return description;
    }
}
