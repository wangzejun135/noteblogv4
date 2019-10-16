package me.wuwenbin.noteblogv4.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章分类表 created by Wuwenbin on 2018/7/15 at 11:49
 * 
 * @author wuwenbin
 */
@Data
@Entity
@Table(name = "nb_cate")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NBCate implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, length = 11)
    private Long id;
    
    @Column(length = 50, nullable = false)
    @NotEmpty
    private String name;
    
    @Column(length = 50)
    @NotEmpty
    private String cnName;
    
    private String fontIcon;
    
}
