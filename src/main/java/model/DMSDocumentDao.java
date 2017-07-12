package model;


public class DMSDocumentDao {

    private int id;
    private String user;
    private String status;
    private String link;
    private String description;

    public DMSDocumentDao() {
    }

    public DMSDocumentDao(int id, String user, String status, String link, String description) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.link = link;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
