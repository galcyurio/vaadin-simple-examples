package com.github.galcyurio.ui

import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Grid
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import java.util.*

/**
 * @author galcyurio
 */
@SpringUI
class MainUI : UI() {
    override fun init(request: VaadinRequest?) {
        content = VerticalLayout(
            Grid(UUID::class.java).apply {
                addColumn(UUID::toString).caption = "uuid"
                addColumn(UUID::version).caption = "version"
                addColumn(UUID::variant).caption = "variant"

                setItems((1..20).map { UUID.randomUUID() })
                setWidth("100%")
            }
        )
    }
}