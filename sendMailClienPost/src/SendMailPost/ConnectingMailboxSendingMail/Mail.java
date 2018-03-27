package SendMailPost.ConnectingMailboxSendingMail;

public class Mail {

    private String[] emailRecipient;  //Адресс получателя
    private String emailSender = new String("billing@telefonet.ru"); //Адрес отправителя
    //private String emailSender = new String("Daaera@yandex.ru");
    private String[] location; //Место расположенияфайла.
    private Boolean sendAttachment = false;

    public String[] getEmailRecipient() {
        return emailRecipient;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public String[] getLocation() {
        return location;
    }

    public Boolean getSendAttachment() {
        return sendAttachment;
    }

    public void setEmailRecipient(String[] emailRecipient) {
        this.emailRecipient = emailRecipient;//new String[]{"lav@telefonet.ru", "lav@tn.local"};
    }

    public void setLocation(String[] location) {
        this.location = location;
    }

    public void setSendAttachment(Boolean sendAttachment) {
        this.sendAttachment = sendAttachment;
    }
}
