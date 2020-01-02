package com.baizhi.conf;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component  //交给工厂管理   只能用@component  不能用@configuration
@Aspect     //点前类为一个切面
public class TestConf {
    //切入点
    @Pointcut(value = ("execution(* com.baizhi.service.*.*(..))"))
    public void pt() {
    } //空方法

    /*
    前置通知
        使用切入点的时候不能添加value
     */
    @Before("pt()")
    public void beafor(JoinPoint joinPoint) {
        System.out.println("---前置通知---");
    }

    @After("pt()")
    public void after(JoinPoint joinPoint) {
        System.out.println("---后置通知---");
    }

    @Around("pt()")
    public Object arrount(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("---前置通知---");
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
            System.out.println(proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("---后置通知---");
        return proceed;
    }
}
