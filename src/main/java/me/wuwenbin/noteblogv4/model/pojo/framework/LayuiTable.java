package me.wuwenbin.noteblogv4.model.pojo.framework;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * layui2.x版本推出的dataTable插件,与LayTable的区别在于msg字段。推荐使用此类 created by Wuwenbin on 2017/8/30 at 11:41
 *
 * @author wuwenbin
 */
@Data
public class LayuiTable<T> implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 状态码，0代表成功，其它失败
     */
    private int code;
    
    /**
     * 状态信息，一般可为空
     */
    private String msg;
    
    /**
     * 数据总量
     */
    private long count;
    
    /**
     * 数据，字段是任意的。如：[{"id":1,"username":"贤心"}, {"id":2,"username":"佟丽娅"}]
     */
    private List<T> data;
    
    public LayuiTable(int code, String msg, long count, List<T> data)
    {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
    
    public LayuiTable(long count, List<T> data)
    {
        this.code = 0;
        this.msg = "获取数据成功！";
        this.count = count;
        this.data = data;
    }
    
}
