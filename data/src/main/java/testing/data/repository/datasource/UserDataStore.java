package testing.data.repository.datasource;

import java.util.List;

import rx.Observable;
import testing.data.entity.UserEntity;

/**
 * Created by Uri Abad on 29/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public interface UserDataStore {

    Observable<List<UserEntity>> userEntityList();

    Observable<UserEntity> userEntityDetails(final int userId);
}
