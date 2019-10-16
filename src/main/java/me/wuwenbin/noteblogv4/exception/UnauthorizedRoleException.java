package me.wuwenbin.noteblogv4.exception;

/**
 * 角色未授权 created by Wuwenbin on 2018/7/20 at 14:22
 *
 * @author wuwenbin
 */
public class UnauthorizedRoleException extends RuntimeException
{
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    public UnauthorizedRoleException()
    {
        super();
    }
    
    public UnauthorizedRoleException(String message)
    {
        super(message);
    }
}
