package models;

import adapters.DateAdapterBody;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;


@XmlRootElement(name = "TackObject")

@XmlType(propOrder = {"parentId","objectId","name",
        "dateCreate","dateUpdate","author","link",
        "detailsModel","descriptionModel","commentModel"})
public class TackObjectModel {
    private String parentId;
    private String objectId;
    private String name;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
    private String author;
    private String link;

    private DescriptionModel descriptionModel;
    private DetailsModel detailsModel;
    private CommentModel commentModel;

    private static final String PATH = ".//src//com//netcracker//main//resources//file.xml";

    public TackObjectModel(){
    }

    public TackObjectModel(String parentId, String objectId,
                           String name, LocalDateTime dateCreate,
                           LocalDateTime dateUpdate, String author,
                           String link, DescriptionModel descriptionModel,
                           DetailsModel detailsModel, CommentModel commentModel) {
        this.parentId = parentId;
        this.objectId = objectId;
        this.name = name;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
        this.author = author;
        this.link = link;
        this.descriptionModel = descriptionModel;
        this.detailsModel = detailsModel;
        this.commentModel = commentModel;
    }

    @XmlElement(name = "parent_id")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @XmlElement(name = "object_id")
    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name="DateCreate")
    @XmlJavaTypeAdapter(DateAdapterBody.class)
    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    @XmlElement(name="DateUpdate")
    @XmlJavaTypeAdapter(DateAdapterBody.class)
    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
    @XmlElement(name="Author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement(name="Link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @XmlElement(name="Description")
    public DescriptionModel getDescriptionModel() {
        return descriptionModel;
    }

    public void setDescriptionModel(DescriptionModel descriptionModel) {
        this.descriptionModel = descriptionModel;
    }

    @XmlElement(name="Details")
    public DetailsModel getDetailsModel() {
        return detailsModel;
    }

    public void setDetailsModel(DetailsModel detailsModel) {
        this.detailsModel = detailsModel;
    }

    @XmlElement(name="Commentaries")
    public CommentModel getCommentModel() {
        return commentModel;
    }

    public void setCommentModel(CommentModel commentModel) {
        this.commentModel = commentModel;
    }

    @Override
    public String toString() {
        return "TackObject:" + "\n" +
                "parentId = " + parentId + "\n" +
                "objectId = " + objectId + "\n" +
                "name = " + name + "\n" +
                "dateCreate = " + dateCreate + "\n" +
                "dateUpdate = " + dateUpdate + "\n" +
                "author = " + author + "\n" +
                "link = " + link + "\n" +
                descriptionModel + "\n" +
                detailsModel + "\n" +
                commentModel;
    }
}
