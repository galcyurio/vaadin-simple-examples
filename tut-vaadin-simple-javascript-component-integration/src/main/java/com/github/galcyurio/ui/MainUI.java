package com.github.galcyurio.ui;

import com.github.galcyurio.client.MyComponent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author galcyurio
 */
@SpringUI
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        setContent(new VerticalLayout() {{
            addComponents(new MyComponent() {{
                setValue("Hello, MyComponent!");
            }});
        }});
    }
}
