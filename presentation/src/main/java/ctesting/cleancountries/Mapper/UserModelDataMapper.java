package ctesting.cleancountries.Mapper;

import com.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import ctesting.cleancountries.Model.UserModel;
import ctesting.cleancountries.internal.di.PerActivity;

/**
 * Created by Uri Abad on 29/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@PerActivity
public class UserModelDataMapper {

    @Inject
    public UserModelDataMapper() {

    }

    public UserModel transform(User user){
        if(user == null){
            throw new IllegalArgumentException();
        }
        UserModel userModel = new UserModel();
        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());
        userModel.setId(user.getId());
        userModel.setPhone(user.getPhone());
        userModel.setUsername(user.getUsername());
        userModel.setWebsite(user.getWebsite());
        return userModel;
    }

    public Collection<UserModel> transform(Collection<User> userCollection){
        Collection<UserModel> userModelCollection;
        if(userCollection != null && !userCollection.isEmpty()){
            userModelCollection = new ArrayList<>();
            for(User user:userCollection){
                userModelCollection.add(transform(user));
            }
        }else{
            userModelCollection = Collections.emptyList();
        }

        return userModelCollection;
    }
}
