package me.wuwenbin.noteblogv4.model.entity.permission;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by Wuwenbin on 2018/7/20 at 21:23
 *
 * @author wuwenbin
 */
@Entity
@Data
@Table(name = "sys_menu")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class NBSysMenu implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, length = 11)
    private Long id;

    @Column(nullable = false, length = 11)
    @NotNull
    private Long parentId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String icon;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private MenuType type = MenuType.PARENT;

    @Column(length = 11)
    private Long roleId;

    @Column(length = 1, columnDefinition = "tinyint(1)", nullable = false)
    @Builder.Default
    private Boolean enable = Boolean.TRUE;

    private String remark;

    @Builder.Default
    private Integer orderIndex = 0;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "resource_id")
    private NBSysResource resource;



    /**
     * 菜单类型
     * 目前只支持两级菜单
     */
    public enum MenuType {

        /**
         * 根节点
         */
        ROOT,

        /**
         * 非叶节点，即父节点
         */
        PARENT,

        /**
         * 叶子节点，子节点，无下级的
         */
        LEAF
    }
}
