package com.github.galcyurio.ui

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
        content = VerticalLayout().apply {
            // context click -> 우클릭
            addComponent(Button("Context Click").apply {
                addContextClickListener { println("Context Click!") }
            })
            addComponent(Button("Layout Click").apply {
                addLayoutClickListener { println("Layout Click!") }
            })
            addComponent(Button("Poll").apply {
                addPollListener { println("Poll!") }
            })
            addComponent(Button("Click").apply {
                addClickListener { println("Click!") }
            })
            addComponent(Button("Focus, Blur").apply {
                addBlurListener { println("Blur!") }
                addFocusListener { println("Focus!") }
            })
        }
    }
}