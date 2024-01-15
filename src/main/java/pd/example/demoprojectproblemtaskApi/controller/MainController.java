package pd.example.demoprojectproblemtaskApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pd.example.demoprojectproblemtaskApi.model.Status;
import pd.example.demoprojectproblemtaskApi.model.User;
import pd.example.demoprojectproblemtaskApi.service.UserService;

@Controller
public class MainController {
    @Autowired
    private UserService userService;


    @GetMapping("/get/{checkId}")
    public String getById(@RequestParam("checkId") Long id, Model model, Status status) {
        if (status.getCheckId() == null) {

            return "error";
        }

        if (userService.findAll().stream().filter(user1 -> user1.getId().equals(status.getCheckId())).findFirst().isEmpty()) {
            User users = userService.find(id);
            model.addAttribute("users", users);
            return "user-list";
        } else {
            return "redirect:/get-status";
        }
    }
    @GetMapping("/get-status")
    public String getStatus(){
        return "get-status";
    }
    @GetMapping("/user")
    public String getNav(){
        return "user-navigation-bar";
    }

    @GetMapping("/admin")
    public String getAdminNav(){
        return "admin-navigation-bar";
    }
}
