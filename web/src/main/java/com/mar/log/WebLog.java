package com.mar.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@Aspect
@Component
public class WebLog {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.mar.controller.*.*(..))")
    public void cutController(){};

    @Before("cutController()")
    public void printSuccess(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            // 记录下请求内容
            logger.info("URL : " + request.getRequestURL().toString());
            logger.info("HTTP_METHOD : " + request.getMethod());
            logger.info("IP : " + request.getRemoteAddr());
            logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            try {
            Map<String,Object> argsDict=new LinkedHashMap<>();
            for(Object obj:joinPoint.getArgs()){
                argsDict.put(obj.getClass().toString(),obj);
            }
            logger.info("ARGS : " + new ObjectMapper().writeValueAsString(argsDict));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
