package myersguo.github.io.dao.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by guoliangyong on 2017/5/23.
 */
public class User {
    //自增ID
    private long id;
    //用户名
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("name",name);
        return json.toString();
    }

}
