package testing.data.net;

import retrofit2.http.GET;
import rx.Observable;
import testing.data.entity.ListingEntity;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public interface RedditService {

    @GET("r/programming/new")
    Observable<ListingEntity> getPostsNew();

    @GET("r/programming/top")
    Observable<ListingEntity> getPostsTop();

    @GET("r/programming/hot")
    Observable<ListingEntity> getPostsHot();

    @GET("r/programming/controversial")
    Observable<ListingEntity> getPostsControversial();

}
