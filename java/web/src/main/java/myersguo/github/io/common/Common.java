package myersguo.github.io.common;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guoliangyong on 2017/5/19.
 */
public class Common {
    public static String getIp(HttpServletRequest request) {
        String[] checkOrder = new String[] { request.getHeader("x-forwarded-for"),
                request.getHeader("HTTP_X_FORWARDED_FOR"), request.getHeader("REMOTE_ADDR"),
                request.getHeader("Proxy-Client-IP"), request.getHeader("WL-Proxy-Client-IP"), request.getRemoteAddr() };

        String ip = null;
        for (String item : checkOrder) {
            if (item != null && item.length() != 0 && !"unknown".equalsIgnoreCase(item)) {
                ip = item;
                break;
            }
        }

        return ip;
    }
}
