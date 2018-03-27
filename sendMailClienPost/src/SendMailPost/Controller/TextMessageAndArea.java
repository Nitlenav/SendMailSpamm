package SendMailPost.Controller;

import SendMailPost.ConnectingMailboxSendingMail.TextMessag;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextMessageAndArea extends JTextArea {
    private CyclicDeliveryLetters cyclicDeliveryLetters = CyclicDeliveryLetters.getCyclicDeliveryLetters();
    private String textMessagInMail;

    public TextMessageAndArea(TextMessag textMessage){
        super(textMessage.getTextMessage());
        DocumentListener doc = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textMessagInMail = TextMessageAndArea.super.getText();
                textMessage.setTextMessage(textMessagInMail);
                cyclicDeliveryLetters.setTextMessag(textMessage);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textMessagInMail = TextMessageAndArea.super.getText();
                textMessage.setTextMessage(textMessagInMail);
                cyclicDeliveryLetters.setTextMessag(textMessage);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                textMessagInMail = TextMessageAndArea.super.getText();
                textMessage.setTextMessage(textMessagInMail);
                cyclicDeliveryLetters.setTextMessag(textMessage);
            }
        };
        getDocument().addDocumentListener(doc);
    }
}
