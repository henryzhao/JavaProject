package com.java.learn.relfect;

import com.java.learn.Annotation.IsAnnotation;
import com.java.learn.Annotation.SetterAnnotation;
import com.java.learn.Bean.SetterBean;
import com.java.learn.Interface.IUser;
import com.java.learn.Interface.impl.ChineseUserImpl;

import java.lang.reflect.Method;

/**
 * 注解的解析类，类似于Spring里面的容器
 * Created by dell on 2017/11/24.
 */
public class SpringWine {
    public static SetterBean getBean() {

        // 新建一个SetterBean，新建的过程中，就已经通过自定义注解注入进去了中文还是英文
        SetterBean bean = new SetterBean();

        //判断这个类是不是注解类
        boolean isAnnotation = SetterBean.class.isAnnotationPresent(IsAnnotation.class);

        if (isAnnotation) {     //如果是注解类执行下面操作

            //获取SetterBean的方法
            Method[] method = SetterBean.class.getDeclaredMethods();

            //  SetterBean内的方法
            for ( int i= 0; i< method.length; i++ ){
                System.out.println(method[i]);
            }

            for (Method method2 : method) {
                if (method2.isAnnotationPresent(SetterAnnotation.class)) {
                    SetterAnnotation setterAnnotation = method2.getAnnotation(SetterAnnotation.class);
                    System.out.println("AnnotationTest(field=" + method2.getName()
                            + ",nation=" + setterAnnotation.nation() + ")");

                    try {
                        Class<ChineseUserImpl> clazz = setterAnnotation.nation();
                        IUser iuser = (IUser) clazz.newInstance();
                        bean.setiUser(iuser);

                        //return bean;
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return bean;
    }
}
