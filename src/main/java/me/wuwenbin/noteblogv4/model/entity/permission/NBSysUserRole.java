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
import me.wuwenbin.noteblogv4.model.entity.permission.pk.UserRoleKey;

/**
 * created by Wuwenbin on 2018/7/18 at 14:04
 *
 * @author wuwenbin
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sys_user_role")
public class NBSysUserRole implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UserRoleKey pk;

    @Column(nullable = false, columnDefinition = "tinyint(1)")
    @Builder.Default
    private Boolean enable = Boolean.TRUE;

}
