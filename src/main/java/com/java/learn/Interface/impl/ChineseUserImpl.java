package com.java.learn.Interface.impl;

import com.java.learn.Interface.IUser;

/**
 * 实现类：中文实现类
 * Created by dell on 2017/11/24.
 */
public class ChineseUserImpl implements IUser {
    @Override
    public void login() {
        System.out.println("中文");
    }
}
