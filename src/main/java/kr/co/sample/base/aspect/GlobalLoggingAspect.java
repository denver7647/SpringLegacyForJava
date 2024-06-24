package kr.co.sample.base.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GlobalLoggingAspect {
	
	Logger log = LoggerFactory.getLogger(GlobalLoggingAspect.class);
	
    @Pointcut("execution(* kr.co.sample..controller.*.*(..))")
    public void loggingPointCut() {}

    @Around("loggingPointCut()")
    public Object logControllerMethods(ProceedingJoinPoint jp) throws Throwable {
        
    	log.info("START >>>> " + jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName());
    	
        Object returnObj = jp.proceed();
       
        log.info("END >>>> " + jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName());
        
        return returnObj;
    }
    
    
}