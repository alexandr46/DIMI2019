package models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Details")


@XmlType(propOrder = {"type","priority","component","label","status"})
public class DetailsModel {
    private String type;
    private String priority;
    private String component;
    private String label;
    private String status;

    public DetailsModel() {
    }

    public DetailsModel(String type, String priority, String component, String label, String status) {
        this.type = type;
        this.priority = priority;
        this.component = component;
        this.label = label;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Details:" +
                "type = " + type + "\n" +
                "priority = " + priority + "\n" +
                "component = " + component + "\n" +
                "label = " + label + "\n" +
                "status = " + status;
    }

    @XmlElement(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name = "Priority")
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @XmlElement(name = "Component")
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @XmlElement(name = "Label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @XmlElement(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
