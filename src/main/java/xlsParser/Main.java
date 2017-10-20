package xlsParser;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {
        XlsReader cc= new XlsReader("E:/Paruyr/codes/warehouse/src/main/resources/MTOperationsJournal.xls");
		cc.printActList();
//      cc.selectYear(2014);
//     	cc.selectInOrOut("Выход");
//     	cc.selectPartNumber("01643-32060");
//      cc.printCurrentList();
//		cc.getCurrentLenght();
//        System.out.println(cc.getActionsList().get(1).createInsertQuery("namename"));

    }
}
