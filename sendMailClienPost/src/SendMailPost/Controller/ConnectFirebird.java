package SendMailPost.Controller;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectFirebird { //класс для создания подключения к БД

    private static final String driver = "org.firebirdsql.jdbc.FBDriver";
    private String ip;// = "172.16.10.33";
    private String alias;// = "Telenet";
    private String url;// = "jdbc:firebirdsql://"+ ip +"/"+ alias +"?encoding=utf8&amp";
    private String login;// = "JAVA_CLIENT";
    private String passwrd;// = "159753";

    private Connection connect ;

    public Connection getConnect() {
        return connect;
    }

    public ConnectFirebird(){
        InputStream inp = ConnectFirebird.class.getResourceAsStream("/configTextMessage.properties");
        Properties prop = new Properties();

        try {
            prop.load(inp);
            ip = prop.getProperty("ip_bd");
            alias = prop.getProperty("alias");
            login = prop.getProperty("login");
            passwrd = prop.getProperty("passwrd");
            url = "jdbc:firebirdsql://"+ ip +"/"+ alias +"?encoding=utf8&amp";

            Class.forName(driver).newInstance();
            connect = DriverManager.getConnection(url, login, passwrd);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close (){
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
