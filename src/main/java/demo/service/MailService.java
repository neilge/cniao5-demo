package demo.service;

/**
 * @author Neo
 * @since 10/17/2020-9:14 PM
 */
public interface MailService {

    void sendMail(String to, String subject, String text);
}
