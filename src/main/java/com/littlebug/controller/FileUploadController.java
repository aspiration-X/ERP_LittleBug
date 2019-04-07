package com.littlebug.controller;

import com.littlebug.util.DeleteMessage;
import com.littlebug.util.FileMessage;
import com.littlebug.util.FileUploader;
import com.littlebug.util.UserMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Darling
 * @Description 完成文件、图片上传功能
 * @Date Created in 2019/4/6 14:29
 * @Modified By
 */


@Controller
@RequestMapping("/file")
public class FileUploadController {

//    private static String imgRealPath = "E:\\ERP_upload_img\\";


    @RequestMapping("/upload")
    @ResponseBody
    public FileMessage picUpload(MultipartFile uploadFile,
                                 HttpServletRequest request) {

//        String fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/image/product_img/");
        String fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");

        FileMessage fileMessage = new FileMessage();

        Map<String, String> map  = FileUploader.singleFileUpload(uploadFile, fileRealPath);
        String url =  map.get("file");
        if (url != null) {
            fileMessage.setError(0);
            fileMessage.setUrl(url);
        }
        return fileMessage;
    }


    @RequestMapping("/delete")
    @ResponseBody
    public DeleteMessage fileDelete(HttpServletRequest request,
                                  @RequestParam("fileName") String fileName) {
//        String fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/image/product_img/");
        String fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");

        DeleteMessage deleteMessage = new DeleteMessage();

        String filePath = fileRealPath + fileName;

        File file = new File(filePath);

        deleteMessage.setDate("false");
        if (file.exists()) {
            if (file.delete()) {
                deleteMessage.setDate("success");
            }
        }else {
            deleteMessage.setDate("success");
        }

        return deleteMessage;
    }



}
