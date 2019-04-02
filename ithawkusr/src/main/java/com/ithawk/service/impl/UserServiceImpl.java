package com.ithawk.service.impl;

import com.ithawk.dao.IUserDao;
import com.ithawk.model.User;
import com.ithawk.service.IUserService;

import javax.annotation.Resource;

public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}