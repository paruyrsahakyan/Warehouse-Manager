package GUI.requestWindow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class ResultAndRequest {

    public Object[][] compareToRequest(ArrayList<RequestedPart> partslist, ResultSet resultSet) throws SQLException {
        int matchedPartsQuantity = 0;
        while (resultSet.next()) {
            matchedPartsQuantity++;
        }
        Object[][] result = new Object[matchedPartsQuantity][7];
        resultSet.beforeFirst();
        resultSet.beforeFirst();
        int resultcursor = -1;

        while (resultSet.next()) {
            resultcursor++;
            Iterator<RequestedPart> iterator = partslist.iterator();
            RequestedPart currRequestedPart;

            while (iterator.hasNext()) {

                currRequestedPart = iterator.next();

                if (currRequestedPart.getPartNumber().equals(resultSet.getString(3))) {

                    result[resultcursor][0] = resultSet.getString(3);
                    result[resultcursor][1] = currRequestedPart.getQuantity();
                    result[resultcursor][3] = resultSet.getInt(5);
                    result[resultcursor][4] = resultSet.getString(4);
                    result[resultcursor][5] = resultSet.getString(6);
                    result[resultcursor][6] = resultSet.getString(2);

                    if (resultSet.getInt(5) > currRequestedPart.getQuantity()) {
                        result[resultcursor][2] = currRequestedPart.getQuantity();
                    } else {
                        result[resultcursor][2] = resultSet.getInt(5);
                    }

                }

            }

        }
        return result;
    }
}

