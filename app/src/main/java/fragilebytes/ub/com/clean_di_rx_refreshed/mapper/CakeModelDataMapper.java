/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fragilebytes.ub.com.clean_di_rx_refreshed.mapper;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import fragilebytes.ub.com.clean_di_rx_refreshed.di.PerActivity;
import fragilebytes.ub.com.clean_di_rx_refreshed.model.Cake_model;

/**
 * Mapper class used to transform {@link fragilebytes.ub.com.clean_di_rx_refreshed.business.entity.Cake_model} (in the domain layer) to {@link Cake_model} in the
 * presentation layer.
 */
@PerActivity
public class CakeModelDataMapper {

  @Inject
  public CakeModelDataMapper() {}

  /**
   * Transform a {@link fragilebytes.ub.com.clean_di_rx_refreshed.business.entity.Cake_model} into an {@link Cake_model}.
   *
   *
   * @param user Object to be transformed.
   * @return {@link Cake_model}.
   */
  public Cake_model transform(fragilebytes.ub.com.clean_di_rx_refreshed.business.entity.Cake_model user) {
    if (user == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    Cake_model userModel = new Cake_model();
    userModel.setTitle(user.getTitle());
    userModel.setImage(user.getImage());



    return userModel;
  }

  /**
   * Transform a Collection of {@link fragilebytes.ub.com.clean_di_rx_refreshed.business.entity.Cake_model} into a Collection of {@link Cake_model}.
   *
   * @param usersCollection Objects to be transformed.
   * @return List of {@link Cake_model}.
   */
  public Collection<Cake_model> transform(Collection<fragilebytes.ub.com.clean_di_rx_refreshed.business.entity.Cake_model> usersCollection) {
    Collection<Cake_model> userModelsCollection;

    if (usersCollection != null && !usersCollection.isEmpty()) {
      userModelsCollection = new ArrayList<>();
      for (fragilebytes.ub.com.clean_di_rx_refreshed.business.entity.Cake_model user : usersCollection) {
        userModelsCollection.add(transform(user));
      }
    } else {
      userModelsCollection = Collections.emptyList();
    }

    return userModelsCollection;
  }
}
