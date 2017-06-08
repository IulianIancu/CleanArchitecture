package fragilebytes.ub.com.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import fragilebytes.ub.com.data.entity.CakeEntity_List;

/**
 * Created by kalpesh on 10/04/2016.
 */
public class CakesEntity_JsonMapper {
    private final Gson gson;

    @Inject
    public CakesEntity_JsonMapper() {
        this.gson = new Gson();
    }

    /**
     * Transform from valid json string to {@link CakeEntity_List}.
     *
     * @param userJsonResponse A json representing a user profile.
     * @return {@link CakeEntity_List}.
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    public CakeEntity_List transformUserEntity(String userJsonResponse) throws JsonSyntaxException {
        try {
            Type userEntityType = new TypeToken<CakeEntity_List>() {}.getType();
            CakeEntity_List userEntity = this.gson.fromJson(userJsonResponse, userEntityType);

            return userEntity;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }

    /**
     * Transform from valid json string to List of {@link CakeEntity_List}.
     *
     * @param userListJsonResponse A json representing a collection of users.
     * @return List of {@link CakeEntity_List}.
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    public List<CakeEntity_List> transformUserEntityCollection(String userListJsonResponse)
            throws JsonSyntaxException {

        List<CakeEntity_List> userEntityCollection;
        try {
            Type listOfUserEntityType = new TypeToken<List<CakeEntity_List>>() {}.getType();
            userEntityCollection = this.gson.fromJson(userListJsonResponse, listOfUserEntityType);

            return userEntityCollection;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }
}
