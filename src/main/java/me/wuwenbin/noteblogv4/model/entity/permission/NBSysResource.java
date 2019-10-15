package me.wuwenbin.noteblogv4.model.entity.permission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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
public class NBSysResource implements Serializable {

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
    
    

    public Long getId()
    {
        return id;
    }



    public String getUrl()
    {
        return url;
    }



    public String getName()
    {
        return name;
    }



    public String getPermission()
    {
        return permission;
    }



    public ResType getType()
    {
        return type;
    }



    public String getGroup()
    {
        return group;
    }



    public void setId(Long id)
    {
        this.id = id;
    }



    public void setUrl(String url)
    {
        this.url = url;
    }



    public void setName(String name)
    {
        this.name = name;
    }



    public void setPermission(String permission)
    {
        this.permission = permission;
    }



    public void setType(ResType type)
    {
        this.type = type;
    }



    public void setGroup(String group)
    {
        this.group = group;
    }



    /**
     * url的类型
     */
    public enum ResType {
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
