package testing.data.repository.datasource;

import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import testing.data.cache.PostCache;
import testing.data.entity.PostType;
import testing.data.net.RedditService;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Singleton
public class PostDataStoreFactory {

    private final RedditService redditService;
    private final PostCache postCache;

    @Inject
    public PostDataStoreFactory(@NonNull RedditService redditService,
                                @NonNull PostCache postCache) {
        this.redditService = redditService;
        this.postCache = postCache;
    }

    public PostDataStore create(PostType postType){
        if(this.postCache.isCached(postType)&&!this.postCache.isExpired(postType)) {
            //TODO : CREATE DISK DATA STORE
            return createDiskPostDataStore();
        }else{
            return createCloudPostDataStore();
        }
    }

    private PostDataStore createDiskPostDataStore() {
        return new DiskPostDataStore(postCache);
    }

    private PostDataStore createCloudPostDataStore() {
        return new CloudPostDataStore(redditService, postCache);
    }
}
