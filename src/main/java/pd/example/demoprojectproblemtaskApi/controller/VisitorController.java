package pd.example.demoprojectproblemtaskApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pd.example.demoprojectproblemtaskApi.model.User;
import pd.example.demoprojectproblemtaskApi.service.UserService;

import java.util.List;

@Controller
public class VisitorController {
    @Autowired
    private UserService userService;


    @GetMapping("/visitor/get-all-data-for-visitor")
    public String getAllModels(Model model) {
        List<User> users= userService.findUser();
        model.addAttribute("users", users);
        return "visitor-list";
    }

    @GetMapping("/visitor")
    public String getNav(){
        return "visitor-site";
    }

}
