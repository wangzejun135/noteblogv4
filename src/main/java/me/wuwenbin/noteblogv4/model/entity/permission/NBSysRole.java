package me.wuwenbin.noteblogv4.model.entity.permission;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by Wuwenbin on 2018/7/15 at 12:04
 *
 * @author wuwenbin
 */
@Data
@Entity
@Table(name = "sys_role")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NBSysRole implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, length = 11)
    private Long id;
    
    @Column(nullable = false, length = 50)
    @NotEmpty
    @Length(max = 50)
    private String name;
    
    @Column(length = 50)
    @NotEmpty
    @Length(max = 50)
    private String cnName;
}
