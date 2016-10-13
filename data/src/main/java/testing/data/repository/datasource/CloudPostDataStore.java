package testing.data.repository.datasource;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import testing.data.cache.PostCache;
import testing.data.entity.PostEntity;
import testing.data.entity.PostType;
import testing.data.net.RedditService;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
public class CloudPostDataStore implements PostDataStore{

    private final RedditService redditService;
    private final PostCache postCache;

    private final Action1<List<PostEntity>> saveToCacheAction = postEntities -> {
        if(postEntities!= null && postEntities.size()>0){
            CloudPostDataStore.this.postCache.put(postEntities);
        }
    };

    public CloudPostDataStore(RedditService redditService, PostCache postCache) {
        this.redditService = redditService;
        this.postCache = postCache;
    }

    @Override
    public Observable<List<PostEntity>> posts() {
        return this.redditService.getPostsNew()
                .map(listingEntity -> listingEntity.parseList(PostType.NEW))
                .doOnNext(saveToCacheAction);
    }

    @Override
    public Observable<List<PostEntity>> postsHot() {
        return this.redditService.getPostsHot()
                .map(listingEntity -> listingEntity.parseList(PostType.HOT))
                .doOnNext(saveToCacheAction);
    }

    @Override
    public Observable<List<PostEntity>> postsControversial() {
        return this.redditService.getPostsControversial()
                .map(listingEntity -> listingEntity.parseList(PostType.CONTROVERSIAL))
                .doOnNext(saveToCacheAction);
    }

}
