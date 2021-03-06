package com.littlebug.util;

/**
 * Created by huahua
 * Date 2019/4/4 Times 16:41
 */
public class UserMessage {
    private int status;
    private String msg;
    private String url;
    private int error;
    private String data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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
        return "UserMessage{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", url='" + url + '\'' +
                ", error=" + error +
                ", data='" + data + '\'' +
                '}';
    }
}
