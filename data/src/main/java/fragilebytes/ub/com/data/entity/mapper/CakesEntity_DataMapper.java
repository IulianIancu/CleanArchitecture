package fragilebytes.ub.com.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import fragilebytes.ub.com.clean_di_rx_refreshed.business.entity.Cake_model;
import fragilebytes.ub.com.data.entity.CakeEntity_List;

/**
 * Mapper class used to transform {@link CakeEntity_List} (in the data layer) to {@link Cake_model} in the
 * domain layer.
 */
@Singleton
public class CakesEntity_DataMapper {
    @Inject
public CakesEntity_DataMapper(){}

    /**
     * Transform a {@link CakeEntity_List} into an {@link Cake_model}.
     *
     * @param cakeEntity Object to be transformed.
     * @return {@link Cake_model} if valid {@link CakeEntity_List} otherwise null.
     */
    public Cake_model transform(CakeEntity_List cakeEntity) {
        Cake_model cakes_model = null;
        if (cakeEntity != null) {
            cakes_model = new Cake_model();
            cakes_model.setTitle(cakeEntity.getTitle());
            cakes_model.setImage(cakeEntity.getImage());
            cakes_model.setDesc(cakeEntity.getDesc());

        }

        return cakes_model;
    }

    /**
     * Transform a List of {@link CakeEntity_List} into a Collection of {@link Cake_model}.
     *
     * @param userEntityCollection Object Collection to be transformed.
     * @return {@link Cake_model} if valid {@link CakeEntity_List} otherwise null.
     */
    public List<Cake_model> transform(Collection<CakeEntity_List> userEntityCollection) {
        List<Cake_model> cakesList = new ArrayList<>(20);
        Cake_model cakes_model;
        for (CakeEntity_List cakeEntity : userEntityCollection) {
            cakes_model = transform(cakeEntity);
            if (cakes_model != null) {
                cakesList.add(cakes_model);
            }
        }

        return cakesList;
    }
}
