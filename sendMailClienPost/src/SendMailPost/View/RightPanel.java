package SendMailPost.View;

import SendMailPost.ConnectingMailboxSendingMail.TextMessag;
import SendMailPost.Controller.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightPanel extends JPanel { //наполнение левой панели в программе

    public RightPanel(Object[][] data, String[] columnName) throws InterruptedException {
        gridBagLeft = new GridBagLayout();
        setLayout(gridBagLeft);

        containRight = new GridBagConstraints();
        ((GridBagLayout) getLayout()).columnWidths = new int[]{40, 40, 40, 40, 40, 40, 40, 40};
        ((GridBagLayout) getLayout()).rowHeights = new int[]{0, 0, 0, 0};
        ((GridBagLayout) getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        ((GridBagLayout) getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};

        pathToFile = new PathToFileTextFileld(); //Текстовое поле, путь к файлу для рассылки.
        add(pathToFile,
                new GridBagConstraints(0, 0, 6, 1, 0.5, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        pathSelection = new ButtonPathToFile(this.pathToFile);//Кнопка выбора пути к файлу для рассылки.
        add(pathSelection,
                new GridBagConstraints(6, 0, 2, 1, 0.5, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        cancelAttachment = new JCheckBox("Вложить файл и не рассылать всем.");
        cancelAttachment.setSelected(false);
        cyclicDeliveryLetters.setCheckAttachment(cancelAttachment);
        cancelAttachment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cyclicDeliveryLetters.setCheckAttachment(cancelAttachment);
            }
        });
        add(cancelAttachment,
                new GridBagConstraints(0, 1, 8, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));

        sendingFile = new ButtonSendingFile();//Кнопка для начала рассылки.
        add(sendingFile,
                new GridBagConstraints(0, 2, 2, 1, 0.5, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        progressImplementation = cyclicDeliveryLetters.getProgress();
        add(progressImplementation,
                new GridBagConstraints(2, 2, 6, 1, 0.5, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        nameLatter = new TextAndField(); //Добавляем текст заголовка
        add(nameLatter,
                new GridBagConstraints(0, 3, 5, 1,0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        checkLatter = new JCheckBox("Данные из колонки с Названием");
        checkLatter.setSelected(false);
        cyclicDeliveryLetters.setCheckBox(checkLatter);
        checkLatter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cyclicDeliveryLetters.setCheckBox(checkLatter);
            }
        });
        add(checkLatter,
                new GridBagConstraints(5, 3, 3, 1,0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));

        textLatter = new TextMessageAndArea(textMessag); //Добавляем текст письма
        scrollTextLatter = new JScrollPane(textLatter);
        scrollTextLatter.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),"Текст письма"),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        add(scrollTextLatter,
                new GridBagConstraints(0, 4, 8, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 300));

        labelSend = new JLabel("Отправлено");
        add(labelSend,
                new GridBagConstraints(0, 5, 1, 1, 1.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        countSend = new NumberOfSentMailTextField();
        add(countSend,
                new GridBagConstraints(1, 5, 1, 1, 1.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        labelDontSend = new JLabel("Не отправлено");
        add(labelDontSend,
                new GridBagConstraints(3, 5, 1, 1, 1.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        countDontSend = new NumberOfDontSentMailTextField();
        countDontSend.setText(String.valueOf(cyclicDeliveryLetters.getData().length));
        add(countDontSend,
                new GridBagConstraints(4, 5, 1, 1, 1.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
    }

    public JProgressBar getProgressImplementation() {
        return progressImplementation;
    }

    private CyclicDeliveryLetters cyclicDeliveryLetters = CyclicDeliveryLetters.getCyclicDeliveryLetters();
    private GridBagConstraints containRight;
    private GridBagLayout gridBagLeft;
    private ButtonPathToFile pathSelection;
    private ButtonSendingFile sendingFile;
    private JProgressBar progressImplementation;
    private JScrollPane scrollTextLatter; //Скрол письма
    private PathToFileTextFileld pathToFile;          //Путь к файлу
    private JCheckBox cancelAttachment; //Отмена вложений, рассылать всем.
    private JLabel labelSend;
    private NumberOfSentMailTextField countSend;
    private JLabel labelDontSend;
    private NumberOfDontSentMailTextField countDontSend;
    private TextAndField nameLatter; //Заголовок письма
    private JCheckBox checkLatter; //Добавить данные из колонки название
    private TextMessageAndArea textLatter; //Текст письма
    private TextMessag textMessag = new TextMessag();


}
