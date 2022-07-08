package nl.hu.bep.domain;

import java.util.Objects;

public class GameInformation {
    private String apiversion = "1";
    private String author = "aart";
    private String color = "#B0523E";
    private String head = "defaultt";
    private String tail = "default";
    private String version = "0.0.1-beta";

    public String getApiversion() {
        return apiversion;
    }

    public void setApiversion(String apiversion) {
        this.apiversion = apiversion;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameInformation that = (GameInformation) o;
        return Objects.equals(apiversion, that.apiversion) && Objects.equals(author, that.author) && Objects.equals(color, that.color) && Objects.equals(head, that.head) && Objects.equals(tail, that.tail) && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiversion, author, color, head, tail, version);
    }
}
