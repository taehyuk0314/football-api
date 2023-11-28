package com.football.api.biz.board;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.biz.board.vo.BoardMasterVO;

@Mapper
public interface BoardMapper {
    /**
     * 게시판 조회
     * @param vo
     * @return
     */
    public List<BoardMasterVO> selectBoards(BoardMasterVO vo);
}
