package me.wuwenbin.noteblogv4.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能中心面板 created by Wuwenbin on 2018/7/19 at 15:54
 * 
 * @author wuwenbin
 */
@Data
@Entity
@Table(name = "nb_function_panel")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NBFunction implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11, nullable = false, updatable = false)
    private Long id;
    
    @Column(length = 10, nullable = false)
    private String logoName;
    
    @Column(nullable = false)
    private String logoIcon;
    
    @Column(nullable = false)
    private String logoHref;
    
    private String jumpMsg;
}
