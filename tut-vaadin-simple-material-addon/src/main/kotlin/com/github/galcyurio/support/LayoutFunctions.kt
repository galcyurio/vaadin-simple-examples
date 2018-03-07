package com.github.galcyurio.support

import com.vaadin.ui.AbstractLayout
import com.vaadin.ui.Component

fun AbstractLayout.withComponents(vararg components: Component): AbstractLayout =
    apply { addComponents(*components) }