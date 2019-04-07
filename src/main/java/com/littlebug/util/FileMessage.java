package com.littlebug.util;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/7 14:31
 * @Modified By
 */
public class FileMessage {

    private String url;
    private int error;
    private String data;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FileMessage{" +
                "url='" + url + '\'' +
                ", error=" + error +
                ", data='" + data + '\'' +
                '}';
    }
}
