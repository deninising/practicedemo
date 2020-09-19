package com.dennis.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Method;

@Aspect
public class LogAspects {

    // 抽取公共的切入点表达式
    // 1、本类引用：写方法名即可
    // 2、其他的切面引用：写方法的全名
    @Pointcut("execution(public void com.dennis.aop.MathCalculator.piv(..))")
    public void pointCut() {
    }

    // @Before在目标方法前执行，切入点表达式（指定在哪个方法切入）
//    @Before("public int com.dennis.aop.MathCalculator.div(int, int)")
//    @Before("pointCut()")
//    public void logStart(JoinPoint joinPoint) {
//        System.out.println("============前置通知开始============");
//        Object[] args = joinPoint.getArgs();
//        args[0] = 3;
//        args[1] = 3;
//        System.out.println(Arrays.toString(args));
//        System.out.println(joinPoint.getSignature());
//        System.out.println("@Before(\"pointCut()\")除法运行...参数的列表是：{}");
//        System.out.println("============前置通知结束============");
//    }
//
//    // 后置通知
//    @After("pointCut()")
//    public void logEnd(JoinPoint joinPoint) {
//        System.out.println("============后置通知开始============");
//        System.out.println(joinPoint.getSignature().getName());
//        System.out.println("@After(\"pointCut()\")除法结束...");
//        System.out.println("============后置通知结束============");
//    }
//    // 最终通知
//    @AfterReturning(value = "pointCut()",returning = "result")
//    public void logReturn(Object result) {
//        System.out.println("============最终通知开始（在目标方法【执行】return result方法后开始）============");
//        System.out.println(result);
//        System.out.println("@AfterReturning(\"pointCut()\")除法正常返回...运行结果是：{}");
//        System.out.println("============最终通知结束（目标方【退出】前结束）============");
//    }
//
//    // 异常通知
//    @AfterThrowing(value = "pointCut()",throwing = "exception")
//    public void logException(Exception exception) {
//        System.out.println("============异常通知开始============");
//        System.out.println("@AfterThrowing(\"pointCut()\")除法异常...异常信息："+exception);
//        System.out.println("============异常通知结束============");
//    }


    // 环绕通知最大得特点可以处理目标方法原有得返回对象
/*    // 环绕通知(无返回值)
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
    }*/

    // 环绕通知(有返回值)
    @Around("pointCut()")
    public Integer logAroundWithResult(ProceedingJoinPoint pjp) {
        Object proceed = null;

        try {
            System.out.println("前置逻辑执行");
            Object[] args = pjp.getArgs();
            Object user = args[0];
            System.out.println(user);
            Class<?> aClass = user.getClass();
            Method setUserName = aClass.getMethod("setUserName", String.class);
            Method setUserAge = aClass.getMethod("setUserAge", String.class);
            setUserAge.invoke(user, "假年龄");
            setUserName.invoke(user, "假张三");
            args[0] = user;
            proceed = pjp.proceed(args);
            System.out.println("后置逻辑执行");
        } catch (Throwable throwable) {
            System.out.println("异常逻辑处理执行");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终逻辑执行");
        }

        return (Integer) proceed;
    }

}
