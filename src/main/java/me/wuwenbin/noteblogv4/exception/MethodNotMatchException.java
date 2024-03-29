package me.wuwenbin.noteblogv4.exception;

/**
 * created by Wuwenbin on 2018/8/3 at 22:16
 * 
 * @author wuwenbin
 */
public class MethodNotMatchException extends RuntimeException
{
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    public MethodNotMatchException()
    {
        super();
    }
    
    public MethodNotMatchException(String message)
    {
        super(message);
    }
    
    public MethodNotMatchException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public MethodNotMatchException(Throwable cause)
    {
        super(cause);
    }
}
