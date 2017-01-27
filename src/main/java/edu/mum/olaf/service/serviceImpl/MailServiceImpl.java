package edu.mum.olaf.service.serviceImpl;

import edu.mum.olaf.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by ahmad on 18/06/2016.
 */
public class MailServiceImpl implements MailService{


    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendMail(String to, String subject, String message, String fileLocation) throws MessagingException {
        FileSystemResource file = new FileSystemResource(fileLocation);
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        helper.setSubject(subject);
        helper.setTo(to);
        helper.setText(message);
        helper.addAttachment(file.getFilename(), file);
        mailSender.send(mimeMessage);
    }
}
