package SendMailPost.Controller;


import SendMailPost.ConnectingMailboxSendingMail.Mail;
import SendMailPost.ConnectingMailboxSendingMail.SendMail;
import SendMailPost.ConnectingMailboxSendingMail.TextMessag;
import SendMailPost.Model.ModelData;

import javax.mail.MessagingException;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Класс для циклической рассылки почты
 */
public class CyclicDeliveryLetters {

    private final static CyclicDeliveryLetters cyclicDeliveryLetters = new CyclicDeliveryLetters();
    private Object[][] data;            //Масив данных с запроса к БД
    private String[] columnName;        //Название колонок
    private String code;                //Бух код клиента
    private String firmName;            //Название клиента
    private String[] emailAddres;       //Электронный адрес клиента
    private TextMessag textMessag = new TextMessag();//Текст сообщения и название письма
    private JCheckBox checkBox;         //Добавить или убрать данные из колонки с названием
    private JCheckBox checkAttachment;  //Галочка вложить файл и не рассылать всем.
    private Mail mail;                  //Элктронный адрес отправителя, получателя и место расположения файлов для рассылки
    private FindFileInPath fileInPath;
    private SendMail sendMail = new SendMail();
//    private int valProgressBar = 0;
    private int valSendMessage = 0;
    private JProgressBar progress;
    private ModelData modelData;
    private JTextField textField = new JTextField();
    private JTextField valSendMessages = new JTextField();
    private int dataLenth = 0;
    private File pathToFile = new File("C:\\pdf");
    private String nameFile = "";

    public static CyclicDeliveryLetters getCyclicDeliveryLetters() {
        return cyclicDeliveryLetters;
    }

    private CyclicDeliveryLetters() {
        progress = new JProgressBar();
        progress.setStringPainted(true);
    }

    public void setData(ModelData modelData) {
        this.columnName = modelData.getColumnNameSelectData();
        this.data = modelData.getSelectData();
        this.modelData = modelData;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                textField.setText(String.valueOf(data.length));
                dataLenth = data.length;
            }
        });
    }

    public void setPathToFile(File pathToFile) {
        this.pathToFile = pathToFile;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public void setValSendMessages(NumberOfSentMailTextField valSendMessages) {
        this.valSendMessages = valSendMessages;
    }

    public void setTextMessag(TextMessag textMessag) {
        this.textMessag = textMessag;
    }

    public void setCheckBox(JCheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public void setCheckAttachment(JCheckBox checkAttachment) {
        this.checkAttachment = checkAttachment;
    }

    public Object[][] getData() {
        return data;
    }

    public TextMessag getTextMessag() {
        return textMessag;
    }

    public JProgressBar getProgress() {
        return progress;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public void sendingMessages() throws UnsupportedEncodingException, MessagingException, FileNotFoundException {
        String path[];
        String adres;
        mail = new Mail();
        fileInPath = new FindFileInPath(); //бух код и путь к файлу
        for (Object[] o : data) {
            code = String.valueOf(o[0]);
            firmName = String.valueOf(o[1]);
            if (nameFile.isEmpty()){
                fileInPath.setBuhCode(code);
                fileInPath.setPathFiles(this.pathToFile);
            }else {
                fileInPath.setNameFile(this.nameFile);
                fileInPath.setPathFiles(this.pathToFile);
            }

            if (String.valueOf(o[2]).contains("@")) {
                adres = String.valueOf(o[2]).replaceAll(",", " ");
                emailAddres = adres.split(" ");
            }

            //масив электронных адресов
            path = fileInPath.getPathFile().toArray(new String[fileInPath.getPathFile().size()]);
            //внести проверку на наличие электронных адресов.
            if (path.length > 0 && checkAttachment.isSelected()) {
                mail.setSendAttachment(checkAttachment.isSelected());
                valSendMessages.setText(String.valueOf(++valSendMessage));
                textField.setText(String.valueOf(--dataLenth));
                //вводим Емеил для рассылки
                mail.setEmailRecipient(emailAddres);

                // Путь к файлу рассылки.
                mail.setLocation(path);

                //убрать или добавить данные из колонки Название
                if (checkBox.isSelected()){
                    textMessag.setFirmName(firmName);
                }else {
                    textMessag.setFirmName("");
                }

                //Передаём текст сообщения и список параметров для рассылки.
                sendMail.setInitializingData(textMessag, mail);
                //Выполняем рассылку
                sendMail.sendMessage();

            }else if (!checkAttachment.isSelected()){
                mail.setSendAttachment(checkAttachment.isSelected());
                valSendMessages.setText(String.valueOf(++valSendMessage));
                textField.setText(String.valueOf(--dataLenth));
                //вводим Емеил для рассылки
                mail.setEmailRecipient(emailAddres);
                //убрать или добавить данные из колонки Название
                if (checkBox.isSelected()){
                    textMessag.setFirmName(firmName);
                }
                //Передаём текст сообщения и список параметров для рассылки.
                sendMail.setInitializingData(textMessag, mail);
                //Выполняем рассылку
                sendMail.sendMessage();
            }
        }
    }
}
