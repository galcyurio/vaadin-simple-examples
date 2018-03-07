package com.github.galcyurio.ui.spring

import com.vaadin.navigator.View
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.Button
import com.vaadin.ui.VerticalLayout

/**
 * @author galcyurio
 */
@SpringView(name = "foo")
class SpringFooScreen : VerticalLayout(), View {

    init {
        this.addComponent(Button("Spring Foo"))
    }
}