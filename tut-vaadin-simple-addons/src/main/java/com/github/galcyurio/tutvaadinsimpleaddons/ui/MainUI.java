package com.github.galcyurio.tutvaadinsimpleaddons.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import org.vaadin.teemu.switchui.Switch;

/**
 * @author galcyurio
 */
@SpringUI
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        Switch s = createSwitch("Read-only", null, true);
        s.addValueChangeListener(event -> Notification.show(event.getValue().toString()));

        setContent(new VerticalLayout(s));
    }

    private Switch createSwitch(String caption, String style, boolean initialState) {
        Switch switchComponent = new Switch(caption, initialState);
        if (style != null) {
            switchComponent.setStyleName(style);
        }
        return switchComponent;
    }
}
