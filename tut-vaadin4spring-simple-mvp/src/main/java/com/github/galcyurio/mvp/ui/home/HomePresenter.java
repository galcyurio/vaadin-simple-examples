package com.github.galcyurio.mvp.ui.home;

import com.github.galcyurio.mvp.support.Events;

import org.vaadin.spring.events.annotation.EventBusListenerMethod;
import org.vaadin.spring.navigator.Presenter;
import org.vaadin.spring.navigator.annotation.VaadinPresenter;

/**
 * @author galcyurio
 */
@VaadinPresenter(viewName = HomeScreen.VIEW_NAME)
public class HomePresenter extends Presenter<HomeScreen> {

    @EventBusListenerMethod
    public void onShowLoginScreenButtonClickEvent(Events.ShowLoginScreenButtonClickEvent event) {
        getView().showLoginScreen();
    }
}
