package com.github.galcyurio.support

import com.vaadin.ui.Component

fun <T : Component> T.withStyleName(style: String): T =
    apply { addStyleName(style) }
