package SendMailPost.ConnectingMailboxSendingMail;

import SendMailPost.Controller.ConnectFirebird;

import javax.mail.Session;
import java.io.*;
import java.util.Properties;

/**
 * Класс для подключения к почтовому серверу
 */
public class ConnectingToMailServer {

    private static String ENCODING = "UTF-8";             //Перевод в кодировку
    private static Session session = getSessionConnectionPost();

    private static Session getSessionConnectionPost() {
        InputStream inp = ConnectFirebird.class.getResourceAsStream("/configTextMessage.properties");
        Properties prop = new Properties();
        try {
            prop.load(inp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ENCODING = prop.getProperty("ENCODING");
        Properties props = System.getProperties();
        props.put("mail.smtp.host", prop.getProperty("SMTPHOST"));
        props.put("mail.smtp.port", prop.getProperty("SMTPPORT"));
        props.put("mail.smtp.auth", "true");
        props.put("mail.mime.charset", ENCODING);
        AuthenticationMailPost auth = new AuthenticationMailPost(prop.getProperty("LOGIN"), prop.getProperty("PASSWORD"));
        Session session = Session.getDefaultInstance(props, auth);
        return session;
    }

    public static Session getSession() {
        return session;
    }

    public static String getENCODING() {
        return ENCODING;
    }
}
