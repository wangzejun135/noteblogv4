package me.wuwenbin.noteblogv4.model.entity.permission;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;

/**
 * created by Wuwenbin on 2018/7/14 at 10:37
 *
 * @author wuwenbin
 */
@Data
@Builder
@Entity
@AllArgsConstructor
@Table(name = "sys_user")
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class NBSysUser implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, length = 11)
    private Long id;
    
    @Column(length = 20)
    private String username;
    
    @Column(length = 50)
    private String nickname;
    
    @Column(length = 100)
    private String avatar;
    
    private String password;
    
    @Column(updatable = false, name = "[create]")
    @Builder.Default
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create = now();
    
    @Column(length = 20)
    private String qqNum;
    
    private String email;
    
    /**
     * 默认为普通访客用户 一个用户可能有多个角色，此字段为默认角色
     */
    @Column(nullable = false, length = 11)
    @Builder.Default
    private Long defaultRoleId = 2L;
    
    @Column(nullable = false, length = 1, columnDefinition = "tinyint(1)")
    @Builder.Default
    private Boolean enable = TRUE;
    
    private String qqOpenId;
    
    private String wechatOpenId;
    
    public Long getId()
    {
        return id;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getNickname()
    {
        return nickname;
    }
    
    public String getAvatar()
    {
        return avatar;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public LocalDateTime getCreate()
    {
        return create;
    }
    
    public String getQqNum()
    {
        return qqNum;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public Long getDefaultRoleId()
    {
        return defaultRoleId;
    }
    
    public Boolean getEnable()
    {
        return enable;
    }
    
    public String getQqOpenId()
    {
        return qqOpenId;
    }
    
    public String getWechatOpenId()
    {
        return wechatOpenId;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }
    
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public void setCreate(LocalDateTime create)
    {
        this.create = create;
    }
    
    public void setQqNum(String qqNum)
    {
        this.qqNum = qqNum;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setDefaultRoleId(Long defaultRoleId)
    {
        this.defaultRoleId = defaultRoleId;
    }
    
    public void setEnable(Boolean enable)
    {
        this.enable = enable;
    }
    
    public void setQqOpenId(String qqOpenId)
    {
        this.qqOpenId = qqOpenId;
    }
    
    public void setWechatOpenId(String wechatOpenId)
    {
        this.wechatOpenId = wechatOpenId;
    }
    
}
