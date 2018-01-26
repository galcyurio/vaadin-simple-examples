package com.github.galcyurio.support

import com.vaadin.ui.AbstractComponent

fun <T : AbstractComponent> T.withStyleName(style: String): T =
    apply { addStyleName(style) }
