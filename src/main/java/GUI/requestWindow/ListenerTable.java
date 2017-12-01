package GUI.requestWindow;

import SQL.QueryFactory;
import toDB.ConnectionWithDB;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListenerTable implements MouseListener{
    JTable jTable;
    WindowPartsRequest windowPartsRequest;
    ListenerTable(WindowPartsRequest windowPartsRequest, JTable jTable) {
        this.windowPartsRequest = windowPartsRequest;
        this.jTable = jTable;


    }

    public void mouseClicked(MouseEvent e) {
      int row= jTable.rowAtPoint(e.getPoint());
      int column = jTable.columnAtPoint(e.getPoint());
        windowPartsRequest.getPanelResult().setSelectedRow(row);
         ArrayList<String> partNumber = new ArrayList<String>();
        double requestedQuantity=0;
      if (column==0){
        String purtNumber = (String) jTable.getValueAt(row, column);
         requestedQuantity = (Double) jTable.getValueAt(row, column+1);
           partNumber.add(purtNumber);

        }
        ConnectionWithDB connectionWithDB = ConnectionWithDB.getInstance();
      Statement statement = connectionWithDB.getStatement();
        QueryFactory queryFactory = new QueryFactory();
        try {
            ResultSet resultSet = statement.executeQuery(queryFactory.findExchangeable(partNumber));
            if (resultSet.next()) {
                ArrayList<RequestedPart> exchangeParts = new ArrayList<RequestedPart>();
                for (int i = 2; i < 9; i++) {
                    if (resultSet.getString(i) != null) {
                        RequestedPart currentReqPart = new RequestedPart();
                        currentReqPart.setPartNumber(resultSet.getString(i));
                        currentReqPart.setQuantity(requestedQuantity);
                        exchangeParts.add(currentReqPart);
//                        exchangeParts.add(resultSet.getString(i));
                    }
                }
                if(exchangeParts.size()>0) {
                    windowPartsRequest.setExchangeTableEmpty(false);
                    windowPartsRequest.getPanelExchangeParts().setTable(exchangeParts);
                }

            }
            else {
                windowPartsRequest.setExchangeTableEmpty(true);
                windowPartsRequest.getPanelExchangeParts().setEmptyTable();

            }
        }catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
