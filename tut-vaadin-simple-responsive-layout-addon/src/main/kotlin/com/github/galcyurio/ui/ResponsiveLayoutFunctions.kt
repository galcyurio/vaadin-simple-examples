package com.github.galcyurio.ui

import com.jarektoro.responsivelayout.ResponsiveLayout
import com.vaadin.ui.Component

fun ResponsiveLayout.addColumn(component: Component): ResponsiveLayout {
    addRow().addColumn().apply {
        addRule(ResponsiveLayout.DisplaySize.LG, 12)
        withComponent(component)
    }
    return this
}