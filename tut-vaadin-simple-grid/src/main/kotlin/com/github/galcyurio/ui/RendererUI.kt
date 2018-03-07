package com.github.galcyurio.ui

import com.vaadin.icons.VaadinIcons
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.*
import com.vaadin.ui.renderers.ButtonRenderer
import java.util.*

/**
 * @author galcyurio
 */
@SpringUI(path = "/renderer")
class RendererUI : UI() {
    override fun init(request: VaadinRequest?) {
        content = VerticalLayout().apply {
            setSizeFull()
            val uuidList = (1..30)
                .map { UUID.randomUUID() }
                .toCollection(LinkedList())

            val grid = Grid<UUID>()
                .apply { setSizeFull() }
            grid.setItems(uuidList)

            grid.addColumn(UUID::toString)
                .apply { caption = "UUID" }
                .apply { setStyleGenerator { "v-align-right" } }

            // Render a button that deletes the data row (item)
            grid.addColumn({ "Delete this!" }, ButtonRenderer { event ->
                uuidList.remove(event.item)
                grid.setItems(uuidList)
            }).apply { caption = "Delete" }

            val componentColumn = grid.addComponentColumn {
                VerticalLayout(
                    Button("TEXT", VaadinIcons.VAADIN_H),
                    Label("Test for component renderer"),
                    MenuBar().apply {
                        addItem("ABC", {})
                        addItem("DEF", {})
                        addItem("GHI", {})
                    }
                )
            }

            grid.bodyRowHeight = 200.0

            addComponent(grid)
        }
    }
}