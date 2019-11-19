package models;

import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ActionModel implements Serializable {

    private static final long serialVersionUID = 3412103980408677810L;
    private HashMap<String, String> actionMap;
    private static final String PATH = ".//src//com//netcracker//main//resources//test.xml";

    public HashMap<String, String> getActionMap() {
        return actionMap;
    }

    public ActionModel() {
        this.actionMap = readToXML();
    }

    public static void writeToXML(HashMap<String, String> map) {
        org.jdom2.Document doc = new org.jdom2.Document();

        doc.setRootElement(new Element("ToDoList"));

        for (Map.Entry<String, String> entry : map.entrySet()) {
            Element actionElement = new Element("Action");
            actionElement.setAttribute("id", entry.getKey());
            actionElement.addContent(new Element("action").setText(entry.getValue()));
            doc.getRootElement().addContent(actionElement);
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(PATH)) {
            XMLOutputter xmlWriter = new XMLOutputter(Format.getPrettyFormat());
            xmlWriter.output(doc, fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, String> readToXML() {
        try {
            org.jdom2.Document jdomDocument = createJdomDocument(PATH);
            Element root = jdomDocument.getRootElement();
            List<Element> actionElements = root.getChildren("Action");
            HashMap<String, String> actionMap = new LinkedHashMap<>();

            for (Element element : actionElements) {
                String id = element.getAttributeValue("id");
                String description = element.getChildText("action");
                actionMap.put(id,description);
            }
            return actionMap;

            } catch (Exception e) {
                e.printStackTrace();
                return new LinkedHashMap<>();
            }
    }


    private static org.jdom2.Document createJdomDocument(String fileName)
            throws ParserConfigurationException, IOException, org.xml.sax.SAXException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        documentBuilder = dbFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();

        return domBuilder.build(doc);
    }
}
