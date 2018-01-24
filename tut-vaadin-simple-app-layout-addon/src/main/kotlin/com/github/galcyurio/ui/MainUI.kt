package com.github.galcyurio.ui

import com.github.appreciated.app.layout.behaviour.AppLayoutComponent
import com.github.appreciated.app.layout.behaviour.Behaviour
import com.github.appreciated.app.layout.builder.AppLayout
import com.github.appreciated.app.layout.builder.AppLayoutConfiguration
import com.github.appreciated.app.layout.builder.design.AppBarDesign
import com.github.appreciated.app.layout.builder.elements.builders.SubmenuBuilder
import com.github.appreciated.app.layout.builder.entities.DefaultBadgeHolder
import com.github.appreciated.app.layout.builder.entities.DefaultNotificationHolder
import com.github.appreciated.app.layout.component.MenuHeader
import com.github.appreciated.app.layout.component.button.AppBarNotificationButton
import com.github.appreciated.app.layout.interceptor.DefaultViewNameInterceptor
import com.vaadin.annotations.Theme
import com.vaadin.icons.VaadinIcons
import com.vaadin.navigator.Navigator
import com.vaadin.navigator.View
import com.vaadin.server.ThemeResource
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.*
import com.vaadin.ui.themes.ValoTheme


/**
 * @author galcyurio
 */
@Theme("mytheme")
@SpringUI
class MainUI : UI() {
    override fun init(request: VaadinRequest?) {
        content = sample()
    }

    fun sample(): AppLayoutComponent {
        return AppLayout.getDefaultBuilder(Behaviour.LEFT_RESPONSIVE_HYBRID)
            .withNavigator { container -> Navigator(this, container) }
            .withTitle("App Layout Basic Example")
            .addToAppBar(AppBarNotificationButton(DefaultNotificationHolder(), true))
            .withViewNameInterceptor(DefaultViewNameInterceptor())
            .withDefaultNavigationView(DummyView::class.java)
            .withDesign(AppBarDesign.MATERIAL)
            .add(MenuHeader("Version 0.9.20", ThemeResource("logo.png")), AppLayoutConfiguration.Position.HEADER)
            .add("Home", VaadinIcons.HOME, DefaultBadgeHolder(3), DummyView::class.java)
            .add(SubmenuBuilder.get("My Submenu", VaadinIcons.PLUS)
                .add("Charts", "test", VaadinIcons.SPLINE_CHART, DummyView::class.java)
                .add("Contact", VaadinIcons.CONNECT, DummyView::class.java)
                .add("More", VaadinIcons.COG, DummyView::class.java)
                .build())
            .add("Menu", VaadinIcons.MENU, DummyView::class.java)
            .add("Elements", VaadinIcons.LIST, DummyView::class.java)
            .build()
    }

    class DummyView : VerticalLayout(), View {
        init {
            val layout = HorizontalLayout()
            layout.setSizeFull()
            val label = Label("< " + javaClass.name + " >")
            label.addStyleNames(ValoTheme.LABEL_H2, ValoTheme.LABEL_NO_MARGIN)
            layout.addComponent(label)
            layout.setComponentAlignment(label, Alignment.MIDDLE_CENTER)
            val panel = Panel(layout)
            panel.setSizeFull()
            addComponent(panel)
            setMargin(true)
            setSizeFull()
        }
    }
}