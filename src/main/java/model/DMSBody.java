package model;


public class DMSBody {

    private int id;
    private String link;
    private String status;
    private String description;
    private String user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public DMSBody(int id, String link) {
        this.id = id;
        this.link = link;
    }

    public DMSBody(int id, String link, String status, String description, String user) {
        this.id = id;
        this.link = link;
        this.status = status;
        this.description = description;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DMSBody dmsBody = (DMSBody) o;

        if (id != dmsBody.id) return false;
        if (link != null ? !link.equals(dmsBody.link) : dmsBody.link != null) return false;
        if (status != null ? !status.equals(dmsBody.status) : dmsBody.status != null) return false;
        if (description != null ? !description.equals(dmsBody.description) : dmsBody.description != null) return false;
        return user != null ? user.equals(dmsBody.user) : dmsBody.user == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
