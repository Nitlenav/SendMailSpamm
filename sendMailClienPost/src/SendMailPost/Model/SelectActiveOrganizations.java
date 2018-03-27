package SendMailPost.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectActiveOrganizations implements ModelData {

    private Object [][] selectData ;
    private String [] columnNameSelectData;
    @Override
    public String[] getColumnNameSelectData() {
        return columnNameSelectData = new String[]{"Бух. код", "Название клиента", "Электронный адрес"};
    }

    @Override
    public Object[][] getSelectData(){
        try {
            Object allData [][] = new ModelSend(new Select().getSelectAll()).getQueryData();
            List<Object[]> listData = new ArrayList<Object[]>();
            for (int i = 0; i < allData.length; i++){
                if (allData[i][6].equals("ОАО Банк ВТБ")&& !(allData[i][3].equals("998")) && !(allData[i][5].equals(""))) {
                    listData.add(new Object[] {allData[i][0], allData[i][1], allData[i][5]});
                }
            }
            selectData = listData.toArray(new Object[listData.size()][3]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selectData;
    }

}
