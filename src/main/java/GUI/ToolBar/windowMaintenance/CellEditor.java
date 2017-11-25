package GUI.ToolBar.windowMaintenance;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.util.EventObject;

public class CellEditor implements TableCellEditor {
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return null;
    }

    public Object getCellEditorValue() {
        return null;
    }

    public boolean isCellEditable(EventObject anEvent) {
        return false;
    }

    public boolean shouldSelectCell(EventObject anEvent) {
        return false;
    }

    public boolean stopCellEditing() {
        return false;
    }

    public void cancelCellEditing() {

    }

    public void addCellEditorListener(CellEditorListener l) {

    }

    public void removeCellEditorListener(CellEditorListener l) {

    }
}
