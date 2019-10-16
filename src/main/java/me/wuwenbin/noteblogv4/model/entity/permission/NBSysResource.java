package me.wuwenbin.noteblogv4.model.entity.permission;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by Wuwenbin on 2018/7/18 at 14:01
 *
 * @author wuwenbin
 */
@Entity
@Table(name = "sys_resource")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class NBSysResource implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, length = 11)
    private Long id;
    
    @Column(nullable = false)
    private String url;
    
    @Column(nullable = false, length = 50)
    private String name;
    
    @Column(nullable = false, length = 50)
    private String permission;
    
    @Enumerated(EnumType.STRING)
    private ResType type;
    
    @Column(name = "[group]")
    private String group;
    
    /**
     * url的类型
     */
    public enum ResType
    {
        /**
         * 可以做菜单栏的导航链接
         */
        NAV_LINK,
        
        /**
         * 其他类型
         */
        OTHER
    }
    
}
