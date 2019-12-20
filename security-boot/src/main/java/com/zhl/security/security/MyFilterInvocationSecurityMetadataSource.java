package com.zhl.security.security;

import com.zhl.security.mapper.PermissionMapper;
import com.zhl.security.po.RolePermission;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author Lenovo
 * @title: MyFilterInvocationSecurityMetadataSource
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/11 9:29
 */
@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    private PermissionMapper permissionMapper;
    /**
     * 每一个资源所需要的角色 Collection<ConfigAttribute>决策器会用到
     */
    private static HashMap<String,Collection<ConfigAttribute>> map = null;

    /**
     * 当接收到一个http请求时, filterSecurityInterceptor会调用的方法. 参数object是一个包含url信息的HttpServletRequest实例. 这个方法要返回请求该url所需要的所有权限集合。
     *
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if(null==map){
            loadResourceDefine();
        }
        HttpServletRequest request = ((FilterInvocation)o).getHttpRequest();
        System.out.println("o============================================="+o);
        System.out.println("request======================================"+request);
        if(null!=request){
        for(Iterator<String> it = map.keySet().iterator();it.hasNext();){
            String url = it.next();
            System.out.println("url========================================="+url);
            if(null!=url){
            if(new AntPathRequestMatcher(url).matches(request)){
                return map.get(url);
            }}
        }}
        return null;
    }

    /**
     * Spring容器启动时自动调用, 一般把所有请求与权限的对应关系也要在这个方法里初始化, 保存在一个属性变量里。
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * 指示该类是否能够为指定的方法调用或Web请求提供ConfigAttributes。
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    /**
     * 初始化 所有资源 对应的角色
     */
    public void loadResourceDefine(){

        map = new HashMap<>(16);

        //权限资源 和 角色对应的表 也就是 角色权限 中间表
        List<RolePermission> rolePermissions = permissionMapper.getRolePermissions();
        for(RolePermission rolePermission:rolePermissions){
            String url = rolePermission.getUrl();
            String roleName = rolePermission.getRoleName();
            System.out.println("url:"+url+"<====> roleName"+roleName);}
        //某个资源可以被哪些角色访问
        for(RolePermission rolePermission:rolePermissions){
            String url = rolePermission.getUrl();
            String roleName = rolePermission.getRoleName();
            System.out.println("url:"+url+"<====> roleName"+roleName);
            ConfigAttribute role = new SecurityConfig(roleName);

            if(map.containsKey(url)){
                map.get(url).add(role);
            }else{
                List<ConfigAttribute> list = new ArrayList<>(16);
                list.add(role);
                map.put(url,list);
            }
        }
    }
}
