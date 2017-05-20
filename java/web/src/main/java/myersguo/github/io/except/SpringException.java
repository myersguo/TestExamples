package myersguo.github.io.except;


/**
 * Created by guoliangyong on 2017/5/19.
 * java web 异常类
 */
public class SpringException extends RuntimeException{
    private String exceptionMsg;
    public SpringException(String exceptionMsg){
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMsg(){
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
