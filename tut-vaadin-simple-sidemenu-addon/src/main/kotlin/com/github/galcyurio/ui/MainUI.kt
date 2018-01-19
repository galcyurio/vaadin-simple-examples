package com.github.galcyurio.ui

import com.vaadin.icons.VaadinIcons
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Button
import com.vaadin.ui.Notification
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import org.vaadin.teemusa.sidemenu.SideMenu


/**
 * @author galcyurio
 */
@SpringUI
class MainUI : UI() {
    override fun init(request: VaadinRequest?) {
        content = SideMenu().apply {
            setMenuCaption("Menu Caption")

            setUserIcon(VaadinIcons.VAADIN_H)
            setUserName("UserName")
            addUserMenuItem("UserMenuItem Text", VaadinIcons.VAADIN_H, SideMenu.MenuClickHandler {
                Notification.show("UserMenuItem Clicked!")
            })
            // isUserMenuVisible = false

            addMenuItem("MenuItem Text", VaadinIcons.ABACUS, SideMenu.MenuClickHandler {
                Notification.show("MenuItem Clicked!")
            })

            addComponent(VerticalLayout(
                Button("Test")
            ))
        }
    }
}