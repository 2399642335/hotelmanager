package com.newer.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoomsMapper {

    @Select("select distinct roomtype from rooms")
    List<String> findTypes();

    @Select("select roomid from rooms where roomtype=#{roomtype} and state='未使用'")
    List<Integer> findRoomIds(@Param("roomtype")String roomtype);
}
