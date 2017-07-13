package service;

import model.DMSBody;
import model.DMSDocumentDao;
import model.DMSfileDao;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;
import java.text.SimpleDateFormat;
import org.springframework.http.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


public class DMSFileService {
    private DMSBody dmsBody;

    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    public DMSFileService() {
    }

    public DMSBody getFile(DMSBody body){

        String newLink = generateNewLink(body.getDescription(),body.getLink() );




       // Map<String, String> vars = new HashMap<String, String>();
        //vars.put("link", newLink);
        final String baseURL = "http://139.59.236.229:1150";

        final String uri = baseURL+"/files";
        DMSfileDao dmsFileDao = new DMSfileDao(newLink);
        //RestTemplate restTemplate = new RestTemplate();
        try {
            RestTemplate restTemplate = new RestTemplate();
            String requestJson = "{\"oldLink\":\""+body.getLink()+"\",\"fileLink\":\""+newLink+"\"}";



            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
            String answer = restTemplate.postForObject(uri, entity, String.class);
            //body.setLink(newLink);
            //System.out.println(answer);

            //HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
            //DMSfileDao result = restTemplate.postForObject(uri, entity,DMSfileDao.class);
            //System.out.println(result.getFileLink() );

            body.setLink(newLink);
            //body.setLink(result.getFileLink());

            return body;
        }catch (Exception e){
            throw new DocumentNotFoundException();
        }
    }

    private String generateNewLink (String description, String oldLink){

        int fileTypePosition = oldLink.indexOf(".");
        String extension = oldLink.substring(fileTypePosition);


        String urlpath = oldLink.substring(0,oldLink.lastIndexOf("/")+1);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());


        return urlpath + description.replace(" ","_") + timeFormat.format(timestamp) + extension;


    }
}
