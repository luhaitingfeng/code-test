package com.moving.backend.pojo;

public class ResponseOutput<T> {

    private T data;
    private String msg;
    private String code;
    private Boolean success = false;
    private static final String OK = "OK";

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


    public static<T> ResponseOutput ok(){
        ResponseOutput<T> tResponseOutput = new ResponseOutput<>();
        tResponseOutput.setSuccess(true);
        tResponseOutput.setCode(OK);
        return tResponseOutput;
    }

    public static<T> ResponseOutput ok(T t){
        ResponseOutput<T> tResponseOutput = new ResponseOutput<>();
        tResponseOutput.setData(t);
        tResponseOutput.setSuccess(true);
        tResponseOutput.setCode(OK);
        return tResponseOutput;
    }

}
