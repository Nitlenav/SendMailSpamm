package SendMailPost.Controller;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class ButtonSendingFile extends JButton {

    private CyclicDeliveryLetters cyclicDeliveryLetters = CyclicDeliveryLetters.getCyclicDeliveryLetters();

    public ButtonSendingFile() {
        super("Отправка");
        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cyclicDeliveryLetters.sendingMessages();
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (MessagingException e1) {
                    e1.printStackTrace();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }
}
