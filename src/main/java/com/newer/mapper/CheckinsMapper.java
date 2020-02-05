package com.newer.mapper;

import com.newer.domain.Checkins;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CheckinsMapper {

    @Insert("insert into checkins values(null,#{name},#{gender},#{cardtype},#{cardno}," +
            "#{roomid},#{num},null,1,now(),null)")
    int addCheckins(Checkins checkins);

    @Select("select * from checkins from cstate='未结账'")
    List<Checkins> findAll();
}
