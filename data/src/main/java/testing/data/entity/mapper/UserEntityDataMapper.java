package testing.data.entity.mapper;

import com.domain.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import testing.data.entity.UserEntity;

/**
 * Created by Uri Abad on 04/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
@Singleton
public class UserEntityDataMapper {

    @Inject
    public UserEntityDataMapper() {
    }

    public List<User> transform(List<UserEntity> userEntities){
        List<User> users = new ArrayList<>();
        User user;
        for(UserEntity userEntity : userEntities){
            user = transform(userEntity);
            if(user != null){
                users.add(user);
            }
        }
        return users;
    }

    public User transform(UserEntity userEntity){
        User user = null;
        if(userEntity != null){
            user = new User();
            user.setId(userEntity.getId());
            user.setName(userEntity.getName());
            user.setWebsite(userEntity.getWebsite());
            user.setEmail(userEntity.getEmail());
            user.setUsername(userEntity.getUsername());
            user.setPhone(userEntity.getPhone());
        }
        return user;
    }
}
