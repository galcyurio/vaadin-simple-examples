package com.github.galcyurio.repository;

import com.github.galcyurio.data.domain.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author galcyurio
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
