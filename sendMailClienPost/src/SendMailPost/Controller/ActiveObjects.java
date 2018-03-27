package SendMailPost.Controller;

import SendMailPost.Model.ModelData;
import SendMailPost.Model.ModelSend;
import SendMailPost.Model.Select;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс парсит данные из класса Select и выводит на экран все активные обькты.
 */
public class ActiveObjects implements ModelData {
    private Object [][] selectData ;
    private String [] columnNameSelectData;

    @Override
    public String[] getColumnNameSelectData() {
        return columnNameSelectData = new String[]{"Код объекта", "Название объекта", "Электронный адрес"};
    }

    @Override
    public Object[][] getSelectData(){
        try {
            Object allData [][] = new ModelSend(new Select().getSelectAll()).getQueryData();
            List<Object[]> listData = new ArrayList<Object[]>();
            for (int i = 0; i < allData.length; i++){
                if (!(allData[i][3].equals("998"))&& !(allData[i][5].equals(""))) {
                    listData.add(new Object[] {allData[i][3], allData[i][4], allData[i][5]});
                }
            }
            selectData = listData.toArray(new Object[listData.size()][3]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selectData;
    }

}
