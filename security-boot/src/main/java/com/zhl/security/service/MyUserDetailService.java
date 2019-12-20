package com.zhl.security.service;

import com.zhl.security.mapper.UserMapper;
import com.zhl.security.po.Role;
import com.zhl.security.po.User;
import com.zhl.security.mapper.RoleMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lenovo
 * @title: MyUserDetailService
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/11 9:26
 */
@Component
public class MyUserDetailService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        if(null!=user) {
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            List<Role> roles = roleMapper.getRolesByUserId(user.getId());
            user.setAuthorities(roles);
        }
        return user;
    }
}
