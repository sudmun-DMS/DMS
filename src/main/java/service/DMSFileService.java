package service;

import model.DMSBody;
import org.springframework.web.client.RestTemplate;
import java.text.SimpleDateFormat;
import org.springframework.http.*;
import java.sql.Timestamp;



public class DMSFileService {


    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    public DMSFileService() {
    }

    public DMSBody getFile(DMSBody body){

        String newLink = generateNewLink(body.getDescription(),body.getLink() );

        final String baseURL = "http://139.59.236.229:1150";

        final String uri = baseURL+"/files";

        try {
            RestTemplate restTemplate = new RestTemplate();
            String requestJson = "{\"oldLink\":\""+body.getLink()+"\",\"fileLink\":\""+newLink+"\"}";



            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
            restTemplate.postForObject(uri, entity, String.class);

            body.setLink(newLink);

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
