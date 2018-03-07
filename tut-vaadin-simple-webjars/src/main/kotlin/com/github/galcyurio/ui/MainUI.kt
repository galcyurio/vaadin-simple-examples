package com.github.galcyurio.ui

import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.*


/**
 * @author galcyurio
 */
@com.vaadin.annotations.JavaScript(
    "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js",
    "vaadin://js/test.js")
@SpringUI
class MainUI : UI() {
    val textField = TextField()
    val button = Button("javascript alert")

    override fun init(request: VaadinRequest?) {
        content = VerticalLayout().apply {
            addComponents(
                textField,
                button.apply {
                    addClickListener {
                        JavaScript.getCurrent().execute("""alertText("${textField.value}")""")
                    }
                }
            )
        }
    }
}