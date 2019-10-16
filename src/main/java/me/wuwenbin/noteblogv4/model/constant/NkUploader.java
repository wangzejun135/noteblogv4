package me.wuwenbin.noteblogv4.model.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * created by Wuwenbin on 2018/8/4 at 10:28
 * 
 * @author wuwenbin
 */
@Data
public class NkUploader implements Serializable
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    public static final String SUCCESS = "000";
    
    public static final String ERROR = "001";
    
    private String code;
    
    private String message;
    
    private Map<String, Object> item = new HashMap<>();
    
    public NkUploader ok(String url)
    {
        NkUploader json = new NkUploader();
        json.setCode(SUCCESS);
        json.setMessage(message);
        item.put("url", url);
        json.setItem(item);
        return json;
    }
    
    public NkUploader err(String message)
    {
        NkUploader json = new NkUploader();
        json.setCode(ERROR);
        json.setMessage(message);
        return json;
    }
}
