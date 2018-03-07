package com.github.galcyurio.ui

import com.github.appreciated.material.MaterialTheme
import com.github.galcyurio.support.withComponents
import com.github.galcyurio.support.withMaterialCard5
import com.github.galcyurio.support.withMaterialFlat
import com.github.galcyurio.support.withStyleName
import com.vaadin.annotations.Theme
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.*


/**
 * @author galcyurio
 */
@Theme("mytheme")
@SpringUI
class MainUI : UI() {
    override fun init(request: VaadinRequest?) {
        content = VerticalLayout().withComponents(
            Button("Click Me")
                .withMaterialFlat()
                .withStyleName(MaterialTheme.BUTTON_DANGER),

            HorizontalLayout(Button("TEST"), Button("TEST2"),
                Label("TEST3").apply { withStyleName(MaterialTheme.CARD_5) })
                .withMaterialCard5()
        )
    }
}