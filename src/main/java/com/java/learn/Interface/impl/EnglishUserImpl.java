package com.java.learn.Interface.impl;

import com.java.learn.Interface.IUser;

/**
 * 实现类：英文实现类
 * Created by dell on 2017/11/24.
 */
public class EnglishUserImpl implements IUser {
    @Override
    public void login() {
        System.out.println("English");
    }
}
