package toDB;
import xlsParser.XlsReader;

import java.io.IOException;
public class FromXLStoDB {
    private final String XLSPath = "E:/Paruyr/codes/warehouse/src/main/resources/MTOperationsJournal.xls";
    private final String tableName = "action";
    public FromXLStoDB() {

        XlsReader xlsReader;
            try {
                xlsReader = new XlsReader(XLSPath);
                ImportToDB db = new ImportToDB();
                db.createTable(tableName);
                //            xlsReader.printActList();
                db.importActions(xlsReader.getActionsList());

            } catch (IOException e) {
                e.printStackTrace();
            }

//            xlsReader.printActList();db.importActions(xlsReader.getActionsList());

        }
}