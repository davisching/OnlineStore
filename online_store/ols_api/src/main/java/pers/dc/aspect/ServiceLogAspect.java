package pers.dc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogAspect {

    private static final Logger log = LoggerFactory.getLogger(ServiceLogAspect.class);

    @Around("execution(* pers.dc.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Class serviceName = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();

        log.info("====== {} 的 {} 開始執行 ======", serviceName, methodName);
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long takeTime = System.currentTimeMillis() - begin;
        log.info("====== {} 的 {} 執行結束, 耗時 {} 毫秒 ======",serviceName, methodName, takeTime);
        return result;
    }
}