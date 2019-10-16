package me.wuwenbin.noteblogv4.model.pojo.business;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Data;

/**
 * created by Wuwenbin on 2018/7/21 at 18:37
 * 
 * @author wuwenbin
 */
@Data
public class SimpleLoginData implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    private HttpServletRequest request;
    
    private HttpServletResponse response;
    
    private String bmyName;
    
    private String bmyPass;
    
    private Boolean remember;
    
    private String vercode;
    
}
