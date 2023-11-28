package com.football.api.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.api.biz.board.vo.BoardMasterVO;

@RestController
public class BoardController {

	@Autowired
	BoardService boardService;
    /**
     * 게시판 조회
     * @param vo
     * @return
     */
	@GetMapping("/boards")
	public List<BoardMasterVO> selectBoards(BoardMasterVO vo) {
		return boardService.selectBoards(vo);
	}    
}
