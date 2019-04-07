package com.littlebug.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/6 12:04
 * @Modified By
 */
public class FileUploader {


    public static Map<String, String> singleFileUpload(MultipartFile file, String realPath){

        HashMap<String, String> map = new HashMap<>();

        String relativePath = FileUploader.saveFile(file, realPath);

        map.put("pic", relativePath);

        return map;

    }


    public static Map<String, String> muiltFileUpload(MultipartFile[] files, String realPath){

        HashMap<String, String> map = new HashMap<>();

        if(files!=null&&files.length>0){
            //循环获取file数组中得文件
            for(int i = 0;i<files.length;i++){
                MultipartFile file = files[i];
                System.out.println("fileName = " + file.getOriginalFilename() + " ;size = " + file.getSize());
                //保存文件
                String relativePath = FileUploader.saveFile(file, realPath);
                map.put(file.getName(), relativePath);
            }
        }
        return map;
    }


    public static String saveFile(MultipartFile file, String realPath) {

        String relativePath = null;
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                //创建文件夹
                File filepath = new File(realPath);
                if (!filepath.exists())
                    filepath.mkdirs();
                // 文件保存路径
                String originalFilename = file.getOriginalFilename();

                // 文件后缀名
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

                relativePath = UUID.randomUUID().toString() + suffix;

                String savePath = realPath + relativePath;

                // 转存文件
                file.transferTo(new File(savePath));


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return relativePath;
    }
}
