package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import demo.entity.AppUser;
import demo.dao.AppUserDao;
import java.util.List;
 
@Controller
@RequestMapping("/")
public class HelloWorldController {
	
    @Autowired
    private AppUserDao appUserDao;
    
    @RequestMapping(value="/appusers", method = RequestMethod.GET)
    public ModelAndView home() {
    	System.out.println("INTO HelloWorldController /appusers method");
        List<AppUser> listAppUsers = appUserDao.listAll();
        ModelAndView model = new ModelAndView("appusers");
        model.addObject("appUserList", listAppUsers);
        return model;
    }
 
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
    	System.out.println("INTO HelloWorldController /hello method");
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "welcome";
    }
 
    @RequestMapping(value="/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "welcome";
    }
 
}

