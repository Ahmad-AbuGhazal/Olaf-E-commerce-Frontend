package edu.mum.olaf.service;

import javax.mail.MessagingException;

/**
 * Created by ahmad on 18/06/2016.
 */
public interface MailService {

    void sendMail(String to, String Subject, String message,String fileLocation) throws MessagingException;
}
