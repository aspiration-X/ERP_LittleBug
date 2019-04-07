package com.littlebug.controller;

import com.littlebug.util.DeleteMessage;
import com.littlebug.util.FileMessage;
import com.littlebug.util.FileUploader;
import com.littlebug.util.UserMessage;
import org.springframework.stereotype.Controller;
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
 * @Description
 * @Date Created in 2019/4/7 14:09
 * @Modified By
 */
@Controller
@RequestMapping("/pic")
public class PictureUploadController {


//    private static String fileRealPath = "E:\\ERP_upload_file\\";

    @RequestMapping("/upload")
    @ResponseBody
    public FileMessage picUpload(MultipartFile uploadFile,
                                 String dir,
                                 HttpServletRequest request) {

//        String imgRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/image/product_img/");
        String imgRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");

        FileMessage fileMessage = new FileMessage();

        Map<String, String> map = new HashMap<>();

        String url = FileUploader.singleFileUpload(uploadFile, imgRealPath).get("pic");

        if (url != null) {
            fileMessage.setError(0);
            fileMessage.setUrl(url);
        }

        return fileMessage;
    }


    @RequestMapping("/delete")
    @ResponseBody
    public DeleteMessage picDelete(HttpServletRequest request,
                                   @RequestParam("picName") String picName) {

//        String imgRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/image/product_img/");

        String imgPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");

        DeleteMessage deleteMessage = new DeleteMessage();

        String filePath = imgPath + picName;

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
