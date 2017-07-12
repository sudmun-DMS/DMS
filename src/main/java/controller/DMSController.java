package controller;


import model.DMSBody;
import model.DMSHeader;
import model.DMSResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.DMSDocumentService;

@RestController
public class DMSController {

    @CrossOrigin(origins = "*")
    @GetMapping("/document/{id}")
    public DMSResponse getDocumentById(@PathVariable int id) {

        DMSDocumentService dms = new DMSDocumentService();
        //return new DMSResponse(new DMSHeader(200), new DMSBody(id,"http://google.com"));
        try {

            return new DMSResponse(new DMSHeader(200), dms.getDocument(id));
        }catch (Exception e){
            return new DMSResponse(new DMSHeader(404), null);
        }
    }

}
