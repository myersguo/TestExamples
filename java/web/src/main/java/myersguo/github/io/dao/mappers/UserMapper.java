package myersguo.github.io.dao.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import myersguo.github.io.dao.entity.User;

import java.util.List;


/**
 * Created by guoliangyong on 2017/5/23.
 */
public interface UserMapper {
//    @Select("SELECT * FROM users WHERE id =  #{userId}")
//    User getUser(@Param("userId") String userId);

    public List<User> selects(@Param("name")String name);
}
