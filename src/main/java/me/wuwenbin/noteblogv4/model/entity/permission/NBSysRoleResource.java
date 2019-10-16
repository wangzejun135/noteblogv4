package me.wuwenbin.noteblogv4.model.entity.permission;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.wuwenbin.noteblogv4.model.entity.permission.pk.RoleResourceKey;

/**
 * created by Wuwenbin on 2018/7/18 at 14:09
 * @author wuwenbin
 */
@Entity
@Table(name = "sys_role_resource")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NBSysRoleResource implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RoleResourceKey pk;

    @Column(nullable = false, columnDefinition = "tinyint(1)")
    @Builder.Default
    private Boolean enable = Boolean.TRUE;
}
