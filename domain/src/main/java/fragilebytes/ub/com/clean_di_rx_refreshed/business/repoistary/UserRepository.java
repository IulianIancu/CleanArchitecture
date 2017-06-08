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
package fragilebytes.ub.com.clean_di_rx_refreshed.business.repoistary;


import java.util.List;

import fragilebytes.ub.com.clean_di_rx_refreshed.business.entity.Cake_model;
import rx.Observable;

/**
 * Interface that represents a Repository for getting {@link Cake_model} related data.
 */
public interface UserRepository {
  /**
   * Get an {@link Observable} which will emit a List of {@link Cake_model}.
   */

  Observable<List<Cake_model>> getCakes();

}
