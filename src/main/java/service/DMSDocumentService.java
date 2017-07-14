package service;


import model.DMSBody;
import model.DMSDocumentDao;
import org.springframework.web.client.RestTemplate;

public class DMSDocumentService {

    public DMSBody getDocument(int id){

        //call SAP

        final String baseURL = "http://139.59.236.229:1150";
        final String uri = baseURL+"/saps/"+id;
        RestTemplate restTemplate = new RestTemplate();
        try {
            DMSDocumentDao data = restTemplate.getForObject(uri, DMSDocumentDao.class);
            return new DMSBody(data);

        }catch (Exception e){
            throw new DocumentNotFoundException();
        }

    }

}
