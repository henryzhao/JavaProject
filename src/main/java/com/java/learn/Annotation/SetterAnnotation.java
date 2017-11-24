package com.java.learn.Annotation;

import java.lang.annotation.*;

/**
 * 要用到的注解（自定义注解）
 * Created by dell on 2017/11/24.
 */

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SetterAnnotation {
    //自定义注解
    public Class nation();
}
