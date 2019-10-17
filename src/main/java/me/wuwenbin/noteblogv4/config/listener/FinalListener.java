package me.wuwenbin.noteblogv4.config.listener;

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
    
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event)
    {
        log.info("「个人博客」App 启动完毕（欢迎访问惠风和畅个人博客系统）。");
    }
}
