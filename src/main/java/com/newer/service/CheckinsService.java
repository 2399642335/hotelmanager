package com.newer.service;

import com.newer.domain.Checkins;
import com.newer.mapper.CheckinsMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CheckinsService {
    private SqlSession sqlSession;
    private CheckinsMapper checkinsMapper;
    private void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        checkinsMapper=sqlSession.getMapper(CheckinsMapper.class);
    }
    /**
     * 添加入住信息
     * @param checkins
     * @return
     */
    public int addCheckins(Checkins checkins){
        init();
        int rows=checkinsMapper.addCheckins(checkins);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return rows;
    }

    /**
     * 查询未结账的客户信息
     * @return
     */
    public List<Checkins> findAll(){
        init();
        List<Checkins> list=checkinsMapper.findAll();
        SqlSessionUtil.close(sqlSession);
        return list;
    }
}
