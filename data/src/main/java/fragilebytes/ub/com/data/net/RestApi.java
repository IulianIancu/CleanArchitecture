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
package fragilebytes.ub.com.data.net;

import java.util.List;

import fragilebytes.ub.com.data.entity.CakeEntity_List;
import rx.Observable;

/**
 * RestApi for retrieving data from the network.
 */
public interface RestApi {
  String API_BASE_URL = "https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/";

  /** Api url for getting all users */
  String API_URL_GET_USER_LIST = API_BASE_URL + "cake.json";
  /** Api url for getting a user profile: Remember to concatenate id + 'json' */
 // String API_URL_GET_USER_DETAILS = API_BASE_URL + "user_";

  /**
   * Retrieves an {@link Observable} which will emit a List of {@link CakeEntity_List}.
   */
  Observable<List<CakeEntity_List>> userEntityList();

  /**
   * Retrieves an {@link Observable} which will emit a {@link CakeEntity_List}.
   *
   * @param userId The user id used to get user data.
   */
  //Observable<CakeEntity_List> userEntityById(final int userId);
}
