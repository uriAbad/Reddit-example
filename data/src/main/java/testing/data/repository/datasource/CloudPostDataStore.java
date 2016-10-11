package testing.data.repository.datasource;

import java.util.List;

import rx.Observable;
import testing.data.entity.PostEntity;
import testing.data.net.RedditService;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
public class CloudPostDataStore implements PostDataStore{

    private final RedditService redditService;

    public CloudPostDataStore(RedditService redditService) {
        this.redditService = redditService;
    }

    @Override
    public Observable<List<PostEntity>> posts() {
        return this.redditService.getPostsNew()
                .map(listingEntity -> listingEntity.parseList());
    }

}
