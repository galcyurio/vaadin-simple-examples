package com.github.galcyurio.ui

import com.jarektoro.responsivelayout.ResponsiveColumn
import com.jarektoro.responsivelayout.ResponsiveLayout
import com.jarektoro.responsivelayout.ResponsiveRow
import com.vaadin.ui.Component

/**
 * Add 1 Component
 */
fun ResponsiveLayout.addColumn(component: Component): ResponsiveLayout {
    addRow().addColumn().apply {
        addRule(ResponsiveLayout.DisplaySize.LG, 12)
        withComponent(component)
    }
    return this
}

/**
 * Add 1 ResponsiveRow
 */
fun ResponsiveLayout.withRow(function: ResponsiveRow.() -> Unit): ResponsiveLayout {
    function(addRow())
    return this
}

/**
 * Add 1 ResponsiveColumn
 */
fun ResponsiveRow.withColumn(function: ResponsiveColumn.() -> Unit): ResponsiveRow {
    function(addColumn())
    return this
}
