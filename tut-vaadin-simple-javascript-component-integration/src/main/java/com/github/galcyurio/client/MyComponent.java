package com.github.galcyurio.client;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JavaScript({"mylibrary.js", "mycomponent-connector.js"})
public class MyComponent extends AbstractJavaScriptComponent {

    public MyComponent() {
        addFunction("onClick", arguments -> {
            getState().value = arguments.getString(0);
            for (ValueChangeListener listener : listeners) {
                listener.valueChange();
            }
        });
    }

    public interface ValueChangeListener extends Serializable {
        void valueChange();
    }

    List<ValueChangeListener> listeners = new ArrayList<>();

    public void addValueChangeListener(ValueChangeListener listener) {
        listeners.add(listener);
    }

    public void setValue(String value) {
        getState().value = value;
    }

    public String getValue() {
        return getState().value;
    }

    @Override
    protected MyComponentState getState() {
        return (MyComponentState) super.getState();
    }
}