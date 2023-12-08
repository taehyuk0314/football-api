package com.football.api.biz.board;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.biz.board.vo.BoardMasterVO;
import com.football.api.biz.board.vo.BoardUgcVO;

@Mapper
public interface BoardMapper {
    /**
     * ugc 조회
     * @param vo
     * @return
     */
    public List<BoardUgcVO> selectUgcs(BoardUgcVO vo);
}
