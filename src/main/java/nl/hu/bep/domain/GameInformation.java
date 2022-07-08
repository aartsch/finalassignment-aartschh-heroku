package nl.hu.bep.domain;

public class GameInformation {
    private String apiversion;
    private String author ;
    private String color;
    private String head = "defaultt";
    private String tail = "default\"";
    private String version ;

    public GameInformation(String color, String head, String tail) {
        this.apiversion = "1";
        this.author = "aart";
        this.color = color;
        this.head = head;
        this.tail = tail;
        this.version = "0.0.1-beta";
    }

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
}
