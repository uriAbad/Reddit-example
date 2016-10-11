package testing.data;

import com.domain.Post;
import com.domain.repository.PostRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import testing.data.entity.mapper.ListingEntityDataMapper;
import testing.data.repository.datasource.PostDataStoreFactory;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
@Singleton
public class PostDataRepository implements PostRepository {

    private final PostDataStoreFactory postDataStoreFactory;
    private final ListingEntityDataMapper listingEntityDataMapper;

    @Inject
    public PostDataRepository(PostDataStoreFactory postDataStoreFactory, ListingEntityDataMapper
            listingEntityDataMapper) {
        this.postDataStoreFactory = postDataStoreFactory;
        this.listingEntityDataMapper = listingEntityDataMapper;
    }

    @Override
    public Observable<List<Post>> posts() {
        return this.postDataStoreFactory.create().posts()
                .map(this.listingEntityDataMapper::transform);
    }

    @Override
    public Observable<List<Post>> postsHot() {
        return this.postDataStoreFactory.create().postsHot()
                .map(this.listingEntityDataMapper::transform);
    }

    @Override
    public Observable<List<Post>> postsControversial() {
        return this.postDataStoreFactory.create().postsControversial()
                .map(this.listingEntityDataMapper::transform);
    }
}
