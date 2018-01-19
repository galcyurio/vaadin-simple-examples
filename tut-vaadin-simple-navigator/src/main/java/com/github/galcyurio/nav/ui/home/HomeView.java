package com.github.galcyurio.nav.ui.home;

import com.github.galcyurio.nav.ui.start.StartView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import org.springframework.util.StringUtils;

/**
 * @author galcyurio
 */
public class HomeView extends HorizontalLayout implements View {

    public static final String VIEW_NAME = "home";
    private VerticalLayout left, right;

    {
        left = new VerticalLayout();
        right = new VerticalLayout();
        addComponents(left, right);
    }

    public HomeView() {
        left.addComponents(
                new Button("Pig", event -> navigateTo(VIEW_NAME + "/" + "pig")),
                new Button("Cat", event -> navigateTo(VIEW_NAME + "/" + "cat")),
                new Button("Dog", event -> navigateTo(VIEW_NAME + "/" + "dog")),
                new Button("Reindeer", event -> navigateTo(VIEW_NAME + "/" + "reindeer")),
                new Button("Penguin", event -> navigateTo(VIEW_NAME + "/" + "penguin")),
                new Button("Sheep", event -> navigateTo(VIEW_NAME + "/" + "sheep")),

                new Button("Logout", event -> navigateTo(StartView.VIEW_NAME))
        );
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        String parameters = event.getParameters();
        System.out.println(parameters);

        if (StringUtils.isEmpty(parameters)) {
            right.addComponent(new Label("Nothing to see here, just pass along."));
        } else {
            right.addComponent(new Button("Go to Start View", click -> navigateTo(StartView.VIEW_NAME)));
        }
    }

    private void navigateTo(String viewName) {
        getUI().getNavigator().navigateTo(viewName);
    }
}
