package testing.data.cache;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import testing.data.entity.PostDate;
import testing.data.entity.PostEntity;
import testing.data.entity.PostType;
import testing.data.exception.UserNotFoundException;

/**
 * Created by Uri Abad on 13/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Singleton
public class PostCacheImpl implements PostCache {

    final Realm realm;

    @Inject
    public PostCacheImpl(Realm realm) {this.realm = realm;}


    @Override
    public Observable<List<PostEntity>> get(PostType postType) {
        return realm.where(PostEntity.class)
                .equalTo("postTypeDescription",postType.toString())
                .findAll()
                .asObservable()
                .map(postEntities -> realm.copyToRealm(postEntities))
                .doOnError(throwable -> new UserNotFoundException(throwable))
                .doOnCompleted(realm::close);

    }

    @Override
    public void put(List<PostEntity> postEntity) {
        PostDate date = new PostDate();
        date.setPostType(postEntity.get(0).getPostType());
        date.setExpirationDate(Calendar.getInstance().getTimeInMillis());
        realm.copyToRealm(date);
        realm.copyToRealm(postEntity);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public boolean isExpired(PostType postType) {
        return false;
    }

    @Override
    public boolean isCached(PostType postType) {
        RealmResults<PostEntity> results =
        realm.where(PostEntity.class)
                .equalTo("postTypeDescription",postType.toString())
                .findAll();
        if(results == null || results.size()==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void evict() {

    }
}
