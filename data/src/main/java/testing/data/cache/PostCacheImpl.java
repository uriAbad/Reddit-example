package testing.data.cache;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import testing.data.entity.PostEntity;
import testing.data.entity.PostType;
import testing.data.exception.NetworkConnectionException;

/**
 * Created by Uri Abad on 13/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Singleton
public class PostCacheImpl implements PostCache {

    private final static long MILLISECONDS_TO_EXPIRING = 60000;

    final RealmConfiguration realmConfiguration;

    @Inject
    public PostCacheImpl(RealmConfiguration realmConfiguration) {
        this.realmConfiguration = realmConfiguration;
    }
//    final Realm realm;

//    @Inject
//    public PostCacheImpl(Realm realm) {this.realm = realm;}


    @Override
    public Observable<List<PostEntity>> get(PostType postType) {
        Realm realm = Realm.getInstance(realmConfiguration);
        return realm.where(PostEntity.class)
                .equalTo("postTypeDescription",postType.toString())
                .findAll()
                .asObservable()
                .map(postEntities -> realm.copyToRealm(postEntities))
                .first()
                .doOnError(throwable -> new NetworkConnectionException(throwable))
                .doOnCompleted(realm::close)
                .subscribeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public void put(List<PostEntity> postEntity) {
//        PostDate date = new PostDate();
//        date.setPostType(postEntity.get(0).getPostType());
//        date.setExpirationDate(Calendar.getInstance().getTime());
//        realm.copyToRealm(date);
//        realm.copyToRealm(postEntity);
        stampData(postEntity);
        Realm realm = Realm.getInstance(realmConfiguration);
        realm.executeTransaction(realm1 -> {
            realm1.copyToRealm(postEntity);
        });
//        stampData(postEntity);
//        realm.copyToRealm(postEntity);
//        realm.commitTransaction();
        realm.close();
    }

    @Override
    public boolean isExpired(PostType postType) {
        Realm realm = Realm.getInstance(realmConfiguration);
        Date maxiumDateStored = realm.where(PostEntity.class)
                .equalTo("postTypeDescription",postType.toString())
                .maximumDate("dateRetrieved");
        long maximPlusExpiring = maxiumDateStored.getTime()+MILLISECONDS_TO_EXPIRING;
        long actualDate = System.currentTimeMillis();
        if(maximPlusExpiring>actualDate){
            System.out.println("NOT EXPIRED");
            return false;
        }else{
            System.out.println("EXPIRED");
            return true;
        }
    }

    @Override
    public boolean isCached(PostType postType) {
        Realm realm = Realm.getInstance(realmConfiguration);
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

    private void stampData(List<PostEntity> entities){
        final Date stampDate = Calendar.getInstance().getTime();
        for(PostEntity entity : entities){
            entity.setDateRetrieved(stampDate);
        }
    }
}
