package com.github.galcyurio.ui

import com.jarektoro.responsivelayout.ResponsiveLayout
import com.vaadin.server.Sizeable
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Button
import com.vaadin.ui.TextArea
import com.vaadin.ui.UI

/**
 * @author galcyurio
 */
@SpringUI(path = "/full")
class SizeFullUI : UI() {
    override fun init(request: VaadinRequest?) {
        content = ResponsiveLayout().apply {
            setSizeFull()
            setScrollable(true)

            withRow {
                withColumn { withComponent(Button("Button1")) }
                withColumn { withComponent(Button("Button2")) }
            }
            withRow {
                withColumn { withComponent(Button("Button3")) }
                withColumn { withComponent(Button("Button4")) }
            }
            withRow {
                addComponent(TextArea().apply {
                    setHeight(100f, Sizeable.Unit.REM)
                })
            }
            withRow {
                withColumn {
                    withComponent(Button("Footer ".repeat(6))
                        .apply { setWidth("100%") })
                }
            }
        }
    }

}
