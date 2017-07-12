package model;


public class DMSBody {

    private int id;
    private String link;

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

    public DMSBody(int id, String link) {
        this.id = id;
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DMSBody dmsBody = (DMSBody) o;

        if (id != dmsBody.id) return false;
        return link != null ? link.equals(dmsBody.link) : dmsBody.link == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }
}
