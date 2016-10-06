package testing.data.repository.datasource;

import javax.inject.Inject;
import javax.inject.Singleton;

import testing.data.cache.UserCache;
import testing.data.net.UserService;

/**
 * Created by Uri Abad on 04/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Singleton
public class UserDataStoreFactory {

    private final UserCache userCache;
    private final UserService userService;

    @Inject
    public UserDataStoreFactory(UserCache userCache, UserService userService) {
        this.userCache = userCache;
        this.userService = userService;
    }

    //TODO:IMPROVE CREATION
    public UserDataStore create(){
        if(userCache.isCached()){
            return createCloudDiskDataStore();
        }else{
            return createDiskUserDataStore();
        }
    }

    private UserDataStore createDiskUserDataStore() {
        return new DiskUserDataStore(userCache);
    }

    private UserDataStore createCloudDiskDataStore() {
        return new CloudUserDataStore(userService);
    }
}
