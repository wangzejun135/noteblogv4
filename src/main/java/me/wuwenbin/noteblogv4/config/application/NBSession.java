package me.wuwenbin.noteblogv4.config.application;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.wuwenbin.noteblogv4.model.entity.permission.NBSysUser;
import me.wuwenbin.noteblogv4.util.NBUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDateTime;

import static java.lang.Boolean.FALSE;
import static java.time.LocalDateTime.now;

/**
 * created by Wuwenbin on 2018/2/7 at 20:56
 * @author wuwenbin
 */
@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NBSession implements Serializable {

    @Builder.Default
    private String id = IdUtil.randomUUID();
    private String host;
    @Builder.Default
    private LocalDateTime startTimestamp = now();
    @Builder.Default
    private LocalDateTime lastAccessTime = now();
    @Builder.Default
    private long timeout = DEFAULT_TIMEOUT_MILLS;
    @Builder.Default
    private LocalDateTime expireTimestamp = now().plusSeconds(DEFAULT_TIMEOUT_MILLS / 1000);
    @Builder.Default
    private boolean expired = FALSE;
    private NBSysUser sessionUser;

    public static final long DEFAULT_TIMEOUT_MILLS = 30 * 60 * 1000;

    private static HttpServletRequest getRequest() {
        ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert ra != null;
        return ra.getRequest();
    }

    /**
     * 更新session
     */
    public void update() {
        String info = "update session for id:[{}], at [{}] by url:[{}] with ip:[{}]";
        log.info(StrUtil.format(info, this.getId(), LocalDateTime.now(), getRequest().getRequestURL()), NBUtils.getRemoteAddress(getRequest()));
        this.lastAccessTime = now();
        this.expireTimestamp = lastAccessTime.plusSeconds(getTimeout() / 1000);
        if (!host.equals(NBUtils.getRemoteAddress(getRequest()))) {
            log.info("ip变动，存在非法访问情况");
            this.expired = true;
        }
    }

    /**
     * 注销session，即把session变为过期状态
     */
    public void destroy() {
        String info = "destroy session for id:[{}], at [{}]";
        log.info(StrUtil.format(info, this.getId(), LocalDateTime.now()));
        this.expired = true;
    }


    public boolean isExpired() {
        if (this.expired) {
            return true;
        }

        long timeout = getTimeout();
        if (timeout >= 0) {
            LocalDateTime lastAccessTime = getLastAccessTime();
            if (lastAccessTime == null) {
                throw new IllegalStateException("最后访问时间为空");
            }
            LocalDateTime expire = getExpireTimestamp();
            boolean isExpire = LocalDateTime.now().isAfter(lastAccessTime.plusSeconds(timeout / 1000));
            log.info("当前时间：{}，最后访问时间：{}，过期时间：{}，session 是否过期：{}", LocalDateTime.now(), lastAccessTime, expire, isExpire);
            if (isExpire) {
                this.expired = true;
            }
            return isExpire;
        }
        this.expired = true;
        return true;
    }
}
