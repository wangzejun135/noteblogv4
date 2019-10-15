package me.wuwenbin.noteblogv4.exception;

/**
 * created by Wuwenbin on 2018/8/10 at 11:10
 *
 * @author wuwenbin
 */
public class ArticleFetchFailedException extends RuntimeException
{
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    public ArticleFetchFailedException()
    {
        super("文章获取失败！");
    }
    
    public ArticleFetchFailedException(String message)
    {
        super(message);
    }
}
