package com.tayo.test.sendNotification;

import com.tayo.test.exception.GlobalRestException;
import com.tayo.test.model.Response;
import com.tayo.test.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


/**
 * @Author talabiomotayo on 7/1/20
 */
@Component
public class MailAgent {

    private final static Logger LOGGER = LoggerFactory.getLogger(MailAgent.class);

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailAgent(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public Response generateAndSendEmail(User user) {

        MimeMessage msg = javaMailSender.createMimeMessage();

        try {

            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(user.getReceiver());
            msg.setSubject(user.getSubject());
            // default = text/plain
            msg.setText(user.getHtmlTemplate());
            javaMailSender.send(msg);
            Response response = new Response();
            response.setResponseCode("00");
            response.setResponseMessage("Mail sent successfully.");
            return response;

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new GlobalRestException("99", e.toString());
        }
    }






}
