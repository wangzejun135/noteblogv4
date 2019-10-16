package me.wuwenbin.noteblogv4.model.entity.permission.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wuwenbin
 */
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class RoleResourceKey implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Column(length = 11, nullable = false)
    private Long roleId;
    
    @Column(length = 11, nullable = false)
    private Long resourceId;
}