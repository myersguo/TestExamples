package myersguo.github.io.service.impl;

import myersguo.github.io.dao.entity.User;
import myersguo.github.io.dao.mappers.UserMapper;
import myersguo.github.io.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

import javax.annotation.Resource;


@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> finds(String name){
        return userMapper.selects(name);
    }



}
