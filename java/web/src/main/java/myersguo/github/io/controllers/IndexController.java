package myersguo.github.io.controllers;

import myersguo.github.io.except.SpringException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Controller
public class IndexController {
    //@RequestMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model/*, HttpServletRequest request,
                        HttpServletResponse response*/){
        model.addAttribute("message", "myersguo");
        return "index/index";
    }

    @RequestMapping( value="/admin", method = RequestMethod.GET)
    public String admin() {
        return "redirect:/";
    }

    @RequestMapping("/test")
    @ExceptionHandler({SpringException.class})
    public String test() {
        throw new SpringException("permission dennyed");
    }
}
