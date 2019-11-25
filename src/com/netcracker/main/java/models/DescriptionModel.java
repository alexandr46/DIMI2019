package models;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

@XmlRootElement(name = "Description")

@XmlType(propOrder = {"text","version"})
public class DescriptionModel {
    private String text;
    private BigInteger version;

    public DescriptionModel() {
    }

    @XmlElement(name = "Text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlElement(name = "Version")
    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public DescriptionModel(String text, BigInteger version) {
        this.text = text;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Description: " + "\n"+
                "text = " + text + "\n" +
                "version = " + version;
    }
}
