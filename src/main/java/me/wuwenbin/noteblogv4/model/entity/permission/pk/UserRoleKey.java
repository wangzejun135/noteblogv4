package me.wuwenbin.noteblogv4.model.entity.permission.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wuwenbin
 */
@Data
@Embeddable
@NoArgsConstructor
public class UserRoleKey implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Column(length = 11, nullable = false)
    private Long userId;
    
    @Column(length = 11, nullable = false)
    private Long roleId;
}