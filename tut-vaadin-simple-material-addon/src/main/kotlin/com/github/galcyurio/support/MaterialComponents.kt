package com.github.galcyurio.support

import com.github.appreciated.material.MaterialTheme
import com.vaadin.ui.AbstractLayout
import com.vaadin.ui.Button
import com.vaadin.ui.MenuBar
import com.vaadin.ui.Upload

fun <T : Button> T.withMaterialFlat(): T = withStyleName(MaterialTheme.BUTTON_FLAT)
fun <T : Button> T.withMaterialRound(): T = withStyleName(MaterialTheme.BUTTON_ROUND)
fun <T : Button> T.withMaterialFloatingAction(): T = withStyleName(MaterialTheme.BUTTON_FLOATING_ACTION)
fun <T : Button> T.withMaterialBorder(): T = withStyleName(MaterialTheme.BUTTON_BORDER)
fun <T : Button> T.withMaterialButtonNoBorderRadius(): T = withStyleName(MaterialTheme.BUTTON_NO_BORDER_RADIUS)
fun <T : Button> T.withMaterialCustom(): T = withStyleName(MaterialTheme.BUTTON_CUSTOM)

fun <T : AbstractLayout> T.withMaterialCard0(): T = withStyleName(MaterialTheme.CARD_0)
fun <T : AbstractLayout> T.withMaterialCard0_5(): T = withStyleName(MaterialTheme.CARD_0_5)
fun <T : AbstractLayout> T.withMaterialCard1(): T = withStyleName(MaterialTheme.CARD_1)
fun <T : AbstractLayout> T.withMaterialCard1_5(): T = withStyleName(MaterialTheme.CARD_1_5)
fun <T : AbstractLayout> T.withMaterialCard2(): T = withStyleName(MaterialTheme.CARD_2)
fun <T : AbstractLayout> T.withMaterialCard3(): T = withStyleName(MaterialTheme.CARD_3)
fun <T : AbstractLayout> T.withMaterialCard4(): T = withStyleName(MaterialTheme.CARD_4)
fun <T : AbstractLayout> T.withMaterialCard5(): T = withStyleName(MaterialTheme.CARD_5)
fun <T : AbstractLayout> T.withMaterialCardNoPadding(): T = withStyleName(MaterialTheme.CARD_NO_PADDING)
fun <T : AbstractLayout> T.withMaterialCardHoverable(): T = withStyleName(MaterialTheme.CARD_HOVERABLE)

fun <T : Upload> T.withMaterialRound(): T = withStyleName(MaterialTheme.UPLOAD_ROUND)
fun <T : Upload> T.withMaterialFlat(): T = withStyleName(MaterialTheme.UPLOAD_FLAT)
fun <T : Upload> T.withMaterialFloating_action(): T = withStyleName(MaterialTheme.UPLOAD_FLOATING_ACTION)
fun <T : Upload> T.withMaterialBorder(): T = withStyleName(MaterialTheme.UPLOAD_BORDER)
fun <T : Upload> T.withMaterialBorderless(): T = withStyleName(MaterialTheme.UPLOAD_BORDERLESS)
fun <T : Upload> T.withMaterialInlineIcon(): T = withStyleName(MaterialTheme.UPLOAD_INLINE_ICON)
fun <T : Upload> T.withMaterialCustom(): T = withStyleName(MaterialTheme.UPLOAD_CUSTOM)

fun <T : MenuBar> T.withMaterialMenubarPrimary() : T = withStyleName(MaterialTheme.MENUBAR_PRIMARY)
fun <T : MenuBar> T.withMaterialMenubarCustom() : T = withStyleName(MaterialTheme.MENUBAR_CUSTOM)
