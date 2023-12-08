package com.football.api.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.api.biz.board.vo.BoardMasterVO;
import com.football.api.biz.board.vo.BoardUgcVO;

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
}
