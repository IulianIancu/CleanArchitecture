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
package fragilebytes.ub.com.clean_di_rx_refreshed.presenter;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import fragilebytes.ub.com.clean_di_rx_refreshed.business.exception.DefaultErrorBundle;
import fragilebytes.ub.com.clean_di_rx_refreshed.business.exception.ErrorBundle;
import fragilebytes.ub.com.clean_di_rx_refreshed.business.usecase.DefaultSubscriber;
import fragilebytes.ub.com.clean_di_rx_refreshed.business.usecase.UseCase;
import fragilebytes.ub.com.clean_di_rx_refreshed.di.PerActivity;
import fragilebytes.ub.com.clean_di_rx_refreshed.exception.ErrorMessageFactory;
import fragilebytes.ub.com.clean_di_rx_refreshed.mapper.CakeModelDataMapper;
import fragilebytes.ub.com.clean_di_rx_refreshed.model.Cake_model;
import fragilebytes.ub.com.clean_di_rx_refreshed.view.UserListView;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
@PerActivity
public class UserListPresenter implements Presenter {

  private UserListView viewListView;

  private final UseCase getUserListUseCase;
  private final CakeModelDataMapper userModelDataMapper;

  @Inject
  public UserListPresenter(@Named("userList") UseCase getUserListUserCase,
                           CakeModelDataMapper userModelDataMapper) {
    this.getUserListUseCase = getUserListUserCase;
    this.userModelDataMapper = userModelDataMapper;
  }

  public void setView(@NonNull UserListView view) {
    this.viewListView = view;
  }

  @Override
  public void resume() {}

  @Override
  public void pause() {}

  @Override
  public void destroy() {
    this.getUserListUseCase.unsubscribe();
    this.viewListView = null;
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  public void initialize() {
    this.loadUserList();
  }

  /**
   * Loads all users.
   */
  private void loadUserList() {
    this.hideViewRetry();
    this.showViewLoading();
    this.getUserList();
  }

  //public void onUserClicked(Cake_model userModel) {
 //   this.viewListView.viewUser(userModel);
//}

  private void showViewLoading() {
    this.viewListView.showLoading();
  }

  private void hideViewLoading() {
    this.viewListView.hideLoading();
  }

  private void showViewRetry() {
    this.viewListView.showRetry();
  }

  private void hideViewRetry() {
    this.viewListView.hideRetry();
  }

  private void showErrorMessage(ErrorBundle errorBundle) {
    String errorMessage = ErrorMessageFactory.create(this.viewListView.context(),
            errorBundle.getException());
    this.viewListView.showError(errorMessage);
  }

  private void showUsersCollectionInView(Collection<fragilebytes.ub.com.clean_di_rx_refreshed.business.entity.Cake_model> usersCollection) {
    final Collection<Cake_model> userModelsCollection =
        this.userModelDataMapper.transform(usersCollection);
    this.viewListView.renderUserList(userModelsCollection);
  }

  private void getUserList() {
    this.getUserListUseCase.execute(new UserListSubscriber());
  }

  private final class UserListSubscriber extends DefaultSubscriber<List<fragilebytes.ub.com.clean_di_rx_refreshed.business.entity.Cake_model>> {

    @Override
    public void onCompleted() {
      UserListPresenter.this.hideViewLoading();
    }

    @Override
    public void onError(Throwable e) {
      UserListPresenter.this.hideViewLoading();
      UserListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
      UserListPresenter.this.showViewRetry();
    }

    @Override
    public void onNext(List<fragilebytes.ub.com.clean_di_rx_refreshed.business.entity.Cake_model> users) {
      UserListPresenter.this.showUsersCollectionInView(users);
    }
  }
}
