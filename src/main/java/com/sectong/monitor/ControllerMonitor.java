package com.sectong.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xueyong on 16/7/1.
 * demo.
 */

@Aspect
@Component
public class ControllerMonitor {

    private static final Logger logger = LoggerFactory.getLogger(ControllerMonitor.class);

//    @Around("execution(* com.sectong.controller.*Controller.*(..))")
    public Object accessController(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] objects = joinPoint.getArgs();
        for (Object object : objects) {
            if (object instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) object;
//                String pram = IOUtils.toString(request.getInputStream());
                String pram = request.getParameter("abc");
                logger.info("|request|" + pram);
            }
//            logger.info("|response|" + response.getBody().toString());
        }
        return joinPoint.proceed();
    }
}
