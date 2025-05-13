package vn.hoidanit.laptopshop.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;
import vn.hoidanit.laptopshop.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UserController{
    private UserService userService ;
   
    

    public UserController(UserService userService) {
        this.userService = userService;
       
    }


    @RequestMapping("/") //default is method get
    public String getHomePage(Model model){
        List<User> arrUser = this.userService.getALlUsersByEmail("taquanga6dp@gmail.com");
        System.out.println(arrUser);
    
        return "hello";
    }
    @RequestMapping("/admin/user")
    public String getUserListPage(Model model){
        List<User> users = this.userService.getALlUsers();
        int num0 = 0;
        model.addAttribute("num0", num0);
        model.addAttribute("user1", users);
        //System.out.println(users);
        return "admin/user/table-user";
    }
    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model,@PathVariable("id") long id){
        System.out.println("check path id= "+ id);
        model.addAttribute("id", id);
        User userDetail = this.userService.getUserById(id);
        model.addAttribute("userDetail", userDetail);
        return "admin/user/show";
       
    }
    @RequestMapping("/admin/user/update/{id}")
    public String getUserUpdatePage(Model model,@PathVariable("id") long id){
        System.out.println("check path id= "+ id);
        model.addAttribute("id", id);
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("currentUser", currentUser);
        return "admin/user/update";
       
    }
    

    @GetMapping("/admin/user/create") //get
    public String getCreateUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    
    @PostMapping("/admin/user/create")
    public String createUserPage(Model model,@ModelAttribute("newUser") User hoidanit){
        this.userService.handleSaveUser(hoidanit);
        return "redirect:/admin/user";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model,@ModelAttribute("currentUser") User updateUser){
         User checkUserExit = this.userService.getUserById(updateUser.getId());
         if(checkUserExit != null){
            checkUserExit.setAddress(updateUser.getAddress());
            //checkUserExit.setEmail(updateUser.getEmail());
            checkUserExit.setPhone(updateUser.getPhone());
            checkUserExit.setFullName(updateUser.getFullName());      
            
            userService.handleSaveUser(checkUserExit);
         }


        return  "redirect:/admin/user";
    }

    @GetMapping("admin/user/delete/{id}")
    public String confirmDeleteUser(Model model, @PathVariable("id") long id){
        final User user = new User();
        user.setId(id);
        model.addAttribute("willDeleteUser", user);

        return "admin/user/delete";
    }
    @PostMapping("/admin/user/delete")
    public String postDeleteUser(@ModelAttribute("willDeleteUser") User user ) {
        User isExitUser = this.userService.getUserById(user.getId());
        if(isExitUser != null){

            System.out.println(this.userService.handleDeleteUser(user.getId()));
            return "redirect:/admin/user";
        }else{
            return "admin/user/error404";
        }
        
        
    }
    


}

