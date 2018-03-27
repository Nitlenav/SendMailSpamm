package SendMailPost.ConnectingMailboxSendingMail;

import SendMailPost.Controller.LogerMessage;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Класс для рассылки писем с почтового сервера
 */
public class SendMail {

    private String subject;         //Заголовок письма
    private String content;         //Тело письма
    private String addressFrom;     //Почта отправителя
    private String[] addressTo;     //Почта получчателя
    private String[] attachment;    //место хранения файла
    private Mail sendMail;
    private LogerMessage loger;




    public void setInitializingData(TextMessag textMessag, Mail mail) {
        this.subject = textMessag.getMessageHeader() + " " + textMessag.getFirmName();        //Заголовок письма
        this.content = textMessag.getTextMessage();          //Тело письма
        this.addressFrom = mail.getEmailSender();            //Почта отправителя
        this.addressTo = mail.getEmailRecipient();           //Почта получателя
        this.attachment = mail.getLocation();                //Место расположения файла
        this.sendMail = mail;
        try {
            this.loger = new LogerMessage();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage() throws MessagingException, FileNotFoundException {
        MimeMessage msg = new MimeMessage(ConnectingToMailServer.getSession());
        if (this.addressTo != null) {
            for (int i = 0; i < this.addressTo.length; i++) {
                //if (this.addressTo[i].matches("[А-Яа-яA-Za-z0-9]+(\\.[А-Яа-яA-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@[_А-Яа-яA-Za-z0-9\\-]+.[А-Яа-яA-Za-z]{2,}"))
                try {
                    if (this.addressTo[i].contains("@")){
                        msg.setFrom(new InternetAddress(this.addressFrom));      //вводится почта отправителя
                        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(this.addressTo[i]));    //вводится почта получателя
                        //msg.setRecipient(Message.RecipientType.TO, new InternetAddress("lav@telefonet.ru"));
                        //msg.setRecipient(Message.RecipientType.TO, new InternetAddress("Daaera@yandex.ru"));
                        //msg.setRecipient(Message.RecipientType.TO, new InternetAddress("kvu@telefonet.ru"));
                        msg.setSubject(subject, ConnectingToMailServer.getENCODING());                         //прекодировка текста.
                        BodyPart messageBodyPart = new MimeBodyPart();
                        messageBodyPart.setContent(content, "text/plain; charset=" + ConnectingToMailServer.getENCODING() + "");
                        //messageBodyPart.setContent(content, "text/html; charset=" + ConnectingToMailServer.getENCODING() + "");
                        Multipart multipart = new MimeMultipart();
                        multipart.addBodyPart(messageBodyPart);
                        if (sendMail.getSendAttachment() && attachment != null) {
                        //if (false) {
                            for (int a = 0; a < attachment.length; a++) {
                                try {
                                    MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                                    DataSource source = new FileDataSource(attachment[a]); //передаётся адрес хранения файла
                                    attachmentBodyPart.setDataHandler(new DataHandler(source));
                                    attachmentBodyPart.setFileName(MimeUtility.encodeText(source.getName()));
                                    multipart.addBodyPart(attachmentBodyPart);
                                } catch (UnsupportedEncodingException e) {
                                    loger.setErrorLog(e.toString());
                                    e.printStackTrace();
                                }
                            }
                            loger.setLogMessage(this.addressTo[i]+ ";Отправлено" );
                        }
                        try{
                        msg.setContent(multipart);
                        Transport.send(msg);

                        }
                        catch (SendFailedException e){
                            loger.setErrorLog(e.toString());
                        }
                    }
                }
                catch (AddressException a){
                    //делает что либо
                    loger.setErrorLog(a.toString());
                }
            }
        }
    }
}
