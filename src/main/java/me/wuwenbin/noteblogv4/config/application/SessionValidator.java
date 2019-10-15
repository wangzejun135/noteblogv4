package me.wuwenbin.noteblogv4.config.application;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.Enumeration;

=======
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> fcd3c059bcf0142a8234a8091b634aea80b4fdf5
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 定时任务验证用户登录有效期 created by Wuwenbin on 2018/2/7 at 22:40
 *
 * @author wuwenbin
 */
@Slf4j
@Component
@EnableScheduling
<<<<<<< HEAD
public class SessionValidator
{
    
=======
public class SessionValidator {
    
    // 日志对象
    private static Logger log = LoggerFactory.getLogger(SessionValidator.class);

>>>>>>> fcd3c059bcf0142a8234a8091b634aea80b4fdf5
    private final NBContext nbContext;
    
    @Autowired
    public SessionValidator(NBContext nbContext)
    {
        this.nbContext = nbContext;
    }
    
    @Scheduled(cron = "0 0/10 * * * ?")
    public void sessionValidate()
    {
        log.info("validate session in noteblog application task...");
        Enumeration<String> keys = nbContext.keys();
        while (keys.hasMoreElements())
        {
            String uuid = keys.nextElement();
            NBSession session = nbContext.get(uuid);
            if (session != null)
            {
                if (session.isExpired())
                {
                    String info = "delete session for id:[{}], at [{}]";
                    log.info(StrUtil.format(info, session.getId(), LocalDateTime.now()));
                    nbContext.removeSessionUser(uuid);
                }
            }
        }
    }
    
}
