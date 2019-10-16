package me.wuwenbin.noteblogv4.model.pojo.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import me.wuwenbin.noteblogv4.model.entity.NBComment;

/**
 * created by Wuwenbin on 2019/1/7 at 14:11
 *
 * @author wuwenbin
 */
@Data
@Builder
public class LatestComment implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    private Long articleId;
    
    private String articleTitle;
    
    private LocalDateTime articleDate;
    
    private NBComment comment;
}
