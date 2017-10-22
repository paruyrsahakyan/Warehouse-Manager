package toDB;

import xlsParser.XlsReader;

import java.io.IOException;

public class ImportMain {
  private static final String XLSPath = "E:/Paruyr/codes/warehouse/src/main/resources/MTOperationsJournal.xls";
  private static final String tableName = "action";

  public static void main(String args[]) throws ClassNotFoundException {
    XlsReader xlsReader;
    try {
      xlsReader = new XlsReader(XLSPath);
      ImportToDB.getInstance().createTable(tableName);
      ImportToDB.getInstance().importActions(xlsReader.getActionsList());
      //ImportToDB.getInstance().importActions(gk);
//      db.createTable(tableName);
//                  xlsReader.printActList();
      //db.importActions(xlsReader.getActionsList());

    } catch (IOException e) {
      e.printStackTrace();
    }

    //            xlsReader.printActList();db.importActions(xlsReader.getActionsList());
  }


}

