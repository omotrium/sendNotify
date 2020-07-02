package com.tayo.test.controller;

import com.tayo.test.model.Response;
import com.tayo.test.model.User;
import com.tayo.test.sendNotification.MailAgent;
import com.tayo.test.sendNotification.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author talabiomotayo on 7/1/20
 */

@RestController
@RequestMapping("/api")
public class Test {


    @Autowired
    MailAgent mailAgent;

    @Autowired
    SendSms sendSms;


    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public Response sendEmail(@RequestBody User user) {


        Response response1 = mailAgent.generateAndSendEmail(user);
        if (response1.getResponseCode().equals("00")) {
            Response response = sendSms.sendSmsToUser(user);
            return response;
        }

        return response1;
    }
}
