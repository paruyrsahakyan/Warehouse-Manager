package GUI.ToolBar.windowMaintenance.TM;

import GUI.requestWindow.RequestedPart;

import java.util.ArrayList;

public class TM {
    private ArrayList <TMPart> partList;
    private int mh;


    public TM(int mh) {
        this.mh = mh;

    }

    @Override
    public String toString() {
        return Integer.toString(this.getMh())+"mh";
    }

/////////////////GETTERS AND SETTERS///////////////////////////


    public int getMh() {
        return mh;
    }

    public void setMh(int mh) {
        this.mh = mh;
    }

    public ArrayList<TMPart> getPartList() {
        return partList;
    }

    public void setPartList(ArrayList<TMPart> partList) {
        this.partList = partList;
    }

    public void setPartList(TMPart[] tmParts) {
        ArrayList<TMPart> arrayList = new ArrayList<TMPart>();
        for (TMPart tmPart: tmParts) {
            arrayList.add(tmPart);
        }
        this.setPartList(arrayList);
        }

    }

