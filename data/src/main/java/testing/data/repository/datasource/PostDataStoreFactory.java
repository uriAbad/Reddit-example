package testing.data.repository.datasource;

import javax.inject.Inject;
import javax.inject.Singleton;

import testing.data.net.RedditService;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Singleton
public class PostDataStoreFactory {

    private final RedditService redditService;

    @Inject
    public PostDataStoreFactory(RedditService redditService) {
        this.redditService = redditService;
    }

    public PostDataStore create(){
        return createCloudPostDataStore();
    }

    private PostDataStore createCloudPostDataStore() {
        return new CloudPostDataStore(redditService);
    }
}
