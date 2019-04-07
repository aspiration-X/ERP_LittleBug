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
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
    public FileMessage fileUpload(MultipartFile file,
                                 HttpServletRequest request) {

//        String fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/image/product_img/");
        String fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");

        FileMessage fileMessage = new FileMessage();

        String fileType = "file";

        Map<String, String> map  = FileUploader.singleFileUpload(file, fileRealPath, fileType);

        String fileName = map.get(fileType);

        if (fileName != null) {

            String url = "/file/" + map.get("file");
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

        deleteMessage.setData("false");
        if (file.exists()) {
            if (file.delete()) {
                deleteMessage.setData("success");
            }
        }else {
            deleteMessage.setData("success");
        }

        return deleteMessage;
    }

    @RequestMapping("/download")
    @ResponseBody
    public void download(@RequestParam("fileName") String fileName,
                                HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        FileMessage fileMessage = new FileMessage();
        String dir = request.getSession().getServletContext().getRealPath("/WEB-INF/");
//        String realPath = request.getServletContext().getRealPath("/WEB-INF/file");
        String filePath = dir + fileName;
        File file = new File(filePath);

        if (!file.exists()){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("文件不存在");
            return;
        }

//        由于此处只是应用于小文件的io，所以暂时不使用reader，使用包装流即可
//        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        FileInputStream resourceAsStream = new FileInputStream(file);


        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        response.setContentType("application/octet-stream;charset=UTF-8");


        BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        BufferedInputStream inputStream = new BufferedInputStream(resourceAsStream);

        byte [] bytes = new byte[1024];
        int len = 0;
        while ( (len = inputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();
        resourceAsStream.close();
    }




}
