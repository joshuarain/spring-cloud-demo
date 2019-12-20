package com.zhl.security.mapper;

import com.zhl.security.po.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Lenovo
 * @title: RoleMapper
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/11 9:22
 */
@Mapper
public interface RoleMapper {
    @Select("select id ,name \n" +
            "from role \n" +
            "where id in \n" +
            "(select role_id from user_role where user_id = #{userId})")
    List<Role> getRolesByUserId(@Param("userId") long userId);
}
