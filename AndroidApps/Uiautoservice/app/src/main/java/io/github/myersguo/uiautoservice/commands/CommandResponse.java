package io.github.myersguo.uiautoservice.commands;


/**
 * Created by guoliangyong on 2017/5/2.
 */

public class CommandResponse {
    private Boolean result;
    private String start_time;
    private String execute_time;
    private String end_time;
    private String info;

    public CommandResponse(){
        Long tsLong = System.currentTimeMillis()/1000;
        this.start_time = tsLong.toString();
    }
    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setExecute_time() {
        Long tsLong = System.currentTimeMillis()/1000;
        this.end_time = tsLong.toString();
        Long diff = tsLong - Long.parseLong(this.start_time);
        this.execute_time = diff.toString();
    }



}
