package me.wuwenbin.noteblogv4.web;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import lombok.extern.slf4j.Slf4j;

/**
 * created by Wuwenbin on 2018/7/31 at 20:43
 * 
 * @author wuwenbin
 */
@Controller
@Slf4j
public class KaptchaController
{
    
    private final Producer captchaProducer;
    
    @Autowired
    public KaptchaController(Producer captchaProducer)
    {
        this.captchaProducer = captchaProducer;
    }
    
    @RequestMapping("/image/code")
    public ModelAndView kaptcha(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        
        String capText = captchaProducer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        
        String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        log.info("输出验证码：[{}]", code);
        
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        out.flush();
        out.close();
        return null;
    }
}
