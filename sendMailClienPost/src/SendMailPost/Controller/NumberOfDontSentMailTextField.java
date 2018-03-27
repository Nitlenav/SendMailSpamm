package SendMailPost.Controller;

import javax.swing.*;

/*
Класс выводит количество не отправленых писем.
 */
public class NumberOfDontSentMailTextField extends JTextField{

    public NumberOfDontSentMailTextField() {
        super();
        setEditable(false);
        CyclicDeliveryLetters.getCyclicDeliveryLetters().setTextField(this);
    }
}
