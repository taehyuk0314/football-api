package com.football.footballapi.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.footballapi.biz.board.vo.BoardMasterVO;

@Service
public class BoardService {
    @Autowired
	BoardMapper boardMapper;

    /**
     * 게시판 조회
     * @param vo
     * @return
     */    
    public List<BoardMasterVO> selectBoards(BoardMasterVO vo) {
        return boardMapper.selectBoards(vo);
    }    
}
