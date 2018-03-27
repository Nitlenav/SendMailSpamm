package SendMailPost.Model;

import SendMailPost.Controller.ConnectFirebird;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Select {

    private String selectAll;

    public Select() {
        InputStream inp = Select.class.getResourceAsStream("/configTextMessage.properties");
        Properties prop = new Properties();
        try {
            prop.load(inp);
            selectAll  = prop.getProperty("selectAll");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSelectAll() {
        return selectAll;
    }

}
