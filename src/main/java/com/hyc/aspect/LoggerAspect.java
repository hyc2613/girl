package com.hyc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hyc26 on 2018-10-26.
 */
@Aspect
@Component
public class LoggerAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    /**
     * 通用的一个切面，供before，after 共用
     */
    @Pointcut("execution(public * com.hyc.controller.GirlController.findAll(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url:{}", request.getRequestURL());
        logger.info("method:{}", request.getMethod());
        logger.info("ip:{}", request.getRemoteAddr());
        logger.info("class:{}", joinPoint.getSignature());
        logger.info("args:{}", joinPoint.getArgs());
    }

    @After("log()")
    public void after() {
        System.out.println("logging after method...");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("the return is:{}", object);
    }

}
