package toDB;
import BasicNames.Name;
import xlsParser.Action;
import xlsParser.XlsReader;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class FromXLStoDB {
    private String XLSPath; // = "E:/Paruyr/codes/warehouse/src/main/resources/MTOperationsJournal.xls";
    private  JProgressBar progressBar;

    ////// CONSTRUCTOR OF SETTING FIELDS xlspath //////////////

    public FromXLStoDB(String XLSPath)
    {
        this.XLSPath = XLSPath;
        }
///////////////// GETTERS AND SETTERS ////////////////////////////

    public String getXLSPath() {
        return XLSPath;
    }

    public void setXLSPath(String XLSPath) {
        this.XLSPath = XLSPath;
    }

////////////////// GET FROM XLS AND SET TO DB //////////////////////////////

    public void getFromXlsSetToDB() {

        XlsReader xlsReader;
        ImportToDB importToDB;

            try {
                xlsReader = new XlsReader(XLSPath);
                ArrayList<Action> actions = xlsReader.getActionsList();

                importToDB = new ImportToDB();
//                importToDB.setProgressBar(this.progressBar);
                importToDB.createTables();
                //            xlsReader.printActList();
                importToDB.importActionsAndParts(actions);

            } catch (IOException e) {
                e.printStackTrace();
            }
//            xlsReader.printActList();db.importActions(xlsReader.getActionsList());
        }

        public  void setProgressBar(JProgressBar progressBar) {
        this.progressBar = progressBar;
        }





}