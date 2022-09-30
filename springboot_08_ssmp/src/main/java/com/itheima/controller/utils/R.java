package com.itheima.controller.utils;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object data;

    private String message;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(String msg){
        this.flag = false;
        this.message = msg;
    }

    public R(Boolean flag, String msg){
        this.flag = flag;
        this.message = msg;
    }
}
