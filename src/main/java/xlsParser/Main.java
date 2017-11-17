package xlsParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String args[]) throws IOException {
        PartInStock partInStock = new PartInStock();
        XlsReader xlsReader = new XlsReader("E:/Paruyr/codes/warehouse/src/main/resources/Short List.xls");
        ArrayList<PartInStock> arrayList = partInStock.buildListOfPartInStok(xlsReader.getActionsList());

//        Iterator<PartInStock> iterator = arrayList.iterator();
//        int k = 0;
//        while(iterator.hasNext()){
//            k++;
//              System.out.println( k + "|"+iterator.next().toString());
//        }

        System.out.println(arrayList);

//      cc.selectYear(2014);
//     	cc.selectInOrOut("Выход");
//     	cc.selectPartNumber("01643-32060");
//      cc.printCurrentList();
//		cc.getCurrentLenght();
//        System.out.println(cc.getActionsList().get(1).createInsertQuery("namename"));

    }
}
