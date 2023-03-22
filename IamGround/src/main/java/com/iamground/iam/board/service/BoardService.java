package com.iamground.iam.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.iamground.iam.board.dto.BoardDTO;
import com.iamground.iam.board.dto.CategoryDTO;
import com.iamground.iam.board.entity.Board;
import com.iamground.iam.board.entity.Category;
import com.iamground.iam.board.paging.SelectCriteria;
import com.iamground.iam.board.repository.BoardRepository;
import com.iamground.iam.board.repository.CategoryRepository;

@Service
public class BoardService {
	
	private final BoardRepository boardRepository;
	private final CategoryRepository categoryRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public BoardService(BoardRepository boardRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
		this.boardRepository = boardRepository;
		this.modelMapper = modelMapper;
		this.categoryRepository = categoryRepository;
	}
	
	/* 전체조회 */
	/* 스프링시큐리티를 사용하면 조회포함 모든 메소드에 트렌지셔널 어노테이션을 달아야함 */
	@Transactional
	public List<BoardDTO> findBoardList() {
		
		List<Board> boardList = boardRepository.findAll(Sort.by("boardNo"));
		
		/* ModelMapper를 이용하여 entity를 DTO로 변환 후 List<BoardDTO>로 반환 */
		return boardList.stream().map(board -> modelMapper.map(board, BoardDTO.class))
				/* .filter(board->board.getCategoryCode()==10) */.collect(Collectors.toList());
	}
	
	/* dto를 newboard에 담아서 커밋까지 한줄코딩 */	
	@Transactional
	public void registNewBoard(BoardDTO newBoard) {

		boardRepository.save(modelMapper.map(newBoard, Board.class)); /// 넘어온 레지스트를 save로 담음 만들지 않아도 인터페이스상속되어있음, 인터페이스일경우
	}
	
	
	/* 상세페이지 */
	@Transactional
	public BoardDTO boardDetail(int boardNo) {
		Board board = boardRepository.findById(boardNo).get();
		
		return modelMapper.map(board, BoardDTO.class);
	}

	@Transactional
	public List<CategoryDTO> findAllCategory() {

		List<Category> categoryList = categoryRepository.findAllCategory();
		
		/* ModelMapper를 이용하여 entity를 DTO로 변환 후 List<CategoryDTO>로 반환 */
		return categoryList.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
	}
	
	/* 수정 */
	@Transactional
	public void modifyBoard(BoardDTO board) {

		Board foundBoard = boardRepository.findById((Integer)board.getBoardNo()).get();
		foundBoard.setBoardTitle(board.getBoardTitle());
		foundBoard.setBoardContent(board.getBoardContent());
	}
	
	/* 삭제 (void delete(ID): 식별 키를 통한 삭제, CrudRepository 인터페이스가 제공하는 메소드) */
	@Transactional
	public void delete(Integer boardNo) {
		boardRepository.deleteById(boardNo);
	}
	
	/* 페이징, 검색 */
	public int selectTotalCount(String searchCondition, String searchValue) {

		int count = 0;
		if(searchValue != null) {
			if("boardTitle".equals(searchCondition)) {
				count = boardRepository.countByBoardTitleContaining(searchValue);
			}

		} else {
			count = (int)boardRepository.count();
		}

		return count;
	}

	public List<BoardDTO> searchBoardList(SelectCriteria selectCriteria) {

		int index = selectCriteria.getPageNo() - 1;			// Pageble객체를 사용시 페이지는 0부터 시작(1페이지가 0)
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		/* 페이징 처리와 정렬을 위한 객체 생성 */
		Pageable paging = PageRequest.of(index, count, Sort.by(Sort.Direction.DESC, "boardNo"));	// Pageable은 org.springframework.data.domain패키지로 import

		List<Board> boardList = new ArrayList<Board>();
		if(searchValue != null) {

			if("boardTitle".equals(selectCriteria.getSearchCondition())) {
				boardList = boardRepository.findByBoardTitleContaining(selectCriteria.getSearchValue(), paging);
			}

		} else {
			boardList = boardRepository.findAll(paging).toList();
		}

		/* 자바의 Stream API와 ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
		return boardList.stream().map(board -> modelMapper.map(board, BoardDTO.class)).collect(Collectors.toList());
	}

	
}
