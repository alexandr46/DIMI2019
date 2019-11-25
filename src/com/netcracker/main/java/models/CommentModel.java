package models;

import adapters.DateAdapterComment;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;

@XmlRootElement(name = "Commentaries")

@XmlType(propOrder = {"author","text","date"})
public class CommentModel {
private String author;
private String text;
private ZonedDateTime date;

    public CommentModel() {
    }

    public CommentModel(String author, String text, ZonedDateTime date) {
        this.author = author;
        this.text = text;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Commentaries: " + "\n"+
                "author = " + author + "\n" +
                "text = " + text + "\n" +
                "date = " + date;
    }

    @XmlElement(name = "Author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement(name = "Text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlElement(name = "Data")
    @XmlJavaTypeAdapter(DateAdapterComment.class)
    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }
}
