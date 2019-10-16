package me.wuwenbin.noteblogv4.model.pojo.bo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * created by Wuwenbin on 2018/9/10 at 下午2:19
 *
 * @author wuwenbin
 */
@ToString
@Data
public class ArticleQueryBO implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 包括 标题、内容等
     */
    private String searchStr;
    
    private Long cateId;
    
    /**
     * tag搜索为单独搜索，不和其余两个一起两个联合搜索
     */
    private String tagSearch;
    
}
