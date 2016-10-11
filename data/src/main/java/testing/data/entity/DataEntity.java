package testing.data.entity;

import java.util.ArrayList;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class DataEntity {

    private String modhash;
    private ArrayList<DataChildrenEntity> children;

    public ArrayList<DataChildrenEntity> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<DataChildrenEntity> children) {
        this.children = children;
    }

    public String getModhash() {
        return modhash;
    }

    public void setModhash(String modhash) {
        this.modhash = modhash;
    }
}
