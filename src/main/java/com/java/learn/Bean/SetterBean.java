package com.java.learn.Bean;

import com.java.learn.Interface.IUser;
import com.java.learn.Annotation.IsAnnotation;
import com.java.learn.Annotation.SetterAnnotation;
import com.java.learn.Interface.impl.ChineseUserImpl;
import com.java.learn.Interface.impl.EnglishUserImpl;

/**
 * 要注入的类的信息
 * Created by dell on 2017/11/24.
 */
@IsAnnotation
public class SetterBean {
    private IUser iUser;

    /**
     * 在这里进行依赖的注入和切面的编程
     * 可以通过设置不同的Class  ChineseUserImpl.class EnglishUserImpl.class
     * 来向方法S=setiUser里面注入
     * @param iUser
     */
    @SetterAnnotation(nation = ChineseUserImpl.class)
    public void setiUser(IUser iUser){
        this.iUser = iUser;
    }

    public void  loginTest(){
        iUser.login();
    }
}
