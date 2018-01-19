package com.github.galcyurio.mvp.ui.home;

import com.github.galcyurio.mvp.support.Events;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.events.EventBus;

import javax.annotation.PostConstruct;

/**
 * @author galcyurio
 */
@UIScope
@SpringView(name = HomeScreen.VIEW_NAME, ui = HomeScreen.HomeUI.class)
public class HomeScreen extends VerticalLayout implements View {
    public static final String VIEW_NAME = "home";
    private final EventBus.UIEventBus mEventBus;
    private final HomePresenter mPresenter;

    private final Label mLabelWelcome = new Label("Welcome to Home View!");
    private final Button mBtnShowLogin = new Button("Show login screen!");

    @Autowired
    public HomeScreen(EventBus.UIEventBus eventBus, HomePresenter presenter) {
        mEventBus = eventBus;
        mPresenter = presenter;
    }

    @PostConstruct
    void init() {
        mBtnShowLogin.addClickListener(click -> {
            System.out.println("ShowLoginScreenButtonClickEvent occurred!");
            mEventBus.publish(this, new Events.ShowLoginScreenButtonClickEvent());
        });
        addComponents(mLabelWelcome, mBtnShowLogin);
    }

    public void showLoginScreen() {
        getUI().getPage().setLocation("/login");
    }

    @SpringUI
    static class HomeUI extends UI {
        private final HomeScreen mHomeScreen;

        HomeUI(HomeScreen homeScreen) {
            mHomeScreen = homeScreen;
        }

        @Override
        protected void init(VaadinRequest request) {
            setContent(mHomeScreen);
        }
    }
}

