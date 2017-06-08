/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package fragilebytes.ub.com.clean_di_rx_refreshed.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import fragilebytes.ub.com.clean_di_rx_refreshed.R;
import fragilebytes.ub.com.clean_di_rx_refreshed.di.HasComponent;
import fragilebytes.ub.com.clean_di_rx_refreshed.di.components.DaggerUserComponent;
import fragilebytes.ub.com.clean_di_rx_refreshed.di.components.UserComponent;
import fragilebytes.ub.com.clean_di_rx_refreshed.model.Cake_model;
import fragilebytes.ub.com.clean_di_rx_refreshed.view.fragment.UserListFragment;


/**
 * Activity that shows a list of Users.
 */
public class UserListActivity extends BaseActivity implements HasComponent<UserComponent>,
        UserListFragment.UserListListener {

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, UserListActivity.class);
  }

  private UserComponent userComponent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    setContentView(R.layout.activity_layout);

    this.initializeInjector();
    if (savedInstanceState == null) {
      addFragment(R.id.fragmentContainer, new UserListFragment());
    }
  }

  private void initializeInjector() {
    this.userComponent = DaggerUserComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .build();
  }

  @Override
  public UserComponent getComponent() {
    return userComponent;
  }


  @Override
  public void onUserClicked(Cake_model userModel) {

  }
}
