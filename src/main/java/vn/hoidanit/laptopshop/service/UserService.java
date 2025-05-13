package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public String handleHello(){
        return "hello from service";
    }

    public List<User> getALlUsers(){
        return this.userRepository.findAll();
    }
    public List<User> getALlUsersByEmail(String email){
        return this.userRepository.findByEmail(email);
    }
    public User getUserById(long id){
        return this.userRepository.findUserById(id);
    }
    public User handleSaveUser(User user){
        User eric = this.userRepository.save(user);
        System.out.println(eric);
        return eric;
    }
    public boolean handleDeleteUser(long id){
        try {
            this.userRepository.deleteUserById(id);
            System.out.println("run here");
            return true;
        } catch (Exception e) {
          return false;
        }
      
    }
    
}
