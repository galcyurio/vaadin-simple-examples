package com.github.galcyurio.ui

import com.vaadin.navigator.Navigator
import com.vaadin.navigator.PushStateNavigation
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.*

/**
 * @author galcyurio
 */
@PushStateNavigation
@SpringUI
class MainUI : UI() {
    override fun init(p0: VaadinRequest?) {
        val container = CssLayout()
        val navigator = Navigator(this, container)
        navigator.addView(HomeScreen.VIEW_NAME, HomeScreen::class.java)
        navigator.addView(FooScreen.VIEW_NAME, FooScreen::class.java)
        navigator.addView(BarScreen.VIEW_NAME, BarScreen::class.java)

        content = VerticalLayout().apply {
            addComponent(HorizontalLayout().apply {
                addComponent(Button("Home", Button.ClickListener { navigator.navigateTo(HomeScreen.VIEW_NAME) }))
                addComponent(Button("Foo", Button.ClickListener { navigator.navigateTo(FooScreen.VIEW_NAME) }))
                addComponent(Button("Bar", Button.ClickListener { navigator.navigateTo(BarScreen.VIEW_NAME) }))
            })
            addComponent(Label("Try refresh (F5)"))
            addComponent(container)
        }
    }
}
