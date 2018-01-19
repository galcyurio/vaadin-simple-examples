package com.github.galcyurio.ui.list;

import com.github.galcyurio.data.domain.Board;
import com.github.galcyurio.service.BoardService;
import com.github.galcyurio.ui.write.WriteScreen;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * @author galcyurio
 */
@UIScope
@SpringView(name = ListScreen.VIEW_NAME)
public final class ListScreen extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";

    private final SpringNavigator mSpringNavigator;
    private final BoardService mBoardService;

    public ListScreen(SpringNavigator springNavigator, BoardService boardService) {
        mSpringNavigator = springNavigator;
        mBoardService = boardService;
    }

    @PostConstruct
    void init() {
        addStyleName("list-screen");
        setSizeFull();

        buildHeaderLayout();
        buildBoardGrid();
        buildFooterLayout();
    }

    private void buildHeaderLayout() {
        HorizontalLayout layout = new HorizontalLayout() {{
            addComponents(new Label("게시글 목록"));
            setWidth(100, Unit.PERCENTAGE);
        }};
        addComponent(layout);
    }

    private void buildBoardGrid() {
        Grid<Board> grid = new Grid<Board>() {{
            setItems(mBoardService.findAll());
            addColumn(Board::getId).setCaption("번호");
            addColumn(Board::getTitle).setCaption("제목");
            addColumn(Board::getUsername).setCaption("작성자");
            addColumn(Board::getCreatedDate).setCaption("날짜");

            setSizeFull();
        }};

        addComponent(grid);
        setExpandRatio(grid, 1);
    }

    private void buildFooterLayout() {
        HorizontalLayout layout = new HorizontalLayout() {{
            Button button = new Button("글쓰기");
            button.addStyleName("violet");
            button.addClickListener(click -> mSpringNavigator.navigateTo(WriteScreen.VIEW_NAME));

            setWidth(100f, Unit.PERCENTAGE);
            addComponents(button);

            setComponentAlignment(button, Alignment.BOTTOM_RIGHT);
        }};
        addComponent(layout);
    }
}
