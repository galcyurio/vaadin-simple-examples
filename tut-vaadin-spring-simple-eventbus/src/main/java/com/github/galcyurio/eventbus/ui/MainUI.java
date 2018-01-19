package com.github.galcyurio.eventbus.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.EventBusListener;

import javax.annotation.PreDestroy;

/**
 * @author galcyurio
 */
@SpringUI
public class MainUI extends UI implements EventBusListener<Object> {

    private final EventBus.UIEventBus mUIEventBus;
    private final ApplicationContext mApplicationContext;

    private VerticalLayout mRootLayout;

    @Autowired
    public MainUI(EventBus.UIEventBus uiEventBus, ApplicationContext applicationContext) {
        mUIEventBus = uiEventBus;
        mApplicationContext = applicationContext;
    }

    @Override
    protected void init(VaadinRequest request) {
        mUIEventBus.subscribe(this);

        mRootLayout = new VerticalLayout(
                new Button("Publish UI Event",
                        event -> mUIEventBus.publish(this, "Hello World from UI"))
        );
        setContent(mRootLayout);
    }

    @Override
    public void onEvent(final org.vaadin.spring.events.Event<Object> event) {
        mRootLayout.addComponent(new Label(event.toString()));
        System.out.println(event.toString());
    }

    @PreDestroy
    void destroy() {
        // It's good manners to do this,
        // even though we should be automatically unsubscribed when the UI is garbage collected
        mUIEventBus.unsubscribe(this);
    }
}
