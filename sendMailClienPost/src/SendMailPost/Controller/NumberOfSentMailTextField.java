package SendMailPost.Controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class NumberOfSentMailTextField extends JTextField {
    public NumberOfSentMailTextField() {
        super("0");
        setEditable(false);
        CyclicDeliveryLetters.getCyclicDeliveryLetters().setValSendMessages(this);
    }
}
