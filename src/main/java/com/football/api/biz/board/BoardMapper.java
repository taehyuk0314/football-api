package com.football.api.biz.board;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.biz.board.vo.BoardMasterVO;
import com.football.api.biz.board.vo.BoardUgcVO;
import com.football.api.biz.board.vo.UgcIVO;
import com.github.pagehelper.Page;

@Mapper
public interface BoardMapper {
    /**
     * ugc 조회
     * @param vo
     * @return
     */
    public List<BoardUgcVO> selectUgcs(BoardUgcVO vo);
    
    /**
     * 베스트 ugc 조회
     * @param vo
     * @return
     */
    public Page<BoardUgcVO> selectRecommnedUgcs(UgcIVO vo);
    /**
     * ugc 작성
     * @param vo
     * @return
     */    
	public int insertBoard(BoardMasterVO vo);    
	/**
	 * ugc 작성
	 * @param vo
	 * @return
	 */    
	public int insertBoardUgc(BoardUgcVO vo);    
}
