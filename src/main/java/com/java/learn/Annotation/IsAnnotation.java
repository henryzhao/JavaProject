package com.java.learn.Annotation;

import java.lang.annotation.*;

/**
 * 用来判断该类是否可以用来使用注入
 * 是不是注入类
 * Created by dell on 2017/11/24.
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface IsAnnotation {

}
