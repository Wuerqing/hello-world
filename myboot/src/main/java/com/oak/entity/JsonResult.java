package com.oak.entity;

public class JsonResult<T> {
    /**
     * 接口返回数据
     */
    private T data;
    /**
     * 状态码
     */
    private String code;
    /**
     * 提示信息
     */
    private String msg;

    /**
     * 没有数据返回，默认返回成功
     */
    public JsonResult(){
        this.code = "0";
        this.msg = "操作成功";
    }

    /**
     * 没有数据返回，可以人为设置状态码和提示信息
     * @param code
     * @param msg
     */
    public JsonResult(String code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    /**
     * 有数据返回，默认状态成功
     * @param data
     */
    public JsonResult(T data){
        this.data=data;
        this.code="0";
        this.msg="操作成功";
    }

    /**
     * 有数据返回，可以自定义提示信息，状态码默认0
     * @param data
     * @param msg
     */
    public JsonResult(T data,String msg){
        this.data = data;
        this.msg = msg;
        this.code = "0";
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
