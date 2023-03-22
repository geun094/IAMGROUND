package com.iamground.iam.board.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iamground.iam.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    int countByBoardTitleContaining(String searchValue);

    List<Board> findByBoardTitleContaining(String searchValue, Pageable paging);

}
