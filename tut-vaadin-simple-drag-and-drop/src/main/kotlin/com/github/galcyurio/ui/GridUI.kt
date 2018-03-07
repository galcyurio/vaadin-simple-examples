package com.github.galcyurio.ui

import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Grid
import com.vaadin.ui.UI
import com.vaadin.ui.components.grid.GridRowDragger
import org.vaadin.viritin.layouts.MVerticalLayout
import java.util.*

/**
 * @author galcyurio
 */
@SpringUI(path = "/grid")
class GridUI : UI() {
    override fun init(request: VaadinRequest?) {
        content = MVerticalLayout()
            .add(
                Grid<UUID>().apply {
                    setSizeFull()
                    setItems((1..30).map { UUID.randomUUID() })
                    addColumn(UUID::toString)

                    GridRowDragger<UUID>(this)
                    columns.forEach { it.isSortable = false }
                }
            )
    }
}