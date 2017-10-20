package xlsParser;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class XlsReader {
        private ArrayList<Action> actionsList = new ArrayList<Action>();
        private ArrayList<Action> currentList = new ArrayList<Action>();
        private SimpleDateFormat shortDate = new SimpleDateFormat("yyyy/MM/dd");

        public XlsReader(String filePath) throws IOException{
            InputStream ExcelFileToRead = new FileInputStream(filePath);
            HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
            HSSFSheet sheet=wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                row=(HSSFRow) rows.next();
                cell = row.getCell(0);
                Action temp = new Action();
                temp.setDate(cell.getDateCellValue());
                cell = row.getCell(1);
                temp.setIn_out(cell.getStringCellValue());
                cell = row.getCell(2);
                temp.setPartNumber(cell.getStringCellValue());
                cell = row.getCell(3);
                temp.setUnit(cell.getStringCellValue());
                cell = row.getCell(4);
                temp.setQuantity(cell.getNumericCellValue());
                cell = row.getCell(5);
                temp.setPartName(cell.getStringCellValue());
                currentList.add(new Action(temp));
//  System.out.println(shortDate.format(temp.getDate())+" | "+temp.getIn_out()+" | "+temp.getPartNumber()+" | "+temp.getQuantity()+" | "+ temp.getPartName());
                actionsList.add(temp);}

            wb.close();
        }

        /////////////// RETURN ACTIONSLIST/////////////////////////
    public ArrayList<Action> getActionsList() {
        return actionsList;
    }

    ///////////////PRINT FIRST LIST////////////////////////////
        public  void printActList() {
            Action temp =  new Action();
            Iterator<Action> itr = actionsList.iterator();
                while(itr.hasNext()) {
                temp =  itr.next();
               System.out.println(temp.toString());
                            }
        }

        ///////////////PRINT CURRENT LIST//////////////////////////
        public  void printCurrentList() {
            Action temp =  new Action();
            Iterator<Action> itr = currentList.iterator();
            while(itr.hasNext()) {
                temp =  itr.next();
                System.out.println(shortDate.format(temp.getDate())+" | "+temp.getIn_out()+" | "+temp.getPartNumber()+" | "+temp.getQuantity()+" | "+ temp.getPartName());
            }
        }

        ////////////////SELECT YEAR///////////////////////////////////
        public void selectYear(int year){
            ArrayList<Action> listToRemove = new ArrayList<Action>();
            Iterator<Action> itr = currentList.iterator();
            Action temp = new Action();
            while (itr.hasNext()){
                temp= itr.next();
                if(temp.getDate().before(new Date(year-1900, 0, 0)) || temp.getDate().after(new Date(year-1900, 11,31))){
                    listToRemove.add(temp);
                }
            }
            currentList.removeAll(listToRemove);
        }

        ////////////////GET LENGHT/////////////////////////////////
        public double getCurrentLenght(){
            System.out.println(currentList.size());
            return currentList.size();
        }

        ///////////////SELECT OUT OR IN///////////////////////////////
        public void selectInOrOut(String inOrOut){
            ArrayList<Action> listToRemove = new ArrayList<Action>();
            Iterator<Action> itr = currentList.iterator();
            Action temp = new Action();
            while (itr.hasNext()){
                temp= itr.next();
                if (inOrOut.equals(temp.getIn_out())) {
                }
                else listToRemove.add(temp);
            }
            currentList.removeAll(listToRemove);
        }

        ////////////////SELECT PART//////////////////////////////////
        public void selectPartNumber(String partNumber){
            ArrayList<Action> listToRemove = new ArrayList<Action>();
            Iterator<Action> itr = currentList.iterator();
            Action temp = new Action();
            while (itr.hasNext()){
                temp= itr.next();
                if (!partNumber.equals(temp.getPartNumber())) {
                    listToRemove.add(temp);
                }
            }
            currentList.removeAll(listToRemove);
        }

///////////////////SET YOUR ADVERTISMENT////////////////////
}
