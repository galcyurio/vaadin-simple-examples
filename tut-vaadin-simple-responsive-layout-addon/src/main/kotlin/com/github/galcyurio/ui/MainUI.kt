package com.github.galcyurio.ui

import com.jarektoro.responsivelayout.ResponsiveLayout
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Button
import com.vaadin.ui.UI

/**
 * @author galcyurio
 */
@SpringUI
class MainUI : UI() {
    override fun init(request: VaadinRequest?) {
        content = ResponsiveLayout()
            .addColumn(row1())
            .addColumn(row2())
            .addColumn(row3())
    }

    /**
     * * 1 column with all __display rules__ and __visibility rules__
     */
    fun row1(): ResponsiveLayout {
        return ResponsiveLayout().apply {
            addRow().apply {
                withMargin(true)

                addColumn()
                    .withDisplayRules(12, 6, 12, 6)
                    .withVisibilityRules(true, true, true, true)
                    .withComponent(Button("Test Button"))
            }
        }
    }

    /**
     * * 1 column with each __rules__
     */
    fun row2(): ResponsiveLayout {
        return ResponsiveLayout().apply {
            addRow().apply {
                addColumn().apply {
                    addRule(ResponsiveLayout.DisplaySize.XS, 12)
                    addRule(ResponsiveLayout.DisplaySize.MD, 6)
                    withComponent(Button("Column1 Button"))
                }

                addColumn().apply {
                    addRule(ResponsiveLayout.DisplaySize.XS, 12)
                    addRule(ResponsiveLayout.DisplaySize.MD, 6)
                    withComponent(Button("Column2 Button"))
                }
            }
        }
    }

    /**
     * * 1 Column can include only 1 Component.
     * * Flexible style
     */
    fun row3(): ResponsiveLayout {
        return ResponsiveLayout().apply {
            withDefaultRules(12, 6, 12, 6)
            withFlexible()

            addRow().apply {
                addColumn()
                    .withComponent(Button("Row1 Column1 111"))
                    .withComponent(Button("Row1 Column1 222"))
                addColumn()
                    .withComponent(Button("Row1 Column2 333"))
                    .withComponent(Button("Row1 Column2 444"))
            }

            addRow().apply {
                addColumn()
                    .withComponent(Button("Row2 Column1 555"))
                    .withComponent(Button("Row2 Column1 666"))
                addColumn()
                    .withComponent(Button("Row2 Column2 777"))
                    .withComponent(Button("Row2 Column2 888"))
            }
        }
    }

}