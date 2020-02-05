package com.newer.service;

import com.newer.mapper.RoomsMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoomsService {

    private RoomsMapper roomsMapper;
    private SqlSession sqlSession;

    /**
     * 初始化映射器接口实例
     */
    private void init(){
        sqlSession = SqlSessionUtil.getSqlSession();
        roomsMapper = sqlSession.getMapper(RoomsMapper.class);
    }

    /**
     * 查询所有房间类型名称
     * @return
     */
    public List<String> findTypes(){
        init();
        List<String> list = roomsMapper.findTypes();
        SqlSessionUtil.close(sqlSession);
        return list;
    }

    /**
     * 根据房间类型查询所有房间编号集合
     * @return
     */
    public List<Integer> findRoomIds(String roomtype){
        init();
        List<Integer> list = roomsMapper.findRoomIds(roomtype);
        SqlSessionUtil.close(sqlSession);
        return list;
    }
}
