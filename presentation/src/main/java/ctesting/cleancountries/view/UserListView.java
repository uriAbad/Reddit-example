package ctesting.cleancountries.view;

import java.util.Collection;

import ctesting.cleancountries.Model.UserModel;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public interface UserListView extends LoadDataView {

    void renderUserList(Collection<UserModel> userModelCollection);
}
