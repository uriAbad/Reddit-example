package testing.data;

import com.domain.User;
import com.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import testing.data.entity.mapper.UserEntityDataMapper;
import testing.data.repository.datasource.UserDataStoreFactory;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
//TODO:implement
@Singleton
public class UserDataRepository implements UserRepository {

    private final UserDataStoreFactory userDataStoreFactory;
    private final UserEntityDataMapper userEntityDataMapper;

    @Inject
    public UserDataRepository(UserDataStoreFactory userDataStoreFactory, UserEntityDataMapper userEntityDataMapper) {
        this.userDataStoreFactory = userDataStoreFactory;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @Override
    public Observable<List<User>> users() {
        return this.userDataStoreFactory.create().userEntityList()
                .map(this.userEntityDataMapper::transform);

    }

    @Override
    public Observable<User> user(int id) {
        return null;
    }
}
