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

    @GetMapping("/document/{id}")
    public DMSResponse getDocumentById(@PathVariable int id) {

        DMSDocumentService dms = new DMSDocumentService();

        try {

            DMSBody dmsResultBody =   dms.getDocument(id);

            DMSFileService dmsFileService = new DMSFileService();
            dmsResultBody = dmsFileService.getFile(dmsResultBody);
            return getDmsResponse(dmsResultBody, new DMSHeader(200));

        }catch(DocumentNotFoundException de) {
            return getDmsResponse(null, new DMSHeader(404));
        }catch (Exception e){
            return getDmsResponse(null, new DMSHeader(500));
        }
    }

    private DMSResponse getDmsResponse(DMSBody dmsResultBody, DMSHeader header) {
        return new DMSResponse(header, dmsResultBody);
    }

}
