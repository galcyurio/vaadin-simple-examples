package com.github.galcyurio.ui

import com.vaadin.navigator.View
import com.vaadin.ui.Button
import com.vaadin.ui.VerticalLayout

/**
 * @author galcyurio
 */
class HomeScreen : VerticalLayout(), View {

    companion object {
        const val VIEW_NAME = ""
    }

    init {
        addComponent(Button("Home"))
    }
}