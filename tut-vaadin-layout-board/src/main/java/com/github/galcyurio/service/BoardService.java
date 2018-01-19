package com.github.galcyurio.service;

import com.github.galcyurio.data.domain.Board;
import com.github.galcyurio.repository.BoardRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

/**
 * @author galcyurio
 */
@Service
public class BoardService {

    private final BoardRepository mBoardRepository;

    public BoardService(BoardRepository boardRepository) {
        mBoardRepository = boardRepository;
    }

    @PostConstruct
    void init() {
        IntStream.rangeClosed(1, 30)
                .forEach(it -> create(
                        "sampler",
                        "password",
                        "dummy title" + it,
                        "dummy content" + it));
    }

    public Board create(String username, String password, String title, String content) {
        Board board = Board.builder()
                .username(username)
                .password(password)
                .title(title)
                .content(content)
                .build();

        return mBoardRepository.save(board);
    }

    public List<Board> findAll() {
        return mBoardRepository.findAll();
    }

    public Page<Board> findAll(Pageable pageable) {
        return mBoardRepository.findAll(pageable);
    }

    public Board findById(Long id) {
        return mBoardRepository.findOne(id);
    }

    public Board update(Board board) {
        return mBoardRepository.save(board);
    }

    public void delete(Long id) {
        mBoardRepository.delete(id);
    }
}
