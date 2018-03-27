package SendMailPost.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ButtonPathToFile extends JButton {
    private JFileChooser fileChooser = new JFileChooser();
    private CyclicDeliveryLetters cyclicDeliveryLetters = CyclicDeliveryLetters.getCyclicDeliveryLetters();
    private File fileOrPath;
    public ButtonPathToFile(JTextField textField) {
        super("Путь к файлу");
        fileChooser.setSelectedFile(new File(textField.getText()));
        fileChooser.setDialogTitle("Выбор директории");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = fileChooser.showDialog(null, "Открыть файл");
                if (result == JFileChooser.APPROVE_OPTION) {
                    fileOrPath = new File(String.valueOf(fileChooser.getSelectedFile()));
                    if (fileOrPath.isFile()){
                        cyclicDeliveryLetters.setNameFile(fileOrPath.getName());
                        cyclicDeliveryLetters.setPathToFile(new File(fileOrPath.getParent()));
                    }else {
                        //System.out.println(fileOrPath);
                        cyclicDeliveryLetters.setPathToFile(fileOrPath);
                    }
                    //cyclicDeliveryLetters.setPathToFile(fileChooser.getSelectedFile());
                    textField.setText((fileChooser.getSelectedFile()).toString());
                }
            }
        });
    }
}
