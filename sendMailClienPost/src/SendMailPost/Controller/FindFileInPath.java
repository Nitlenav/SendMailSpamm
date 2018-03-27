package SendMailPost.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class FindFileInPath { //Поиск пути к файлу и возврат списка из найденых путей.
    //private String path; //путь к файлу
    private String buhCode = "";
    private ArrayList<String> pathFiles;
    private File fileIn;
    private String nameFiles  = "";;

    public void setBuhCode(String buhCode) {
        this.buhCode = buhCode;
    }

    public void setPathFiles(File file) {
        this.fileIn = file;
    }

    public void setNameFile(String nameFile) {
        this.nameFiles = nameFile;
    }


    public ArrayList<String> getPathFile() {
        pathFiles = new ArrayList<String>();
        File[] paht = fileIn.listFiles();

        if (!this.buhCode.isEmpty()){
            this.nameFiles = "\\d+_\\d+_" + this.buhCode + "_\\d+_\\w+.pdf";
       }

        for (File s : Objects.requireNonNull(paht)) {
            //поиск пути к вложению
            if (s.getName().matches(this.nameFiles)) {
                pathFiles.add(s.getAbsolutePath().toString());
            }
        }
        return pathFiles;
    }

}
