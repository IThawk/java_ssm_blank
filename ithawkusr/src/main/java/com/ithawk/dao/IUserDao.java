package com.ithawk.dao;

import com.ithawk.model.User;

public interface IUserDao {

    User selectUser(long id);

}