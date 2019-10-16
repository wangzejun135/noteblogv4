package me.wuwenbin.noteblogv4.model.pojo.bo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * created by Wuwenbin on 2018/9/7 at 11:05
 *
 * @author wuwenbin
 */
@ToString
@Data
public class MessageQueryBO implements Serializable
{
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    private String clearComment;
    
    private String ipCnAddr;
    
    private Long userId;
}
