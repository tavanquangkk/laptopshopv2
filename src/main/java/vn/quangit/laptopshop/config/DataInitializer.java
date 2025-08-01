package vn.quangit.laptopshop.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import vn.quangit.laptopshop.domain.Role;
import vn.quangit.laptopshop.domain.User;
import vn.quangit.laptopshop.repository.RoleRepository;
import vn.quangit.laptopshop.repository.UserRepository;
import vn.quangit.laptopshop.service.UserService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository; // repo cho entity Role
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public DataInitializer(RoleRepository roleRepository, UserRepository userRepository,
            PasswordEncoder passwordEncoder, UserService userService) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Tạo role nếu chưa có
        if (!roleRepository.existsByName("ROLE_ADMIN")) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
            System.out.println("Created ROLE_ADMIN");
        }

        if (!roleRepository.existsByName("ROLE_USER")) {
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
            System.out.println("Created ROLE_USER");
        }

        // Tạo tài khoản admin nếu chưa có
        String adminEmail = "admin@gmail.com";
        if (!userRepository.existsByEmail(adminEmail)) {
            User admin = new User();
            admin.setEmail(adminEmail);
            admin.setFullName("Administrator");
            admin.setPassword(passwordEncoder.encode("123"));
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            admin.setRole(adminRole);
            userRepository.save(admin);
            System.out.println("Admin account created with email: " + adminEmail);
        } else {
            System.out.println("Admin account already exists.");
        }
    }
}
