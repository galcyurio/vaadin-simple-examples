package com.github.galcyurio.ui

import com.vaadin.server.Page
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Button
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout


/**
 * @author galcyurio
 */
@SpringUI
class MainUI : UI() {
    override fun init(request: VaadinRequest?) {
        val button = Button("Dummy Button")
        button.addStyleName("yellow")
        Page.getCurrent().styles.add(".yellow { background: yellow !important; } ")

        content = VerticalLayout(button)
    }

}