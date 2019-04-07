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


    public static Map<String, String> singleFileUpload(MultipartFile file, String realPath, String fileType){


        //判断存储 pic/file 对象文件夹是否存在
        String filePath = realPath + "/" + fileType;
        File dir = new File(filePath);
        if (!dir.exists()){
            dir.mkdir();
        }


        HashMap<String, String> map = new HashMap<>();

        String relativePath = FileUploader.saveFile(file, filePath);

        map.put(fileType, relativePath);

        return map;

    }


    public static Map<String, String> muiltFileUpload(MultipartFile[] files, String realPath, String fileType){

        HashMap<String, String> map = new HashMap<>();

        //判断存储 pic/file 对象文件夹是否存在
        String filePath = realPath + "/" + fileType;
        File dir = new File(filePath);
        if (!dir.exists()){
            dir.mkdir();
        }

        if(files!=null&&files.length>0){
            //循环获取file数组中得文件
            for(int i = 0;i<files.length;i++){
                MultipartFile file = files[i];
                System.out.println("fileName = " + file.getOriginalFilename() + " ;size = " + file.getSize());
                //保存文件
                String relativePath = FileUploader.saveFile(file, filePath);
                map.put(fileType, relativePath);
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
                int hashCode=file.getOriginalFilename().hashCode();
                String dir1=Integer.toHexString(hashCode&0XF);//计算第一级目录
                String dir2=Integer.toHexString((hashCode>>4)&0XF);//计算第二级目录

                String aimDir = filepath + "/"+dir1;

                if(!new File(aimDir).exists()){
                    new File(aimDir).mkdir();
                }

                aimDir = aimDir + "/" + dir2;
                if(!new File(aimDir).exists()){
                    new File(aimDir).mkdir();
                }

                String originalFilename = file.getOriginalFilename();

                relativePath = dir1 + "/" + dir2 +"/" + originalFilename;

                String savePath = realPath + "/" + relativePath;

                // 转存文件
                file.transferTo(new File(savePath));


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return relativePath;
    }
}
