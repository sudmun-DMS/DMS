package controller;

import model.DMSBody;
import org.junit.Test;
import service.DMSDocumentService;
import service.DocumentNotFoundException;

import static org.junit.Assert.*;


public class DMSControllerTest {
    @org.junit.Test
    public void getDocumentById() throws Exception {
    }

    @Test
    public void success_when_id_1(){
        DMSDocumentService dmsDocumentService = new DMSDocumentService();

        DMSBody expected = new DMSBody(1,"http://file01.txt");

        DMSDocumentService dms = new DMSDocumentService();
        DMSBody actual = dms.getDocument(1);

        assertEquals(expected, actual);
    }

    @Test(expected = DocumentNotFoundException.class)
    public void doc_not_found_when_id_5(){

        DMSDocumentService dms = new DMSDocumentService();
        dms.getDocument(5);

    }


}