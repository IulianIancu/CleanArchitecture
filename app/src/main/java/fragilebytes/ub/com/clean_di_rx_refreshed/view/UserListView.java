/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package fragilebytes.ub.com.clean_di_rx_refreshed.view;


import java.util.Collection;

import fragilebytes.ub.com.clean_di_rx_refreshed.model.Cake_model;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a list of {@link Cake_model}.
 */
public interface UserListView extends LoadDataView {
  /**
   * Render a user list in the UI.
   *
   * @param userModelCollection The collection of {@link Cake_model} that will be shown.
   */
  void renderUserList(Collection<Cake_model> userModelCollection);

  /**
   * View a {@link UserModel} profile/details.
   *
   * @param userModel The user that will be shown.
   */
 // void viewUser(UserModel userModel);
}
