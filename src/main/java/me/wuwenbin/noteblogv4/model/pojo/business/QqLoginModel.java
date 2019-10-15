package me.wuwenbin.noteblogv4.model.pojo.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * created by Wuwenbin on 2019/1/2 at 16:57
 *
 * @author wuwenbin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QqLoginModel implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    private String callbackDomain;
    
    private String code;
    
    public String getCallbackDomain()
    {
        return callbackDomain;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public void setCallbackDomain(String callbackDomain)
    {
        this.callbackDomain = callbackDomain;
    }
    
    public void setCode(String code)
    {
        this.code = code;
    }
    
}
