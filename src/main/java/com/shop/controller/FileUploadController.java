package com.shop.controller;

import com.shop.annotation.AnonymousPostMapping;
import com.shop.utils.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {

    /**
     * 数据保存到本地应用
     * 上传文件
     *
     * @param file
     * @return
     */
    @AnonymousPostMapping(value = "/upload", produces = "application/json;charset=utf8")
    public ResponseEntity upload(MultipartFile file) {
        String newFileName = FileUtils.upLoad(file);
        return new ResponseEntity(newFileName,HttpStatus.OK);
    }

}
