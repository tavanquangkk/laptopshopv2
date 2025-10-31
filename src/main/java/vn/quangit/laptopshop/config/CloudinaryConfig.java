package vn.quangit.laptopshop.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dc4qaf44w",
                "api_key", "818719868934531",
                "api_secret", "MsElWdlU1VEihLTSF6GvILn0dm0",
                "secure", true));
    }
}
