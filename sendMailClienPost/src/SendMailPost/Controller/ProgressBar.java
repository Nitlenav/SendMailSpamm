package SendMailPost.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProgressBar extends JProgressBar{
    public ProgressBar() throws InterruptedException {
        super();
        setMinimum(0);
        setMaximum(100);
//        setMaximum(CyclicDeliveryLetters.getCyclicDeliveryLetters().getData().length);
        //setValue(0);
        setStringPainted(true);

    }

//    @Override
//    public void setMaximum(int n) {
//        super.setMaximum(n);
//    }
//
//    @Override
//    public void setValue(int n) {
//        super.setValue(n);
//    }
}
