package com.football.api.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.football.api.biz.board.vo.BoardReplyVO;
import com.football.api.biz.board.vo.BoardUgcVO;
import com.football.api.biz.board.vo.UgcIVO;
import com.football.api.biz.board.vo.UgcVO;
import com.football.api.biz.member.vo.LikeMasterVO;

@RestController
public class BoardController {

	@Autowired
	BoardService boardService;
    /**
     * 게시판 조회
     * @param vo
     * @return
     */
	@GetMapping("/board/ugcs")
	public List<BoardUgcVO> selectUgcs(BoardUgcVO vo) {
		return boardService.selectUgcs(vo);
	}  
	
	/**
	 * 베스트 게시판 조회
	 * @param vo
	 * @return
	 */
	@GetMapping("/board/special-ugcs")
	public UgcVO selectSpecialUgcs(UgcIVO vo) {
		return boardService.selectSpecialUgcs(vo);
	}   
	
    /**
     * 게시판 조회
     * @param vo
     * @return
     */
	@GetMapping("/board/ugc/{boardNo}")
	public BoardUgcVO selectUgc(BoardUgcVO vo) {
		return boardService.selectUgc(vo);
	}  
	
	/**
	 * 게시판 작성
	 * @param vo
	 * @return
	 */
	@PostMapping("/board/ugc")
	public int insertUgc(@RequestBody BoardUgcVO vo) {
		return boardService.insertUgc(vo);
	}
	/**
	 * ugc 좋아요
	 * @param vo
	 * @return
	 */
	@PostMapping("/board/like")
	public int likeBoard(@RequestBody LikeMasterVO vo) {
		return boardService.likeBoard(vo);
	}    
	
	/**
	 * ugc 좋아요
	 * @param vo
	 * @return
	 */
	@DeleteMapping("/board/like")
	public int unLikeBoard(LikeMasterVO vo) {
		return boardService.unLikeBoard(vo);
	}
	/**
	 * 댓글 달기
	 * @param vo
	 * @return
	 */
	@PostMapping("/board/reply")
	public int insertReply(@RequestBody BoardReplyVO vo) {
		return boardService.insertReply(vo);
	}	
}
