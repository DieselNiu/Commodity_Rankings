package com.github.hcsp.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class CacheAspect {

    private RedisTemplate<String, Object> redisTemplate;

    @Inject
    public CacheAspect(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.github.hcsp.config.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String name = signature.getName();
        Object cachedValue = redisTemplate.opsForValue().get(name);
        if (cachedValue != null) {
            System.out.println("Get value from cache");
            return cachedValue;
        } else {
            System.out.println("Get value from database");
            Object realValue = proceedingJoinPoint.proceed();
            redisTemplate.opsForValue().set(name, realValue,1L, TimeUnit.SECONDS);
            return realValue;
        }
    }
}
