package myersguo.github.io.service;

import java.util.List;

import myersguo.github.io.dao.entity.User;

/**
 * Created by guoliangyong on 2017/5/23.
 */
public interface UserService {
    public List<User> finds(String name);

}
