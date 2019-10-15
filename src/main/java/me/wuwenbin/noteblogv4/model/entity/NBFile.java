package me.wuwenbin.noteblogv4.model.entity;

import static java.time.LocalDateTime.now;

import java.io.Serializable;
import java.time.LocalDateTime;

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
 * created by Wuwenbin on 2018/7/15 at 11:55
 * 
 * @author wuwenbin
 */
@Data
@Entity
@Table(name = "nb_file")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NBFile implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, length = 11)
    public Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(length = 500)
    private String url;
    
    @Builder.Default
    private LocalDateTime post = now();
}
