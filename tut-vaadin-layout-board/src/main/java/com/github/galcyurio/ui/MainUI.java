package com.github.galcyurio.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.UI;

/**
 * @author galcyurio
 */
@Theme("mytheme")
@SpringUI
public class MainUI extends UI {

    private final SpringNavigator mSpringNavigator;

    public MainUI(SpringNavigator springNavigator) {
        mSpringNavigator = springNavigator;
        mSpringNavigator.init(this, this);
    }

    @Override
    protected void init(VaadinRequest request) {

    }
}
