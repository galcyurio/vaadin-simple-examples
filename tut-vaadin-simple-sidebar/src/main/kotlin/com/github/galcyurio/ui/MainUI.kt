package com.github.galcyurio.ui

import com.github.galcyurio.sidebar.SideBar
import com.vaadin.annotations.Theme
import com.vaadin.server.Responsive
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.TextField
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.themes.ValoTheme

/**
 * @author galcyurio
 */
@Theme("mytheme")
@SpringUI
class MainUI : UI() {

    override fun init(request: VaadinRequest?) {
        Responsive.makeResponsive(this)
        addStyleName(ValoTheme.UI_WITH_MENU)

        content = HorizontalLayout().apply {
            val sideBar = SideBar("Vaadin Menu")

            addComponents(
                sideBar,
                VerticalLayout().apply {
                    addComponent(TextField("badge text", { event ->
                        sideBar.setBadge(event.value)
                    }))
                }
            )
            setSizeFull()
        }
    }
}