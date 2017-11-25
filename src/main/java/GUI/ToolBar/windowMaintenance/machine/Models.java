package GUI.ToolBar.windowMaintenance.machine;

import java.util.ArrayList;
import java.util.TreeSet;

public class Models {
    private TreeSet machinList;

    public Models() {
        machinList = new TreeSet();
        machinList.add( new D275A_5());
        machinList.add( new HD785_7());


    }

    public TreeSet getMachinList() {
        return machinList;
    }

    public void setMachinList(TreeSet machinList) {
        this.machinList = machinList;
    }
}
