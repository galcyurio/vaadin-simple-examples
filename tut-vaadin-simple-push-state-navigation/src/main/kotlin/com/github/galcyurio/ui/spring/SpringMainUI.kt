package com.github.galcyurio.ui.spring

import com.vaadin.navigator.PushStateNavigation
import com.vaadin.navigator.View
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.spring.annotation.SpringView
import com.vaadin.spring.navigator.SpringNavigator
import com.vaadin.ui.*

/**
 * @author galcyurio
 */
@PushStateNavigation
@SpringUI(path = "spring")
class SpringMainUI(
    val mNavigator: SpringNavigator
) : UI() {

    override fun init(request: VaadinRequest?) {
        val container = CssLayout()
        mNavigator.init(this, container)

        content = VerticalLayout().apply {
            addComponent(HorizontalLayout().apply {
                addComponent(Button("Spring Home", Button.ClickListener { mNavigator.navigateTo(SpringHomeScreen::class.java) }))
                addComponent(Button("Spring Foo", Button.ClickListener { mNavigator.navigateTo(SpringFooScreen::class.java) }))
                addComponent(Button("Spring Bar", Button.ClickListener { mNavigator.navigateTo(SpringBarScreen::class.java) }))
            })
            addComponent(Label("Try refresh (F5)"))
            addComponent(container)
        }
    }

    fun SpringNavigator.navigateTo(viewClass: Class<out View>) {
        val viewName = viewClass.getAnnotation(SpringView::class.java).name
        this.navigateTo(viewName)
    }
}