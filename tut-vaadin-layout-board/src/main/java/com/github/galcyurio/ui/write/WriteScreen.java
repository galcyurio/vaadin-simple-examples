package com.github.galcyurio.ui.write;

import com.github.galcyurio.service.BoardService;
import com.github.galcyurio.ui.list.ListScreen;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.VerticalLayout;

import org.vaadin.viritin.button.ConfirmButton;
import org.vaadin.viritin.button.PrimaryButton;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import javax.annotation.PostConstruct;

/**
 * @author galcyurio
 */
@UIScope
@SpringView(name = WriteScreen.VIEW_NAME)
public class WriteScreen extends VerticalLayout implements View {
    public static final String VIEW_NAME = "write";

    private final SpringNavigator mSpringNavigator;
    private final BoardService mBoardService;

    private MTextField mTitle;
    private MTextField mUsername;
    private PasswordField mPassword;
    private RichTextArea mContent;

    public WriteScreen(SpringNavigator springNavigator, BoardService boardService) {
        mSpringNavigator = springNavigator;
        mBoardService = boardService;
    }

    @PostConstruct
    void init() {
        setHeightUndefined();

        buildHeader();
        buildEditor();
        buildFooter();
    }

    private void buildHeader() {
        addComponent(new MHorizontalLayout()
                .add(new ConfirmButton(
                        VaadinIcons.ARROW_LEFT,
                        "",
                        "취소하시겠습니까?",
                        () -> mSpringNavigator.navigateTo(ListScreen.VIEW_NAME)))
        );
    }

    private void buildEditor() {
        mTitle = new MTextField("제목");
        mUsername = new MTextField("작성자");
        mPassword = new PasswordField("비밀번호");
        mContent = new RichTextArea("본문");
        mContent.setWidth("100%");
        mContent.setHeight(20, Unit.REM);

        addComponent(new MVerticalLayout(
                mTitle,
                new MHorizontalLayout(mUsername, mPassword),
                mContent
        ).withFullWidth());
    }

    private void buildFooter() {
        addComponent(new MHorizontalLayout()
                .add(new PrimaryButton(
                        VaadinIcons.CHECK_CIRCLE,
                        "작성",
                        click -> mBoardService.create(
                                mUsername.getValue(),
                                mPassword.getValue(),
                                mTitle.getValue(),
                                mContent.getValue()
                        )))
        );
    }
}
