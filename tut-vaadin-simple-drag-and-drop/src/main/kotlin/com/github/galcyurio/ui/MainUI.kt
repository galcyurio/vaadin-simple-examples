package com.github.galcyurio.ui

import com.vaadin.server.VaadinRequest
import com.vaadin.shared.ui.dnd.EffectAllowed
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.dnd.DragSourceExtension
import org.vaadin.viritin.layouts.MVerticalLayout


/**
 * @author galcyurio
 */
@SpringUI
class MainUI : UI() {
    override fun init(p0: VaadinRequest?) {
        content = MVerticalLayout().apply {
            val draggableLabel = Label("You can grab and drag me")

            val dragSource = DragSourceExtension(draggableLabel).apply {
                effectAllowed = EffectAllowed.MOVE
                dataTransferText = "hello receiver"

                setDataTransferData("text/html", "<label>hello receiver</label>")
                addDragStartListener { println("START") }
                addDragEndListener {
                    when (it.isCanceled) {
                        true -> println("CANCEL")
                        false -> println("FINISH")
                    }
                }
            }
            add(draggableLabel)
        }
    }
}