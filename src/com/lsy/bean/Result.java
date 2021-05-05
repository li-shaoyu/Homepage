package com.lsy.bean;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName Result
 * @Description 将Java中的对象，转化为JSON格式字符串，用于返回给前端
 * @date 2021/5/3 21:28
 * @Param
 * @return
 */
public class Result {
    // 状态
    private int status;
    // 消息文字
    private String msg;
    // 数据
    private Object data;

    // 组装为JSON数据
    public String toJSON() {
        return JSON.toJSONString(this);
    }

    public Result() {
    }

    public Result(int status) {
        this.status = status;
    }

    public Result(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Result(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}