package service;


import model.DMSBody;
import model.DMSDocumentDao;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

public class DMSDocumentService {
    private DMSDocumentDao dao;

    public DMSDocumentService() {
    }



    public DMSBody getDocument(int id){

        //call SAP

        final String baseURL = "http://139.59.236.229:1150";
        final String uri = baseURL+"/saps/"+id;
        RestTemplate restTemplate = new RestTemplate();
        try {
            DMSDocumentDao dao = restTemplate.getForObject(uri, DMSDocumentDao.class);
            return new DMSBody(dao.getId(),dao.getLink(),dao.getStatus(),dao.getDescription(),dao.getUser());
        }catch (Exception e){
            throw new DocumentNotFoundException();
        }
       // System.out.println(dao1.getId());









        //return data
       // DMSDocumentDao dao = new DMSDocumentDao(id,"SUV","RELEASE","http://test.na.xom.com","test template");




    }

}
