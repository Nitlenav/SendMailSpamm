package SendMailPost.Controller;

import SendMailPost.Model.ModelData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Класс для поиска данных в запросе из БД по введённому тексту.
public class FindDataInArray implements ModelData {

    private Object data[][];
    private String[] columnNameData;
    private String findText;
    private Object[][] selectData;

    public FindDataInArray(ModelData modelData, String text) {
        this.columnNameData = modelData.getColumnNameSelectData();
        this.data = modelData.getSelectData();
        this.findText = text;
    }

    @Override
    public Object[][] getSelectData() {
        List<Object[]> selectDatas = new ArrayList<Object[]>();
        if (findText == "" || findText.equals("")) {
            return data;
        } else {
            for (Object o[] : data) {
                if (o[0].toString().replace(" ", "").equals(findText) /*|| o[1].toString().contains(findText) || o[2].toString().contains(findText)*/) {
                    selectDatas.add(o);
                }
            }
            if (!(selectDatas.isEmpty())){
                selectData = selectDatas.toArray(new Object[selectDatas.size()][selectDatas.get(0).length]);
            }else {
                selectData = new Object[1][3];
                selectData[0][0] = "Данных нет";
                selectData[0][1] = "Данных нет";
                selectData[0][2] = "Данных нет";
            }
            return selectData;
        }
    }
    @Override
    public String[] getColumnNameSelectData() {
        return columnNameData;
    }
}
