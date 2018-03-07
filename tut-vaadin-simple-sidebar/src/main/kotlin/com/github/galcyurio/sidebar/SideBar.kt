package com.github.galcyurio.sidebar

import com.vaadin.icons.VaadinIcons
import com.vaadin.shared.ui.ContentMode
import com.vaadin.ui.*
import com.vaadin.ui.themes.ValoTheme

const val VALO_MENU_ITEMS = "valo-menuitems"
const val VALO_MENU_VISIBLE = "valo-menu-visible"
const val VALO_MENU_TOGGLE = "valo-menu-toggle"
const val VALO_MENU_USER = "user-menu"

private class MenuPart : CssLayout() {
    init {
        primaryStyleName = ValoTheme.MENU_PART
    }
}

private class MenuTitle : HorizontalLayout() {
    init {
        primaryStyleName = ValoTheme.MENU_TITLE
        defaultComponentAlignment = Alignment.MIDDLE_CENTER
    }
}

private class UserMenu : MenuBar() {
    init {
        addStyleName(VALO_MENU_USER)
    }
}

private class MenuItems(
    vararg children: Component
) : CssLayout(*children) {
    init {
        primaryStyleName = VALO_MENU_ITEMS
    }

    fun with(vararg components: Component): MenuItems {
        addComponents(*components)
        return this
    }
}

class SideBar(
    private var title: String = ""
) : CssLayout() {
    private val menuItems: MenuItems = MenuItems()
    lateinit var badgeMenuItem: Button

    init {
        primaryStyleName = ValoTheme.MENU_ROOT

        /* MenuPart */
        MenuPart().apply {
            addComponents(
                /* Title */
                MenuTitle().apply {
                    Label("<h3><strong>$title<strong></h3>", ContentMode.HTML)
                        .apply { setSizeUndefined() }
                        .let { addComponent(it) }
                },

                /* UserMenu */
                UserMenu().apply {
                    addItem("User", VaadinIcons.VAADIN_H, null)
                        .apply { addItem("Edit Profile", { Notification.show("Edit Profile Clicked!") }) }
                        .apply { addItem("Sign Out", { Notification.show("Sign Out Clicked!") }) }
                },

                /* ShowMenu */
                Button("Menu", { _ ->
                    if (styleName.contains(VALO_MENU_VISIBLE)) {
                        removeStyleName(VALO_MENU_VISIBLE)
                    } else {
                        addStyleName(VALO_MENU_VISIBLE)
                    }
                }).apply {
                    addStyleNames(ValoTheme.BUTTON_PRIMARY, ValoTheme.BUTTON_SMALL, VALO_MENU_TOGGLE)
                    icon = VaadinIcons.MENU
                },

                /* MenuItems*/
                menuItems.with(
                    /* SubTitle */
                    Label("Sub Title", ContentMode.HTML).apply {
                        primaryStyleName = ValoTheme.MENU_SUBTITLE
                        addStyleName(ValoTheme.LABEL_H4)
                        setSizeUndefined()
                    },

                    /* Dashboard */
                    Button("Dashboard", VaadinIcons.DASHBOARD)
                        .apply { primaryStyleName = ValoTheme.MENU_ITEM },

                    /* About */
                    Button("About", VaadinIcons.ALT)
                        .apply { primaryStyleName = ValoTheme.MENU_ITEM },

                    Button()
                        .also { badgeMenuItem = it }
                        .apply {
                            primaryStyleName = ValoTheme.MENU_ITEM
                            icon = VaadinIcons.VAADIN_H
                            isCaptionAsHtml = true
                            setBadge("Badge Test")
                        }
                )
            )
        }.let { addComponent(it) }
    }

    fun setBadge(text: String) {
        badgeMenuItem.caption = """Item Caption <span class="${ValoTheme.MENU_BADGE}">$text</span>"""
    }

    fun select(index: Int): Component {
        return menuItems.getComponent(index + 1)
            .apply { addStyleName("selected") }
    }

    fun unselect(index: Int): Component {
        return menuItems.getComponent(index + 1)
            .apply { removeStyleName("selected") }
    }
}
