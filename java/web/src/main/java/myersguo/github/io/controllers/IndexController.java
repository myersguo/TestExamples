package myersguo.github.io.controllers;

import myersguo.github.io.except.SpringException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myersguo.github.io.service.UserService;
import myersguo.github.io.dao.entity.User;

import java.util.List;

@Controller
public class IndexController {

    @Resource
    private UserService userService;

    //@RequestMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(@RequestParam(required = false)String message,
                        ModelMap model/*, HttpServletRequest request,
                        HttpServletResponse response*/){
        String m = message;
        model.addAttribute("message", m);
        return "index/index";
    }

    @RequestMapping( value="/admin", method = RequestMethod.GET)
    public String admin() {
        return "redirect:/";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        //throw new SpringException("permission dennyed");
        List<User> userList = userService.finds("guo");
        model.addAttribute("message", userList.toString());
        return "index/index";
    }

    @RequestMapping("/test/test")
    @ResponseBody
    public String testtest(HttpServletRequest request,HttpServletResponse response)throws Exception {
        //throw new SpringException("permission dennyed");
        response.setHeader("content-type", "application/json;charset=utf-8");
        return userService.finds(   "guo").toString();
    }


    @RequestMapping("/403")
    @ExceptionHandler({SpringException.class})
    public void forbid(HttpServletRequest request,
                         HttpServletResponse response) {
        response.setStatus(403);
    }
}
