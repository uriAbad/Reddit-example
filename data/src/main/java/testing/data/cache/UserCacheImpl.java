package testing.data.cache;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.Realm;
import rx.Observable;
import testing.data.entity.UserEntity;
import testing.data.exception.UserNotFoundException;

/**
 * Created by Uri Abad on 06/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Singleton
public class UserCacheImpl implements UserCache {

    private final Realm realm;

    @Inject
    public UserCacheImpl(Realm realm) {this.realm = realm;}

    @Override
    public Observable<List<UserEntity>> get() {
        return realm.where(UserEntity.class)
                .findAll()
                .asObservable()
                .doOnError(throwable -> new UserNotFoundException(throwable))
                .map(userEntities -> realm.copyFromRealm(userEntities));

    }

    @Override
    public Observable<UserEntity> get(int userId) {
        return Observable.create(subscriber -> {
            UserEntity userEntity = realm.where(UserEntity.class).findFirst();
            if(userEntity != null){
                subscriber.onNext(userEntity);
                subscriber.onCompleted();
            }else{
                subscriber.onError(new UserNotFoundException());
            }
        });
    }

    @Override
    public void save(List<UserEntity> userEntities) {
        realm.copyToRealm(userEntities);
        realm.commitTransaction();
    }

    @Override
    public void save(UserEntity userEntity) {
        realm.copyToRealm(userEntity);
        realm.commitTransaction();
    }

    //TODO: IMPROVE IN CONJUNCTION WITH EXPIRING METHOD
    @Override
    public boolean isCached() {
        if (realm.where(UserEntity.class).findAll().equals(null)){
            return false;
        }else{
            return true;
        }
    }

    //TODO: IMPLEMENT METHODS TO KNOW EXPIRATION
    @Override
    public boolean isExpired() {
        return false;
    }
}
