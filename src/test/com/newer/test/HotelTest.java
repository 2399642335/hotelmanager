package com.newer.test;

import com.newer.mapper.RoomsMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class HotelTest {

    @Test
    public void testFind(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        RoomsMapper roomsMapper = sqlSession.getMapper(RoomsMapper.class);
        roomsMapper.findTypes().forEach(roomstype->System.out.println(roomstype));
    }

    @Test
    public void testFindRoomIds(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        RoomsMapper roomsMapper = sqlSession.getMapper(RoomsMapper.class);
        roomsMapper.findRoomIds("roomtype").forEach(roomstype->System.out.println(roomstype));
    }
}
