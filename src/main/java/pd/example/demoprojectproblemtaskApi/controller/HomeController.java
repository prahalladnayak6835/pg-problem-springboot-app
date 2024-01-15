package pd.example.demoprojectproblemtaskApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pd.example.demoprojectproblemtaskApi.model.User;
import pd.example.demoprojectproblemtaskApi.service.UserService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/get-all-data")
    public String getAllModels(Model model) {
        List<User> users= userService.findAll();
        model.addAttribute("users", users);
        return "list-of-problems";
    }
    @GetMapping("/user/register")
    public String getRegister(){
        return "complain-register";
    }

    @PostMapping("/user/register")
    public String fillComplain(User user) {
        userService.save(user);
        return "success";
    }
    @GetMapping("/admin/edit/{id}")
    public String getEditForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "update-register";
    }

    @PostMapping("/admin/edit/{id}")
    public String updateComplain(@ModelAttribute("user") User user) {
        userService.update(user);
        // Redirect to the list of problems page
        return "redirect:/admin/get-all-data";
    }

//    public void test(){
//        final MessageBirdService apiKey = new MessageBirdServiceImpl("abcdroieuroie749283");
//        final MessageBirdClient messageBirdClient = new MessageBirdClient(apiKey);
//        List<BigInteger> phone = new ArrayList<>();
//        phone.add(new BigInteger("7847926856"));
//
//        try {
//            messageBirdClient.sendMessage("8903878343", "Hello", phone);
//        } catch (UnauthorizedException | GeneralException e) {
//            throw new RuntimeException(e);
//        }
//    }
    @RequestMapping("/user/delete/{id}")
    public String deleteComplain(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
