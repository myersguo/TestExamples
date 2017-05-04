package io.github.myersguo.uiautoservice.commands;

import java.util.Map;

/**
 * Created by guoliangyong on 2017/5/2.
 */

public class CommandRequest {
    private String method;
    private String type;
    private Map<String, Object> params;
    private Map<String, String> result;

    public CommandRequest() {

    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }


}
