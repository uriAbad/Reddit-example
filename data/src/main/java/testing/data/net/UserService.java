package testing.data.net;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;
import testing.data.entity.UserEntity;

/**
 * Created by Uri Abad on 06/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public interface UserService {

    @GET("users")
    Observable<List<UserEntity>> getUsers();
}
