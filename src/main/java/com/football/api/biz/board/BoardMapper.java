package com.football.api.biz.board;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.biz.board.vo.BoardMasterVO;
import com.football.api.biz.board.vo.BoardUgcVO;
import com.football.api.biz.board.vo.UgcIVO;
import com.football.api.biz.member.vo.LikeMasterVO;
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
    public Page<BoardUgcVO> selectRecommendUgcs(UgcIVO vo);
    
    /**
    * ugc 상세
    * @param vo
    * @return
    */
	public BoardUgcVO selectUgc(BoardUgcVO vo);
	
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
    
    /**
     * ugc 좋아요 카운팅
     * @param vo
     * @return
     */     
    public int likeBoard(LikeMasterVO vo);
    
    /**
     * 상품 안좋아요 카운팅
     * @param vo
     * @return
     */     
    public int unLikeBoard(LikeMasterVO vo);	
}
