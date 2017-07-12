package model;

public class DMSResponse {

    private DMSHeader header;
    private DMSBody body;


    public DMSResponse(DMSHeader header, DMSBody body) {
        this.header = header;
        this.body = body;
    }



    public DMSHeader getHeader() {
        return header;
    }

    public void setHeader(DMSHeader header) {
        this.header = header;
    }

    public DMSBody getBody() {
        return body;
    }

    public void setBody(DMSBody body) {
        this.body = body;
    }



}
