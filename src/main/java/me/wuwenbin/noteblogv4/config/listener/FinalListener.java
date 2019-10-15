package me.wuwenbin.noteblogv4.config.listener;

<<<<<<< HEAD
=======
import lombok.extern.slf4j.Slf4j;
import me.wuwenbin.noteblogv4.config.permission.NBAuthAspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> fcd3c059bcf0142a8234a8091b634aea80b4fdf5
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * created by Wuwenbin on 2018/8/3 at 23:15
 * 
 * @author wuwenbin
 */
@Slf4j
@Component
@Order
public class FinalListener implements ApplicationListener<ApplicationReadyEvent>
{
    
<<<<<<< HEAD
=======
    // 日志对象
    private static Logger log = LoggerFactory.getLogger(FinalListener.class);
    
>>>>>>> fcd3c059bcf0142a8234a8091b634aea80b4fdf5
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event)
    {
        log.info("「个人博客」App 启动完毕（欢迎访问楠斯素材资源店）。");
    }
}
