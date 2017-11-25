package GUI.ToolBar.windowMaintenance.machine;

import GUI.ToolBar.windowMaintenance.TM.TM;

import java.util.ArrayList;

public class Machine {
    private String model;
    private ArrayList<TM> tmList;
    Machine() {
        tmList = new ArrayList<TM>();
    }


    /////////////// GETTERS AND SETTERS ///////////////////////////
    public ArrayList<TM> getTmList() {
        return tmList;
    }

    public void setTmList(ArrayList<TM> tmList) {
        this.tmList = tmList;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}

