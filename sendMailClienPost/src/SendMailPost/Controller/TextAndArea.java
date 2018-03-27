package SendMailPost.Controller;

import SendMailPost.Model.ModelData;
import SendMailPost.View.LeftPanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
/**
 * Класс для подключает слушателя нахожит всех клиентов по бухкоду.
 */
public class TextAndArea extends JTextArea {
    private JTable table;
    private CyclicDeliveryLetters cyclicDeliveryLetters = CyclicDeliveryLetters.getCyclicDeliveryLetters();
    private ModelData model;
    private String text;
    private FindDataInArray findDataInArray;

    public TextAndArea() {
        super();
        DocumentListener doc = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                table = LeftPanel.getTable();
                text = TextAndArea.super.getText();
                model = LeftPanel.getModel();
                findDataInArray = new FindDataInArray(model , text);
                table.setModel(new FirstColumnTableModel(findDataInArray));
                cyclicDeliveryLetters.setData(findDataInArray);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                table = LeftPanel.getTable();
                text = TextAndArea.super.getText();
                model = LeftPanel.getModel();
                findDataInArray = new FindDataInArray(model , text);
                table.setModel(new FirstColumnTableModel(findDataInArray));
                cyclicDeliveryLetters.setData(findDataInArray);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                table = LeftPanel.getTable();
                text = TextAndArea.super.getText();
                model = LeftPanel.getModel();
                findDataInArray = new FindDataInArray(model , text);
                table.setModel(new FirstColumnTableModel(findDataInArray));
                cyclicDeliveryLetters.setData(findDataInArray);
            }
        };
        getDocument().addDocumentListener(doc);
    }
}
