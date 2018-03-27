package SendMailPost.Controller;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class LogerMessage {
    private BufferedWriter bw;
    private BufferedWriter logbW;
    public LogerMessage() throws UnsupportedEncodingException, FileNotFoundException {
        Date dat = new Date();
        Locale locale = new Locale("ru", "RU");
        DateFormat curentDate = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String curDate = new String(curentDate.format(dat));
        String logSend = "../sendMesage_" + curDate + ".csv";
        String erroeLog = "../errorLog_" + curDate + ".txt";
        OutputStreamWriter writ = new OutputStreamWriter(new FileOutputStream(new File(logSend), true), "Cp1251");
        bw = new BufferedWriter(writ);
        OutputStreamWriter logWrit = new OutputStreamWriter(new FileOutputStream(new File(erroeLog), true), "Cp1251");
        logbW = new BufferedWriter(logWrit);
    }


    public void setLogMessage(String word){
        try {
            bw.write(word);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setErrorLog (String erroeLog) throws FileNotFoundException {
        try {
            logbW.write(erroeLog);
            logbW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}