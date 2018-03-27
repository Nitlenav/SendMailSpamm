package SendMailPost.Controller;

import SendMailPost.View.LeftPanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PathToFileTextFileld extends JTextField {
    private CyclicDeliveryLetters cyclicDeliveryLetters = CyclicDeliveryLetters.getCyclicDeliveryLetters();
    public PathToFileTextFileld() {
        super("C:\\pdf");
        setEditable(false);
    }
}
