package me.wuwenbin.noteblogv4.config.permission;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 基于注解的权限简单验证 此处为权限注解 created by Wuwenbin on 2018/7/18 at 15:37
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NBAuthRole
{
    
    /**
     * 角色名 只要满足该角色即可访问，不需要匹配权限
     *
     * @return
     */
    String[] value();
    
}
