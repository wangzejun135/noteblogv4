package me.wuwenbin.noteblogv4.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    
    public String getId()
    {
        return id;
    }
    
    public String getUrl()
    {
        return url;
    }
    
    public LocalDateTime getTime()
    {
        return time;
    }
    
    public String getSessionId()
    {
        return sessionId;
    }
    
    public String getIpAddr()
    {
        return ipAddr;
    }
    
    public String getIpInfo()
    {
        return ipInfo;
    }
    
    public String getUserAgent()
    {
        return userAgent;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getRequestMethod()
    {
        return requestMethod;
    }
    
    public String getContentType()
    {
        return contentType;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public void setUrl(String url)
    {
        this.url = url;
    }
    
    public void setTime(LocalDateTime time)
    {
        this.time = time;
    }
    
    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }
    
    public void setIpAddr(String ipAddr)
    {
        this.ipAddr = ipAddr;
    }
    
    public void setIpInfo(String ipInfo)
    {
        this.ipInfo = ipInfo;
    }
    
    public void setUserAgent(String userAgent)
    {
        this.userAgent = userAgent;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public void setRequestMethod(String requestMethod)
    {
        this.requestMethod = requestMethod;
    }
    
    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }
    
}
