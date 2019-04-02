package com.ithawk.service;

import com.ithawk.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    public User selectUser(long userId);

}