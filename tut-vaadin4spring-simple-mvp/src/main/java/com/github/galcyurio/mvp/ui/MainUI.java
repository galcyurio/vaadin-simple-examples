
package com.github.galcyurio.mvp.ui;

import com.github.galcyurio.mvp.ui.home.HomePresenter;
import com.github.galcyurio.mvp.ui.login.LoginPresenter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * @author galcyurio
 */
public class MainUI extends UI {

    private final HomePresenter mHomePresenter;
    private final LoginPresenter mLoginPresenter;

    public MainUI(HomePresenter homePresenter, LoginPresenter loginPresenter) {
        mHomePresenter = homePresenter;
        mLoginPresenter = loginPresenter;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        showHomeScreen();
    }

    public void showHomeScreen() {
        getPage().setLocation("/");
    }

    public void showLoginScreen() {
        getPage().setLocation("/login");
    }
}
