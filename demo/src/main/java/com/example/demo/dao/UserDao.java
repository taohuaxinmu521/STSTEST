package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.MiaoshaUser;
import org.apache.ibatis.annotations.Update;

/**
 * Created by tanwen on 2018/9/8.
 */
public interface UserDao extends BaseMapper<MiaoshaUser> {

    /*@Select("select * from miaosha_user where id = #{id}")
    public MiaoshaUser getById(@Param("id")long id);*/

    @Update("update miaosha_user set password = #{password} where id = #{id}")
    public void update(MiaoshaUser toBeUpdate);

}
