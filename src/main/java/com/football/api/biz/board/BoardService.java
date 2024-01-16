package com.football.api.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.api.biz.board.vo.BoardUgcVO;
import com.football.api.biz.board.vo.UgcIVO;
import com.football.api.biz.board.vo.UgcVO;
import com.football.api.biz.like.LikeMapper;
import com.football.api.biz.member.vo.LikeMasterVO;
import com.github.pagehelper.Page;

@Service
public class BoardService {
    @Autowired
	BoardMapper boardMapper;
    @Autowired
    LikeMapper likeMapper;
    /**
     * ugc 조회
     * @param vo
     * @return
     */    
    public List<BoardUgcVO> selectUgcs(BoardUgcVO vo) {
    	vo.setBoardTypeCd("002001");
        return boardMapper.selectUgcs(vo);
    }
    
    /**
     * 다양한 ugc 조회
     * @param vo
     * @return
     */    
    public UgcVO selectSpecialUgcs(UgcIVO ivo) {
    	UgcVO result = new UgcVO();
    	ivo.setPageLength(6);
    	ivo.setIsRandom(true);
    	Page<BoardUgcVO> recommendUgcs = null;
    	recommendUgcs = boardMapper.selectRecommendUgcs(ivo);
    	result.setRecommendUgcs(recommendUgcs);
    	return result;
    }    
    /**
     * ugc 상세
     * @param vo
     * @return
     */
	public BoardUgcVO selectUgc(BoardUgcVO vo) {
		return boardMapper.selectUgc(vo);
	}  
    /**
     * ugc 작성
     * @param vo
     * @return
     */    
	public int insertUgc(BoardUgcVO vo) {
		vo.setBoardTypeCd("002001");
		boardMapper.insertBoard(vo);
		return boardMapper.insertBoardUgc(vo);
	}
	/**
	 * ugc 좋아요
	 * @param vo
	 * @return
	 */
	public int likeBoard(LikeMasterVO vo) {
		likeMapper.insertLike(vo);
		return boardMapper.likeBoard(vo);
	}    
	
	/**
	 * ugc 좋아요
	 * @param vo
	 * @return
	 */
	public int unLikeBoard(LikeMasterVO vo) {
		likeMapper.deleteLike(vo);
		return boardMapper.unLikeBoard(vo);
	}	
}
