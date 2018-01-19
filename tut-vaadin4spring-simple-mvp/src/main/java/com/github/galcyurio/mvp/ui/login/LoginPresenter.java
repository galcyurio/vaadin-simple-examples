package com.github.galcyurio.mvp.ui.login;

import com.github.galcyurio.mvp.support.Events;

import org.vaadin.spring.events.annotation.EventBusListenerMethod;
import org.vaadin.spring.navigator.Presenter;
import org.vaadin.spring.navigator.annotation.VaadinPresenter;

/**
 * @author galcyurio
 */
@VaadinPresenter(viewName = LoginScreen.VIEW_NAME)
public class LoginPresenter extends Presenter<LoginScreen> {

    @EventBusListenerMethod
    public void onHomeButtonClickEvent(Events.HomeButtonClickEvent event) {
        getView().showHomeScreen();
    }

    @EventBusListenerMethod
    public void onLoginButtonClickEvent(Events.LoginButtonClickEvent event) {
        System.out.println("LoginPresenter.onLoginButtonClickEvent");
    }
}
