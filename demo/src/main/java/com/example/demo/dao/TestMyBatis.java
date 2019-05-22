 package com.example.demo.dao;

import com.example.demo.model.Girl;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by tanwen on 2018/6/10.
 */
public interface TestMyBatis {

    public List<Girl> getAllGirls();

    @Select("select * from GIRL where id = #{id}")
    @Results({
            @Result(column = "cup_size",property = "cupSize")
    })
    public Girl getById(Integer id);

    @Update("delete from GIRL where id = #{id}")
    public int delById(Integer id);

    @Insert("insert into GIRL (id,age,cup_size,name) values (#{id},#{age},#{cupSize},#{name})")
    //@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int insert(Girl girl);
}
