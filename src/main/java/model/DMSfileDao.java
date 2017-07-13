package model;


public class DMSfileDao {

    private String fileLink;
    private int id;
    private String oldLink;

    public DMSfileDao(String fileLink) {
        this.fileLink = fileLink;
    }

    public DMSfileDao(String oldLink, String fileLink, int id) {
        this.fileLink = fileLink;
        this.id = id;
        this.oldLink = oldLink;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOldLink() {
        return oldLink;
    }

    public void setOldLink(String oldLink) {
        this.oldLink = oldLink;
    }
}
