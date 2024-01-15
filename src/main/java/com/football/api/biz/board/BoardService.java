package com.football.api.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.football.api.biz.board.vo.BoardMasterVO;
import com.football.api.biz.board.vo.BoardUgcVO;
import com.football.api.biz.board.vo.UgcIVO;
import com.football.api.biz.board.vo.UgcVO;
import com.github.pagehelper.Page;

@Service
public class BoardService {
    @Autowired
	BoardMapper boardMapper;

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
    	recommendUgcs = boardMapper.selectRecommnedUgcs(ivo);
    	result.setRecommendUgcs(recommendUgcs);
    	return result;
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
}
