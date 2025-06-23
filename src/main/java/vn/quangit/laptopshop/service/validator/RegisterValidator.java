package vn.quangit.laptopshop.service.validator;

import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.quangit.laptopshop.domain.dto.RegisterDTO;
import vn.quangit.laptopshop.service.UserService;

@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {

    private final UserService userService;

    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(RegisterDTO user, ConstraintValidatorContext context) {
        boolean valid = true;

        // Check firstName
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Họ không được để trống")
                    .addPropertyNode("firstName")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        // Check lastName
        if (user.getLastName() == null || user.getLastName().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Tên không được để trống")
                    .addPropertyNode("lastName")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        // Check email
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Email không được để trống")
                    .addPropertyNode("email")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        } else if (this.userService.checkEmailExist(user.getEmail())) {
            context.buildConstraintViolationWithTemplate("Email đã tồn tại")
                    .addPropertyNode("email")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        // Check password
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Mật khẩu không được để trống")
                    .addPropertyNode("password")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }else if (user.getConfirmPassword() == null || user.getConfirmPassword().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Xác nhận mật khẩu không được để trống")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }else  if (user.getPassword() != null && user.getConfirmPassword() != null
                && !user.getPassword().equals(user.getConfirmPassword())) {
         // Check if password and confirmPassword match
            context.buildConstraintViolationWithTemplate("Mật khẩu không khớp")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        return valid;
    }
}
