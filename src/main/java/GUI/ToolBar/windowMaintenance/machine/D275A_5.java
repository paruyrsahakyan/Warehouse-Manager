package GUI.ToolBar.windowMaintenance.machine;

import GUI.ToolBar.windowMaintenance.TM.TM;
import GUI.ToolBar.windowMaintenance.TM.TMPart;

import java.util.ArrayList;

public class D275A_5 extends Machine implements Comparable
{

    D275A_5() {

        this.setModel(" D275A-5");

        TM tm_250 = new TM(250);
        TMPart[] patList1 = {new TMPart("600-211-1340", 1),
                new TMPart("SYZZ-10W30DM-Y", 55),
                new TMPart("GLI", 5)   };
        tm_250.setPartList(patList1);

        this.getTmList().add(tm_250);


        TM tm_500 = new TM(500);
        TMPart[] patList2 = {new TMPart("600-211-1340", 1),
                new TMPart("SYZZ-10W30DM-Y", 55),
                new TMPart("GLI", 5),
                new TMPart("600-311-7152", 1),
                new TMPart("07063-01100", 2),
                new TMPart("07000-52130", 2)
        };

        tm_500.setPartList(patList2);
        this.getTmList().add(tm_500);


        TM tm_1000 = new TM(1000);
        TMPart[] patList3 = {new TMPart("600-211-1340", 1),
                new TMPart("SYZZ-10W30DM-Y", 55+100),
                new TMPart("GLI", 5),
                new TMPart("600-311-7152", 1),
                new TMPart("07063-01100", 2),
                new TMPart("07000-52130", 2),
                new TMPart("600-411-1581", 1),
                new TMPart("600-411-1561", 1),
                new TMPart("20Y-60-21470 ", 1)
                };
        tm_1000.setPartList(patList3);
        this.getTmList().add(tm_1000);

        TM tm_2000 = new TM(2000);
        TMPart[] patList4 = {new TMPart("600-211-1340", 1),
                new TMPart("SYZZ-10W30DM-Y", 55+100+30),
                new TMPart("GLI", 5),
                new TMPart("600-311-7152", 1),
                new TMPart("07063-01100", 2),
                new TMPart("07000-52130", 2),
                new TMPart("600-411-1581", 1),
                new TMPart("600-411-1561", 1),
                new TMPart("20Y-60-21470", 1),
                new TMPart("07000-55195", 1),
                new TMPart("600-185-6100", 1),
                new TMPart("207-60-71181", 1),
                new TMPart("HO45", 130),
                new TMPart("антифриз", 130),
                new TMPart("20Y-979-3380", 1),
                new TMPart("17М-911-3530", 2),
        };
        tm_2000.setPartList(patList4);
        this.getTmList().add(tm_2000);
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





