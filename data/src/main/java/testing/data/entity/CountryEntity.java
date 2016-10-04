package testing.data.entity;

import io.realm.RealmObject;

/**
 * Created by Uri Abad on 04/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class CountryEntity extends RealmObject  {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
