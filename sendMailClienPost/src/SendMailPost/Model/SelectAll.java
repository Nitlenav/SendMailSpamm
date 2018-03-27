package SendMailPost.Model;

import java.sql.SQLException;

public class SelectAll implements ModelData
{
    private Object selectData [][];
    private String [] columnNameSelectData;
    @Override
    public String[] getColumnNameSelectData() {
        return columnNameSelectData = new String[]{"Бух. код", "Название клиента", "Электронный адрес"};
    }

    @Override
    public  Object[][] getSelectData(){
        try {
            Object allData [][] = new ModelSend(new Select().getSelectAll()).getQueryData();
            selectData = new Object[allData.length][3];
            for (int i = 0; i < allData.length; i++){
                selectData[i][0] = allData[i][0];
                selectData[i][1] = allData[i][1];
                selectData[i][2] = allData[i][5];
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selectData;
    }
}
