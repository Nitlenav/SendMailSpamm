package SendMailPost.Controller;

import SendMailPost.Model.ModelData;

import javax.swing.table.AbstractTableModel;

public class FirstColumnTableModel extends AbstractTableModel {

    public FirstColumnTableModel() {
    }

    public FirstColumnTableModel(ModelData modelData) {
        data = modelData.getSelectData();
        columnName = modelData.getColumnNameSelectData();
    }

    // Методы
    public int getRowCount() {
        return data.length;
    }

    public int getColumnCount() {
        if (data != null)
            return data[0].length;
        else return 0;
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public String getColumnName(int column) {
        return columnName[column];
    }

    private Object[][] data;
    private String[] columnName;

}
