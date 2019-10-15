package me.wuwenbin.noteblogv4.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 记录访问日志的类 created by Wuwenbin on 2018/7/21 at 17:31
 * 
 * @author wuwenbin
 */
@Entity
@Data
@Builder
@Table(name = "sys_logger")
@AllArgsConstructor
@NoArgsConstructor
public class NBLogger implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    
    private String url;
    
    private LocalDateTime time;
    
    private String sessionId;
    
    private String ipAddr;
    
    private String ipInfo;
    
    private String userAgent;
    
    private String username;
    
    private String requestMethod;
    
    private String contentType;
    
}
