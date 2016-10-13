package testing.data.repository.datasource;

import java.util.List;

import rx.Observable;
import testing.data.cache.PostCache;
import testing.data.entity.PostEntity;
import testing.data.entity.PostType;

/**
 * Created by Uri Abad on 13/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class DiskPostDataStore implements PostDataStore {

    private final PostCache postCache;

    public DiskPostDataStore(PostCache postCache) {this.postCache = postCache;}

    @Override
    public Observable<List<PostEntity>> posts() {
        System.out.println("RETRIEVED FROM DISK");

        return postCache.get(PostType.NEW);
    }

    @Override
    public Observable<List<PostEntity>> postsHot() {
        System.out.println("RETRIEVED FROM DISK");
        return postCache.get(PostType.HOT);
    }

    @Override
    public Observable<List<PostEntity>> postsControversial() {
        System.out.println("RETRIEVED FROM DISK");
        return postCache.get(PostType.CONTROVERSIAL);
    }
}
