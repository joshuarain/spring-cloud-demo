package com.zhl.security.mapper;

import com.zhl.security.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Lenovo
 * @title: UserMapper
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/11 9:21
 */
@Mapper
public interface UserMapper {
    @Select("select id,username,password from user where username = #{username}")
    User loadUserByUsername(@Param("username") String username);

    @Select("select * from user where username = #{user.username} and password = #{user.password}")
    User login(@Param("user") User user);
}
