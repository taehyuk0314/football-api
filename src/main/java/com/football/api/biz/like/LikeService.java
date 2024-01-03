package com.football.api.biz.like;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.api.biz.member.vo.LikeMasterVO;

@Service
public class LikeService {

    @Autowired
    LikeMapper likeMapper;

    /**
     * 좋아요
     * @param vo
     * @return
     */
    public int insertLike(LikeMasterVO vo) {
        return likeMapper.insertLike(vo);
    }
}
