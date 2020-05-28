package controllers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    public static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    private static Pattern pattern;
    private Matcher matcher;

    Logger logger = LogManager.getLogger("EmailController.class");

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @RequestMapping(value = "/home")
    public ModelAndView loadIndex() {
        return new ModelAndView("index");
    }

    private boolean checkEmail(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    @RequestMapping(value = "/home/result", method = RequestMethod.POST)
    public ModelAndView validateEmail (@RequestParam("email") String email, Model model) {
        ModelAndView result = new ModelAndView("result");
        logger.trace("bat dau vao validateEmail");
        boolean isValid = checkEmail(email);
        if (!isValid) {
            model.addAttribute("message", "Email is invalid");
            logger.trace("quay ve index");
            return loadIndex();
        }
        model.addAttribute("email", email);
        logger.trace("sang trang result");
        return result;
    }
}