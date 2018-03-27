package SendMailPost.Controller;

import SendMailPost.ConnectingMailboxSendingMail.TextMessag;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class TextAndField extends JTextField { //Текстовое поле заголовка письма
    static String paht = new TextMessag().getMessageHeader();
    private CyclicDeliveryLetters cyclicDeliveryLetters = CyclicDeliveryLetters.getCyclicDeliveryLetters();
    private String text;
    private TextMessag textMessag;
    public TextAndField() {
        super(paht);
        setBorder(new TitledBorder("Заголовок письма"));
        DocumentListener doc = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                text = TextAndField.super.getText();
                textMessag = cyclicDeliveryLetters.getTextMessag();
                textMessag.setMessageHeader(text);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text = TextAndField.super.getText();
                textMessag = cyclicDeliveryLetters.getTextMessag();
                textMessag.setMessageHeader(text);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text = TextAndField.super.getText();
                textMessag = cyclicDeliveryLetters.getTextMessag();
                textMessag.setMessageHeader(text);
            }
        };
        getDocument().addDocumentListener(doc);
    }
}
