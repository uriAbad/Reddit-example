package testing.data.net;

import retrofit2.http.GET;
import rx.Observable;
import testing.data.entity.UserEntity;


/**
 * Created by Uri Abad on 22/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public interface RestCountriesApi {

    //TODO: IMPLELEMENT TRY CATCH IN IMPLEMENTATION

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

//    class Creator {
//        public static RestCountriesApi restCountriesApiImpl2(Context context) {
//
//            OkHttpClient client = new OkHttpClient.Builder()
//                    .connectTimeout(15, TimeUnit.SECONDS)
//                    .readTimeout(15,TimeUnit.SECONDS)
//                    .addNetworkInterceptor(new StethoInterceptor())
//                    .build();
//
//            Gson gson = new GsonBuilder()
//                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//                    .create();
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .client(client)
//                    .build();
//
//            return retrofit.create(RestCountriesApi.class);
//        }
//    }

    @GET("users")
    Observable<UserEntity> getUsers();
}
