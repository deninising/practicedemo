package com.dennis.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {

    // 抽取公共的切入点表达式
    // 1、本类引用：写方法名即可
    // 2、其他的切面引用：写方法的全名
    @Pointcut("execution(public Integer com.dennis.aop.MathCalculator.div(..))")
    public void pointCut(){}

    // @Before在目标方法前执行，切入点表达式（指定在哪个方法切入）
    //@Before("public int com.dennis.aop.MathCalculator.div(int, int)")
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println(joinPoint.getSignature());
        System.out.println("@Before(\"pointCut()\")除法运行...参数的列表是：{}");
    }

    // 后置通知
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("@After(\"pointCut()\")除法结束...");
    }
    // 最终通知
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result) {
        System.out.println(result);
        System.out.println("@AfterReturning(\"pointCut()\")除法正常返回...运行结果是：{}");
    }

    // 异常通知
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception) {
        System.out.println(exception);
        System.out.println("@AfterThrowing(\"pointCut()\")除法异常...异常信息：{}");
    }

    // 环绕通知
    @Around("pointCut()")
    public void logAround(ProceedingJoinPoint pjp){

        try {
            System.out.println("前置逻辑执行");
            pjp.proceed();
            System.out.println("后置逻辑执行");
        } catch (Throwable throwable) {
            System.out.println("异常逻辑处理执行");
            throwable.printStackTrace();
        }finally {
            System.out.println("最终逻辑执行");
        }
    }

}
