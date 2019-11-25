package models;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "ListTask")
public class ListTaskObjectModel {


    private List<TackObjectModel> modelList;

    public ListTaskObjectModel(List<TackObjectModel> list) {
        this.modelList = list;
    }

    public ListTaskObjectModel() {
    }

    @XmlElement(name = "TackObject")
    public List<TackObjectModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<TackObjectModel> modelList) {
        this.modelList = modelList;
    }

    public static ListTaskObjectModel fromXmlToObject(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ListTaskObjectModel.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (ListTaskObjectModel) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void convertObjectToXml(ListTaskObjectModel task, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(ListTaskObjectModel.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(task, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
