package com.admin4j.oss;

import com.admin4j.framework.web.pojo.R;
import com.admin4j.oss.entity.vo.UploadFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author andanyang
 * @since 2023/4/14 10:07
 */
@RestController
@RequestMapping("oss")
public class OssController {

    @Autowired
    UploadFileService uploadFileService;

    @PutMapping
    public R upload(MultipartFile file) throws IOException {


        UploadFileVO image = uploadFileService.upload("image", file);

        System.out.println("image = " + image);

        String previewUrl = uploadFileService.getPreviewUrl(image.getKey());

        System.out.println("previewUrl = " + previewUrl);

        return R.ok(image);
    }
}
