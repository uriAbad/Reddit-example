package testing.data.repository.datasource;

import java.util.List;

import rx.Observable;
import testing.data.entity.PostEntity;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
public interface PostDataStore {

    Observable<List<PostEntity>> posts();
}
