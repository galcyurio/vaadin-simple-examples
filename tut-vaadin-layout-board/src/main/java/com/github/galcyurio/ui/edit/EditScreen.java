package com.github.galcyurio.ui.edit;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;

/**
 * @author galcyurio
 */
@SpringView(name = EditScreen.VIEW_NAME)
public class EditScreen extends VerticalLayout implements View {
    public static final String VIEW_NAME = "edit";


}
