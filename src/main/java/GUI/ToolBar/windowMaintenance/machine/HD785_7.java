package GUI.ToolBar.windowMaintenance.machine;

import GUI.ToolBar.windowMaintenance.TM.TM;
import GUI.ToolBar.windowMaintenance.TM.TMPart;

public class HD785_7 extends Machine implements Comparable{

    HD785_7() {

        this.setModel(" HD785-7");

        TM tm_250 = new TM(250);
        TMPart[] patList1 = {new TMPart("600-211-1340", 4),
                new TMPart("SYZZ-10W30DM-Y", 135),
                new TMPart("GLI", 20)};
        tm_250.setPartList(patList1);

        this.getTmList().add(tm_250);


        TM tm_500 = new TM(500);
        TMPart[] patList2 = {new TMPart("600-211-1340", 1),
                new TMPart("SYZZ-10W30DM-Y", 55),
                new TMPart("GLI", 5),
                new TMPart("600-319-4540", 2),
                new TMPart("569-16-81160", 4),
                new TMPart("07000-12125", 4),
        };
        tm_500.setPartList(patList2);
        this.getTmList().add(tm_500);

    }

    public int compareTo(Object o) {
        Machine  machine = (Machine) o;
        return this.getModel().compareTo(machine.getModel());
    }

    @Override
    public String toString() {
        return this.getModel();
    }
}
