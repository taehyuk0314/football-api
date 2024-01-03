package com.football.api.biz.like;


import org.apache.ibatis.annotations.Mapper;

import com.football.api.biz.member.vo.LikeMasterVO;


@Mapper
public interface LikeMapper {
	
     /**
      * 좋아요
      * @param vo
      * @return
      */
	public int insertLike(LikeMasterVO vo);
	
	/**
	 * 좋아요 취소
	 * @param vo
	 * @return
	 */
	public int deleteLike(LikeMasterVO vo);
}
