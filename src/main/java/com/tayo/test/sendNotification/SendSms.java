package com.tayo.test.sendNotification;

import com.tayo.test.model.Response;
import com.tayo.test.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author talabiomotayo on 7/2/20
 */
@Component
public class SendSms {

    private final static Logger LOGGER = LoggerFactory.getLogger(SendSms.class);

    @Autowired
    Environment environment;


    public Response sendSmsToUser(User user) {
        HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> requestEntity = new HttpEntity<>(user, requestHeaders);
        LOGGER.debug("++++ requestEntity ==> " + requestEntity + " ++++");

        String url = environment.getProperty("smsUrl") + "to=" + user.getPhoneNumber() + "&body=" + user.getHtmlTemplate();
        //https://www.bulksmsnigeria.com/api/v1/sms/create?api_token=xXi9yKhlJphJwgsXYqhH5BPtdN4cRVw3NRrSfgLbFFcjA3e3YXIyDoZEZJG4&from=BulkSMS.ng&to=2348062743619&body=Welcome&dnd=2

        LOGGER.info("myurl" + url);

        url = url == null ? "" : url;
        LOGGER.info("++++ url ==> " + url);
        RestTemplate restTemplate = new RestTemplate();
        LOGGER.info("++++ httpclientrestTemplate ==> " + restTemplate);

        ResponseEntity<Response> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
                requestEntity, Response.class);

        LOGGER.info("++++ responseEntityBody ==> " + responseEntity.getBody().getData().getStatus());
        if (responseEntity.getBody().getData().getStatus().equals("success")) {
            Response response = new Response();
            response.setResponseCode("00");
            response.setResponseMessage("Mail sent successfully.");
            return  response;
        }
            return responseEntity != null ? responseEntity.getBody() : new Response();
        }
    }

