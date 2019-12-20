package com.zhl.security.po;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Lenovo
 * @title: Role
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/11 9:17
 */
public class Role implements GrantedAuthority {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}