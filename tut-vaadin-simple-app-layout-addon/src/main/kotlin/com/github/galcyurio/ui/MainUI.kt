package com.github.galcyurio.ui

import com.github.appreciated.app.layout.behaviour.AppLayout
import com.github.appreciated.app.layout.behaviour.Behaviour
import com.github.appreciated.app.layout.builder.AppLayoutBuilder
import com.github.appreciated.app.layout.builder.design.AppBarDesign
import com.github.appreciated.app.layout.builder.elements.SubmenuBuilder
import com.github.appreciated.app.layout.builder.entities.DefaultBadgeHolder
import com.github.appreciated.app.layout.component.MenuHeader
import com.vaadin.annotations.Theme
import com.vaadin.icons.VaadinIcons
import com.vaadin.navigator.View
import com.vaadin.server.ThemeResource
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Button
import com.vaadin.ui.Notification
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout


/**
 * @author galcyurio
 */
@Theme("mytheme")
@SpringUI
class MainUI : UI() {
    override fun init(request: VaadinRequest?) {
        content = sample()
    }

    fun sample(): AppLayout {
        return AppLayoutBuilder.get(Behaviour.LEFT_RESPONSIVE_OVERLAY_NO_APP_BAR)
            .withTitle("Appbar Demo")
            .withDefaultNavigationView(DummyView::class.java)
            .withDesign(AppBarDesign.DEFAULT)
            .add(MenuHeader("App-Layout", "0.9.19", ThemeResource("logo.png")), AppLayoutBuilder.Position.HEADER)
            .add("Home", VaadinIcons.HOME, DefaultBadgeHolder().apply { increase() }, DummyView::class.java)
            .add("Charts", VaadinIcons.SPLINE_CHART, DummyView::class.java)
            .add(SubmenuBuilder.get("Submenu", VaadinIcons.FILE_TREE)
                .add("We are", VaadinIcons.CONNECT, DummyView::class.java)
                .add("Submenu", VaadinIcons.PLUS, DummyView::class.java)
                .add("Elements", VaadinIcons.MENU, DummyView::class.java)
                .build())
            .addClickable("Click Me", VaadinIcons.QUESTION, Button.ClickListener { Notification.show("Clicked!") })
            .add("Preferences", VaadinIcons.COG, DummyView::class.java, AppLayoutBuilder.Position.FOOTER)
            .build()
    }

    fun appLayout(): AppLayout {
        return AppLayoutBuilder.get(Behaviour.LEFT_RESPONSIVE_OVERLAY_NO_APP_BAR)
            .withTitle("Title")
            .withDefaultNavigationView(DummyView::class.java)
            .withDesign(AppBarDesign.MATERIAL)

            .add(MenuHeader("App-Layout", "0.9.19", ThemeResource("../valo/favicon.ico")), AppLayoutBuilder.Position.HEADER)
            .addClickable("clickable", VaadinIcons.VAADIN_V, Button.ClickListener { Notification.show("Clicked!") })

            .build()
    }

    class DummyView : VerticalLayout(), View
}