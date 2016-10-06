package testing.data.cache;

import java.util.List;

import rx.Observable;
import testing.data.entity.UserEntity;

/**
 * Created by Uri Abad on 06/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public interface UserCache {

    Observable<List<UserEntity>> get();
    Observable<UserEntity> get(final int userId);

    void save(List<UserEntity> userEntities);
    void save(UserEntity userEntity);

    boolean isCached();

    boolean isExpired();
}
