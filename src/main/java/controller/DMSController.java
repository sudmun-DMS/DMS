package controller;


import model.DMSBody;
import model.DMSHeader;
import model.DMSResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.DMSDocumentService;
import service.DMSFileService;
import service.DocumentNotFoundException;

@RestController
public class DMSController {

    @CrossOrigin(origins = "*")
    @GetMapping("/document/{id}")
    public DMSResponse getDocumentById(@PathVariable int id) {

        DMSDocumentService dms = new DMSDocumentService();
        //return new DMSResponse(new DMSHeader(200), new DMSBody(id,"http://google.com"));
        try {

            //return new DMSResponse(new DMSHeader(200), dms.getDocument(id));
            DMSBody dmsResultBody =   dms.getDocument(id);

            DMSFileService dmsFileService = new DMSFileService();
            dmsResultBody = dmsFileService.getFile(dmsResultBody);
            return new DMSResponse(new DMSHeader(200), dmsResultBody);

        }catch(DocumentNotFoundException de) {
            return new DMSResponse(new DMSHeader(404), null);
        }catch (Exception e){
            return new DMSResponse(new DMSHeader(500), null);
        }
    }

}
