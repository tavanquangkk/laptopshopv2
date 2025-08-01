package vn.quangit.laptopshop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.IOException;
import java.util.Map;

@Service
public class UploadService {

    private final Cloudinary cloudinary;

    public UploadService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String handleSaveUploadFile(MultipartFile file, String targetFolder) {
        if (file.isEmpty()) {
            return "";
        }
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap(
                            "folder", targetFolder,  // thư mục trên Cloudinary
                            "resource_type", "auto"  // tự động nhận dạng loại file
                    ));
            // Lấy url ảnh sau khi upload
            return (String) uploadResult.get("secure_url");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
