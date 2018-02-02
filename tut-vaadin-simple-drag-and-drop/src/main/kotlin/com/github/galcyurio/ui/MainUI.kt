package com.github.galcyurio.ui

import com.vaadin.server.VaadinRequest
import com.vaadin.shared.ui.dnd.DropEffect
import com.vaadin.shared.ui.dnd.EffectAllowed
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.dnd.DragSourceExtension
import com.vaadin.ui.dnd.DropTargetExtension
import com.vaadin.ui.themes.ValoTheme
import org.vaadin.viritin.layouts.MVerticalLayout

/**
 * @author galcyurio
 */
@SpringUI
class MainUI : UI() {
    override fun init(p0: VaadinRequest?) {
        content = MVerticalLayout().apply {
            val label = Label("You can grab and drag me")

            val dropTargetLayout = VerticalLayout().apply {
                caption = "Drop things inside me"
                addStyleName(ValoTheme.LAYOUT_CARD)
            }
            add(label, dropTargetLayout)

            DragSourceExtension<Label>(label).apply {
                effectAllowed = EffectAllowed.MOVE
            }

            DropTargetExtension(dropTargetLayout).apply {
                // the drop effect must match the allowed effect in the drag source for a successful drop
                dropEffect = DropEffect.MOVE

                // catch the drops
                addDropListener { event ->
                    val dragSource = event.dragSourceComponent
                    dropTargetLayout.addComponent(dragSource.get())
                }
            }
        }


    }
}