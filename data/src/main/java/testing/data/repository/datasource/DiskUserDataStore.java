package testing.data.repository.datasource;

import java.util.List;

import rx.Observable;
import testing.data.cache.UserCache;
import testing.data.entity.UserEntity;

/**
 * Created by Uri Abad on 06/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class DiskUserDataStore implements UserDataStore {

    private final UserCache userCache;

    public DiskUserDataStore(UserCache userCache) {
        this.userCache = userCache;
    }

    @Override
    public Observable<List<UserEntity>> userEntityList() {
        return this.userCache.get();
    }

    @Override
    public Observable<UserEntity> userEntityDetails(final int userId) {
        return this.userCache.get(userId);
    }
}
