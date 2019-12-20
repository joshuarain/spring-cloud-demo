package com.zhl.security.mapper;

import com.zhl.security.po.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Lenovo
 * @title: PermissionMapper
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/11 9:32
 */
@Mapper
public interface PermissionMapper {

    @Select("select p.url url,r.name roleName\n" +
            "from role_permission rp \n" +
            "left join role r \n" +
            "on \n" +
            "rp.role_id = r.id \n" +
            "left join permission p \n" +
            "on\n" +
            "rp.permission_id = p.id")
    List<RolePermission> getRolePermissions();
}
