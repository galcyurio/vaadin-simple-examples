package com.github.galcyurio.ui

import com.github.galcyurio.sidebar.SideBar
import com.vaadin.server.Responsive
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.CssLayout
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.UI
import com.vaadin.ui.themes.ValoTheme

/**
 * @author galcyurio
 */
@SpringUI
class MainUI : UI() {

    override fun init(request: VaadinRequest?) {
        Responsive.makeResponsive(this)
        addStyleName(ValoTheme.UI_WITH_MENU)

        content = HorizontalLayout().apply {
            addComponents(SideBar("Vaadin Menu"), CssLayout())
            setSizeFull()
        }
    }
}