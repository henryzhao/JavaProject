package com.java.learn.Test;

import com.java.learn.Bean.SetterBean;
import com.java.learn.relfect.SpringWine;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

/**
 * Created by dell on 2017/11/24.
 */

public class Test {
    public static void main(String[] args){
        demo();
        demo1();
    }

    /**
     * 利用反射实现简单的注解注入实例
     */
    public static void demo(){
        SetterBean bean = SpringWine.getBean();
        bean.loginTest();
    }

    /**
     * 动态代理
     */
    public static void demo1(){
        //准备好需要被代理的原型对象
        SetterBean bean = SpringWine.getBean();
        ProxyFactory factory = new ProxyFactory(); //ProxyFactoryBean的功能比ProxyFactory强
        factory.setTarget(bean);

        //构造切面
        //切面=切点 + 通知

        //切点
        JdkRegexpMethodPointcut cut = new JdkRegexpMethodPointcut();

        cut.setPattern("com.java.learn.EnglishUserImpl.login");//方法1：可以直接给方法全名
        cut.setPattern(".*login.*");// 方法2： 或者给正则表达式

        //通知
        Advice advice = new MethodInterceptor() {
            //哈哈，看到这个是不是和动态代理中的那个方法很像
            @Override
            public Object invoke(MethodInvocation methodInv) throws Throwable {
                System.out.println("前面拦拦...");
                Object resObj = methodInv.proceed();//放行
                System.out.println("后面拦拦...");
                return resObj;
            }
        };

        //切面 = 切点 + 通知
        Advisor advisor = new DefaultPointcutAdvisor(cut, advice);

        factory.addAdvisor(advisor);//给代理工厂一个切面
        SetterBean bean1 = (SetterBean) factory.getProxy();//从代理工厂中获取一个代理后的对象

        bean1.loginTest();

    }
}
