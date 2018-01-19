package com.github.galcyurio.mvp.ui.login;

import com.github.galcyurio.mvp.support.Events;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.events.EventBus;

import javax.annotation.PostConstruct;

/**
 * @author galcyurio
 */
@UIScope
@SpringView(name = LoginScreen.VIEW_NAME, ui = LoginScreen.LoginUI.class)
public class LoginScreen extends VerticalLayout implements View {
    public static final String VIEW_NAME = "login";
    private final EventBus.UIEventBus mEventBus;
    private final LoginPresenter mPresenter;

    private final Label mLabelWelcome = new Label("Welcome to Login View!");
    private final Layout mFieldsLayout = new VerticalLayout();

    @Autowired
    public LoginScreen(EventBus.UIEventBus eventBus, LoginPresenter presenter) {
        mEventBus = eventBus;
        mPresenter = presenter;
    }

    @PostConstruct
    void init() {
        mFieldsLayout.addComponents(
                new Button("Home", click -> mEventBus.publish(this, new Events.HomeButtonClickEvent())),
                new TextField("email"),
                new PasswordField("password"),
                new Button("Login", click -> mEventBus.publish(this, new Events.LoginButtonClickEvent()))
        );

        addComponents(mLabelWelcome, mFieldsLayout);
    }

    public void showHomeScreen() {
        getUI().getPage().setLocation("/");
    }

    @SpringUI(path = "/login")
    static class LoginUI extends UI {
        private final LoginScreen mLoginScreen;

        LoginUI(LoginScreen loginScreen) {
            mLoginScreen = loginScreen;
        }

        @Override
        protected void init(VaadinRequest request) {
            setContent(mLoginScreen);
        }
    }

}
