package com.github.galcyurio.nav.ui.start;


import com.github.galcyurio.nav.ui.home.HomeView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * @author galcyurio
 */
public class StartView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";

    public StartView() {
        setSizeFull();

        Button button = new Button("Go to Home View", event ->
                getUI().getNavigator().navigateTo(HomeView.VIEW_NAME));
        addComponent(button);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Welcome to the Animal Farm");
    }
}
