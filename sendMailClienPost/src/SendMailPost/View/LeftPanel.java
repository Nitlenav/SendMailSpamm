package SendMailPost.View;

import SendMailPost.Controller.ActiveObjects;
import SendMailPost.Controller.CyclicDeliveryLetters;
import SendMailPost.Controller.FirstColumnTableModel;
import SendMailPost.Controller.TextAndArea;
import SendMailPost.Model.ModelData;
import SendMailPost.Model.SelectActiveOrganizations;
import SendMailPost.Model.SelectActivePeoples;
import SendMailPost.Model.SelectAll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LeftPanel extends JPanel {

    private GridBagConstraints containLeft;
    private static JTable table;
    private JScrollPane scrollPane;
    private TextAndArea textArea;
    private JComboBox box;
    private SelectAll selectAll = new SelectAll();
    private SelectActiveOrganizations selectActiveOrganizations = new SelectActiveOrganizations();
    private SelectActivePeoples selectActivePeoples = new SelectActivePeoples();
    private ActiveObjects activeObjects = new ActiveObjects();
    private static ModelData model;
    private CyclicDeliveryLetters cyclicDeliveryLetters = CyclicDeliveryLetters.getCyclicDeliveryLetters();
    private String[] selector = {"Все", "Юридические лица", "Физические лица", "Действующие обьекты"};

    public LeftPanel() {
    }

    public static JTable getTable() {
        return table;
    }

    public static ModelData getModel(){return model;}

    public LeftPanel(Object[][] data, String[] columnName) {
        //splitPane.setOneTouchExpandable(true);
        //splitPane.setDividerLocation(50);
        setLayout(new GridBagLayout());
        containLeft = new GridBagConstraints();

        textArea = new TextAndArea();
        containLeft.fill = GridBagConstraints.HORIZONTAL;
        containLeft.weightx = 0.5;
        containLeft.gridx = 1;
        containLeft.gridy = 0;
        add(textArea, containLeft);

        box = new JComboBox(selector);
        cyclicDeliveryLetters.setData(selectAll);
        model = selectAll;
        box.addActionListener(new ActionListener() { //По нажатию на комбобокс выводим данные.
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (Objects.requireNonNull(box.getSelectedItem()).toString()) {
                    case "Все":
                        table.setModel(new FirstColumnTableModel(selectAll));
                        cyclicDeliveryLetters.setData(selectAll);
                        model = selectAll;
                        break;
                    case "Юридические лица":
                        table.setModel(new FirstColumnTableModel(selectActiveOrganizations));
                        cyclicDeliveryLetters.setData(selectActiveOrganizations);
                        model = selectActiveOrganizations;
                        break;
                    case "Физические лица":
                        table.setModel(new FirstColumnTableModel(selectActivePeoples));
                        cyclicDeliveryLetters.setData(selectActivePeoples);
                        model = selectActivePeoples;
                        break;
                    case "Действующие обьекты":
                        table.setModel(new FirstColumnTableModel(activeObjects));
                        cyclicDeliveryLetters.setData(activeObjects);
                        model = activeObjects;
                        break;
                }
            }
        });

        containLeft.fill = GridBagConstraints.HORIZONTAL;
        containLeft.weightx = 0.5;
        containLeft.gridx = 3;
        containLeft.gridy = 0;
        add(box, containLeft);

        table = new JTable(data, columnName);
        scrollPane = new JScrollPane(table);
        containLeft.fill = GridBagConstraints.BOTH;
        containLeft.ipady = 0;
        containLeft.weighty = 0.5;
        containLeft.anchor = GridBagConstraints.PAGE_END; //bottom of space
        containLeft.insets = new Insets(10, 0, 0, 0);  //top padding
        containLeft.gridx = 0;
        containLeft.gridwidth = 4;
        containLeft.gridy = 2;
        add(scrollPane, containLeft);
    }
}