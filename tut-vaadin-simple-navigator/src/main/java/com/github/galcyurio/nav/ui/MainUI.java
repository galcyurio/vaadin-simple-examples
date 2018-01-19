package com.github.galcyurio.nav.ui;

import com.github.galcyurio.nav.ui.home.HomeView;
import com.github.galcyurio.nav.ui.start.StartView;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

/**
 * @author galcyurio
 */
@SpringUI
public class MainUI extends UI {
    Navigator navigator;

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");

        // Create a navigator to control the views
        navigator = new Navigator(this, this);

        // Create and register the views
        navigator.addView(StartView.VIEW_NAME, new StartView());
        navigator.addView(HomeView.VIEW_NAME, new HomeView());
    }


}
