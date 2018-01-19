package com.github.galcyurio.ui;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author galcyurio
 */
@SpringUI
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        JavaScript.getCurrent().addFunction("com.github.galcyurio.myFunc",
                arguments -> {
                    try {
                        String message = arguments.getString(0);
                        double value = arguments.getNumber(1);
                        Notification.show(String.format(
                                "Message: %s, value: %.0f", message, value
                        ), Notification.Type.TRAY_NOTIFICATION);
                    } catch (Exception e) {
                        Notification.show("Error: " + e.getMessage(), Notification.Type.ERROR_MESSAGE);
                    }
                });

        setContent(new VerticalLayout() {{
            addComponents(
                    new Button("Click for alert!",
                            click -> alert("Hello, javascript!")),
                    new Button("Click for javascript function!",
                            click -> JavaScript.getCurrent().execute("com.github.galcyurio.myFunc()")),
                    new Link("Click for send message",
                            new ExternalResource("javascript:com.github.galcyurio.myFunc(prompt('Message'), 33)"))
            );
        }});
    }

    private void alert(String message) {
        JavaScript.getCurrent().execute(String.format(
                "alert('%s')", message
        ));
    }

}
