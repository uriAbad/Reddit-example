package testing.data.cache;

import java.util.List;

import rx.Observable;
import testing.data.entity.PostEntity;
import testing.data.entity.PostType;

/**
 * Created by Uri Abad on 13/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public interface PostCache {

    Observable<List<PostEntity>> get(PostType postType);

    void put(List<PostEntity> postEntity);

    boolean isCached(PostType postType);

    boolean isExpired(PostType postType);

    void evict();
}
