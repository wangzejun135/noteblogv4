package me.wuwenbin.noteblogv4.model.pojo.vo;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * created by Wuwenbin on 2019/1/7 at 13:59
 *
 * @author wuwenbin
 */
@Data
@Builder
public class BaseDataStatistics implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    private String text;
    
    private long sum;
    
    @Builder.Default
    private String url = "";
}
